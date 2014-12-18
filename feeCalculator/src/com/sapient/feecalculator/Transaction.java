package com.sapient.feecalculator;

import java.util.Comparator;


public class Transaction implements Comparator<Transaction> {

	private String externalTransactionID;
	private String clientId;
	private String securityId;
	private Integer transactionType;
	private java.util.Date transactionDate;	
	private Double marketValue;	
	private Boolean priority;//True:Normal | False: High
	private Double transactionFees;
	public String getExternalTransactionID() {
		return externalTransactionID;
	}
	public void setExternalTransactionID(String externalTransactionID) {
		this.externalTransactionID = externalTransactionID;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public Integer getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}
	public java.util.Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(java.util.Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}
	public Boolean getPriority() {
		return priority;
	}
	public void setPriority(Boolean priority) {
		this.priority = priority;
	}
	public Double getTransactionFees() {
		return transactionFees;
	}
	public void setTransactionFees(Double transactionFees) {
		this.transactionFees = transactionFees;
	}
	@Override
	public String toString() {
		return "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"+"\nTransaction [externalTransactionID=" + externalTransactionID
				+ "\t| clientId=" + clientId + "\t| securityId=" + securityId
				+ "\t| transactionType=" + transactionType + "\t| transactionDate="
				+ transactionDate + "\t| marketValue=" + marketValue
				+ "\t| priority=" + priority + "\t| transactionFees="
				+ transactionFees + "]";
	}
	@Override
	public int compare(Transaction trans1, Transaction trans2) {
		
		int value1 = trans1.getClientId().compareTo(trans2.getClientId());
		if (value1 == 0) {
			int value2 = trans1.getTransactionType().compareTo(trans2.getTransactionType());
			if (value2 == 0) {
				int value3 = trans1.getTransactionDate().compareTo(trans2.getTransactionDate());
				if (value3 == 0) {
					return trans1.getPriority().compareTo(trans2.getPriority());
				} else {
					return value3;
				}

			} else {
				return value2;
			}
		}
		return value1;

	}


}
