/**
 * 
 */
package com.lma.model;

import java.util.List;

/**
 * @author RAHUL
 *
 */
public class CustomerContract {
	
	List<CustomerTransactionsDetails> customerTransactionsDetails;

	/**
	 * @return the customerTransactionsDetails
	 */
	public List<CustomerTransactionsDetails> getCustomerTransactionsDetails() {
		return customerTransactionsDetails;
	}

	/**
	 * @param customerTransactionsDetails the customerTransactionsDetails to set
	 */
	public void setCustomerTransactionsDetails(
			List<CustomerTransactionsDetails> customerTransactionsDetails) {
		this.customerTransactionsDetails = customerTransactionsDetails;
	}
	
	

}
