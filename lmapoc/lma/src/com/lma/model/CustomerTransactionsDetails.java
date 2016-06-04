/**
 * 
 */
package com.lma.model;

import java.util.List;

/**
 * @author RAHUL
 *
 */
public class CustomerTransactionsDetails {
	
	private PersonalInfo personalInfo;
	
	private List<TansactionsDetails> TansactionsDetails;

	/**
	 * @return the personalInfo
	 */
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	/**
	 * @param personalInfo the personalInfo to set
	 */
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	/**
	 * @return the tansactionsDetails
	 */
	public List<TansactionsDetails> getTansactionsDetails() {
		return TansactionsDetails;
	}

	/**
	 * @param tansactionsDetails the tansactionsDetails to set
	 */
	public void setTansactionsDetails(List<TansactionsDetails> tansactionsDetails) {
		TansactionsDetails = tansactionsDetails;
	}
	
	

}
