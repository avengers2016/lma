package com.lma.model;

import java.util.List;

public class TansactionsDetails {
	
	Amount amount;
	
	private String description;
	private String type;
	private String custom;
	private String invoiceNumber;
	private String allowedPaymentMethod;	
	private String softDescriptor;
	
	private List<ItemList> itemList;
	/**
	 * @return the amount
	 */
	public Amount getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the custom
	 */
	public String getCustom() {
		return custom;
	}
	/**
	 * @param custom the custom to set
	 */
	public void setCustom(String custom) {
		this.custom = custom;
	}
	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	/**
	 * @param invoiceNumber the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	/**
	 * @return the allowedPaymentMethod
	 */
	public String getAllowedPaymentMethod() {
		return allowedPaymentMethod;
	}
	/**
	 * @param allowedPaymentMethod the allowedPaymentMethod to set
	 */
	public void setAllowedPaymentMethod(String allowedPaymentMethod) {
		this.allowedPaymentMethod = allowedPaymentMethod;
	}
	/**
	 * @return the softDescriptor
	 */
	public String getSoftDescriptor() {
		return softDescriptor;
	}
	/**
	 * @param softDescriptor the softDescriptor to set
	 */
	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}
	/**
	 * @return the itemList
	 */
	public List<ItemList> getItemList() {
		return itemList;
	}
	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<ItemList> itemList) {
		this.itemList = itemList;
	}	

}
