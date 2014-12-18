package com.sapient.feecalculator.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sapient.feecalculator.Constant.TRANSACTIONFEES;
import com.sapient.feecalculator.Constant.TRANSACTIONTYPE;
import com.sapient.feecalculator.Transaction;
import com.sapient.feecalculator.Utils;

/**
 * 
 * @author saurabhsharma01
 *
 */
public abstract class AbstractTransactionReader {

	/**
	 * 
	 */
	public List<Transaction> transactionList;

	/**
	 * 
	 */
	public abstract void readTransaction(File transactionFile);

	/**
	 * This method will save the transaction into list.
	 * later on in database.
	 * @param transaction
	 */
	public void saveTransaction(Transaction transaction){

		if(transactionList==null){
			transactionList = new ArrayList<Transaction>();
		}

		transactionList.add(calculateTransactionFee(transaction));

	}

	/**
	 * This method will be update the fee according to transaction.
	 * @param transaction
	 */
	private Transaction calculateTransactionFee(Transaction transaction) {
		if(isIntradayTransaction(transaction)){
			transaction.setTransactionFees(TRANSACTIONFEES.TEN.getFees());
		} else {

			if(transaction.getPriority()){
				transaction.setTransactionFees(TRANSACTIONFEES.FIVE_HUNDREAD.getFees());

			} else{				
				if(transaction.getTransactionType() == TRANSACTIONTYPE.SELL.getType() ||
						transaction.getTransactionType() == TRANSACTIONTYPE.WITHDRAW.getType()){

					transaction.setTransactionFees(TRANSACTIONFEES.HUNDREAD.getFees());

				} else if(transaction.getTransactionType() == TRANSACTIONTYPE.BUY.getType() ||
						transaction.getTransactionType() == TRANSACTIONTYPE.DEPOSIT.getType()){

					transaction.setTransactionFees(TRANSACTIONFEES.FIFTY.getFees());			
				}

			}

		}
		return transaction;
	}

	/**
	 * This method cheack weather transction is IntraDay or not.
	 * @param transaction
	 * @return
	 */
	private boolean isIntradayTransaction(Transaction transaction) {
		boolean isIntraDayTransaction= false;
		Transaction temp = null;
		if(transactionList.size() > 0 ){
			for (Transaction trans : transactionList) {
				if(trans.getClientId().equals(transaction.getClientId())&&
						trans.getSecurityId().equals(transaction.getSecurityId()) &&
						trans.getTransactionDate().equals(transaction.getTransactionDate())){
					if((trans.getTransactionType()==TRANSACTIONTYPE.BUY.getType() && 
							transaction.getTransactionType()==TRANSACTIONTYPE.SELL.getType()) ||
							(trans.getTransactionType()==TRANSACTIONTYPE.SELL.getType() && 
							transaction.getTransactionType()==TRANSACTIONTYPE.BUY.getType())){
						isIntraDayTransaction= true;
						temp= trans;						
						break;
					}
				}

			}

			if(temp!=null){
				transactionList.remove(temp);
				temp.setTransactionFees(TRANSACTIONFEES.TEN.getFees());
				transactionList.add(temp);
			}

		} else {
			isIntraDayTransaction= false;
		}

		return isIntraDayTransaction;
	}

	/**
	 * 
	 * @param transactionAttributes
	 * @return
	 */
	public Transaction getTransaction(String[] transactionAttributes) {	
		for (String string : transactionAttributes) {
			System.out.print(" "+string);
		}
		Transaction transaction = new Transaction();
		transaction.setExternalTransactionID(transactionAttributes[0]);
		transaction.setClientId(transactionAttributes[1]);
		transaction.setSecurityId(transactionAttributes[2]);
		transaction.setTransactionType(Utils.parseTransactionType(transactionAttributes[3]));
		transaction.setTransactionDate(Utils.parseDate(transactionAttributes[4]));
		transaction.setMarketValue(Utils.parseMarketValue(transactionAttributes[5]));
		transaction.setPriority(Utils.getPriority(transactionAttributes[6]));
		return transaction;
	}

	/**
	 * This method will be display TransactionReport.
	 */
	public void displayTransactionReport(){
		Collections.sort(transactionList,new Transaction());
		System.out.println("Calculated Fees:-");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Client Id | Transaction Type | Transaction Date | Priority | Processing Fee    |");
		for (Transaction transaction : transactionList) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(transaction.getClientId()+"\t| "+Utils.getTypeName(transaction.getTransactionType())+"\t| "+
					transaction.getTransactionDate()+"\t| "+(transaction.getPriority()?"HIGH\t":"NORMAL")+ "\t| "+
					transaction.getTransactionFees()+"\t|");
		}
		System.out.println("--------------------------------------------------------------------------------");
	}
}
