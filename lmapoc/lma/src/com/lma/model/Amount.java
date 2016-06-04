/**
 * 
 */
package com.lma.model;

/**
 * @author RAHUL
 *
 */
public class Amount {

	String totalAmount;
	String currency;
	AmountDetails amountDetails;
	/**
	 * @return the totalAmount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the amountDetails
	 */
	public AmountDetails getAmountDetails() {
		return amountDetails;
	}
	/**
	 * @param amountDetails the amountDetails to set
	 */
	public void setAmountDetails(AmountDetails amountDetails) {
		this.amountDetails = amountDetails;
	}
	
	
}
