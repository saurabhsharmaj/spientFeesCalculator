package com.sapient.feecalculator;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sapient.feecalculator.Constant.TRANSACTIONTYPE;

public class Utils {

	public static Double parseMarketValue(String marketValue) {
		try{// TODO Auto-generated method stub
			return Double.parseDouble(marketValue);
		}catch(Exception ex){
			return (double) 0;
		}
	}

	public static Boolean getPriority(String priority) {
		if(priority!= null){
			priority = priority.trim();
			if(priority.equals("Y")||priority.equals("y")){
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
	}

	public static Date parseDate(String date) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date convertedCurrentDate = sdf.parse(date);
			System.out.println(convertedCurrentDate);
			return convertedCurrentDate;
		}catch(Exception  ex){
			return null;
		}
	}

	public static Integer parseTransactionType(String type) {
		if(type.equals("BUY")){
			return TRANSACTIONTYPE.BUY.getType();
		}if(type.equals("SELL")){
			return TRANSACTIONTYPE.SELL.getType();
		}if(type.equals("DEPOSIT")){
			return TRANSACTIONTYPE.DEPOSIT.getType();
		}if(type.equals("WITHDRAW")){
			return TRANSACTIONTYPE.WITHDRAW.getType();
		}
		return null;}

	public static String getTypeName(Integer transactionType) {
		if(transactionType==TRANSACTIONTYPE.BUY.getType()){
			return TRANSACTIONTYPE.BUY.getName()+"\t";
		} else if(transactionType==TRANSACTIONTYPE.SELL.getType()){
			return TRANSACTIONTYPE.SELL.getName()+"\t";
		} else if(transactionType==TRANSACTIONTYPE.DEPOSIT.getType()){
			return TRANSACTIONTYPE.DEPOSIT.getName();
		} else if(transactionType==TRANSACTIONTYPE.WITHDRAW.getType()){
			return TRANSACTIONTYPE.WITHDRAW.getName();
		}
		return null;
	}
}
