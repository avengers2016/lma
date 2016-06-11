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
	
	private List<PersonalInfo> personalInfo;
	private List<ProfessionalInfo> professionalInfo;
	
	private PersonalInfo personaInfo;
	private ProfessionalInfo professionaInfo;
	

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

	public List<PersonalInfo> getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(List<PersonalInfo> personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<ProfessionalInfo> getProfessionalInfo() {
		return professionalInfo;
	}

	public void setProfessionalInfo(List<ProfessionalInfo> professionalInfo) {
		this.professionalInfo = professionalInfo;
	}

	public PersonalInfo getPersonaInfo() {
		return personaInfo;
	}

	public void setPersonaInfo(PersonalInfo personaInfo) {
		this.personaInfo = personaInfo;
	}

	public ProfessionalInfo getProfessionaInfo() {
		return professionaInfo;
	}

	public void setProfessionaInfo(ProfessionalInfo professionaInfo) {
		this.professionaInfo = professionaInfo;
	}
}
