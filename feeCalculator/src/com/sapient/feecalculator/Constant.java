package com.sapient.feecalculator;

/**
 * 
 * @author saurabhsharma01
 *
 */
public class Constant {
	public enum FILETYPE  {
		CSV(1),XML(2),TEXT(3);
		int type;
		FILETYPE(int type){
			this.type= type;
		}
		public boolean getValue() {
			// TODO Auto-generated method stub
			return false;
		}
	}
	/*
	 * Define Fees for Transaction.
	 */
	public enum TRANSACTIONFEES {		
		FIVE_HUNDREAD(500),HUNDREAD(100),FIFTY(50),TEN(10);
		private double fees;
		TRANSACTIONFEES(double fees) {
			this.fees = fees;
		}
		public double getFees() {
			return fees;
		} 
	};
	
	public enum TRANSACTIONTYPE {
		BUY("BUY",1),SELL("SELL",2),DEPOSIT("DEPOSITE",3),WITHDRAW("WITHDRAW",4);
		private int type;
		private String name;
		TRANSACTIONTYPE(String name, int type) {
			this.name = name;
			this.type = type;
		}
		
		public int getType() {
			return type;
		}
		public String getName(){
			return  name;
		}
	};
}
