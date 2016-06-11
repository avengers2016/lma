package com.lma.controller;



import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lma.helper.MessageHelper;
import com.lma.model.CustomerContract;
import com.lma.model.CustomerTransactionsDetails;
import com.lma.model.ItemList;
import com.lma.model.PersonalInfo;
import com.lma.model.ProfessionalInfo;
import com.lma.model.ShippingAddress;
import com.lma.model.TansactionsDetails;
import com.lma.utilities.StoreRetriveDataFrmHadoopSys;

@Controller

public class ProductController {
	
	/*
		@RequestMapping(value = "/getDetails", method = RequestMethod.GET)
		@ResponseBody
		public String getDetailsAsJson() {
			
			String transJsonData = getTransactionDetails();
			CustomerContract CustomerContract =  new  CustomerContract();
		
			try{
			
			String transDataFrmHadoopSys = StoreRetriveDataFrmHadoopSys.getDataFrmHadoomSys();		
			
			PersonalInfo personalInfo = null;	
			List<PersonalInfo> personalInfoList = new ArrayList<PersonalInfo>();
			
			ProfessionalInfo professionalInfo=null;
				
			TansactionsDetails tansactionsDetails=null;
			List<TansactionsDetails> tansactionsDetailsList = new ArrayList<TansactionsDetails>(); 
			
			ItemList item = null;
			List<ItemList> itemList=new ArrayList<ItemList>();
			
			ShippingAddress shippingAddress = null;		
			
			
		   for(int i=0;i<5;i++){
		    personalInfo = new PersonalInfo();
		    personalInfo.setFirstName("John"+i);
		    personalInfo.setLastName("Doe"+i);
		    personalInfo.setStreet1("1295 Charleston Rd."+i);
		    personalInfo.setStreet2("1295 Charleston Rd."+i);
		    personalInfo.setCity("Mountain View"+i);
		    personalInfo.setState("liverpool"+i);
		    personalInfo.setPostalCode("nn4 7sg"+i);
		    personalInfo.setCountry("UK"+i);
		    personalInfo.setPhoneNumber("650-965-6000"+i);
		    personalInfo.setMobileNumber("650-965-6000"+i);
		    personalInfo.setEmail("avenges2016.lma@gmail.com"+i);
		  //  personalInfo.setEmail1("jdoe@example.com"+i);
		    personalInfo.setMaratialStatus("Single");
		    personalInfo.setChildren("2"+i);		
			
			
		    professionalInfo = new ProfessionalInfo();
		    professionalInfo.setCompanyType("cognizant");
		    professionalInfo.setDesignation("");
		    professionalInfo.setSalary("");
		    professionalInfo.setYearOfExp("");
		    
		    personalInfo.setProfessionalInfo(professionalInfo);
		    
			
			for(int j=0;j<3;j++){
				
				int[] day ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
				int[] month = {1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11,12,1,2};
				int[] year = {2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2015,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016,2016};
				
				
				tansactionsDetails = new TansactionsDetails();				
				tansactionsDetails.setDescription("This is the payment transaction description."+i);
				tansactionsDetails.setType("travel"+i);		
				tansactionsDetails.setCustom("EMS_90048630024435"+i);
				tansactionsDetails.setInvoiceNumber("48787589677"+i);
				tansactionsDetails.setAllowedPaymentMethod("INSTANT_FUNDING_SOURCE"+i);
				tansactionsDetails.setSoftDescriptor("ECHI5786786"+i);
				tansactionsDetails.setBillingDate(day[i]+"-"+month[i]+"-"+year[i]);
				tansactionsDetails.setTotalAmount("10"+i);
				
				
				tansactionsDetailsList.add(tansactionsDetails);
				
				
				for(int k=0;k<1;k++){
					
					item = new ItemList();
					item.setName("bowling"+j);
					item.setDescription("Bowling Team Shirt"+j);
					item.setPrice("5"+j);
					item.setQuantity("3"+j);
					item.setTax("0.03");
					item.setCurrency("GBP");					
					itemList.add(item);
					
				}			
				
				
				
				shippingAddress = new ShippingAddress();
				shippingAddress.setRecipientName("Betsy Buyer"+j);
				shippingAddress.setLine1("111 First Street"+j);
				shippingAddress.setCity("Saratoga"+j);
				shippingAddress.setCountryCode("UK"+j);
				shippingAddress.setPostalCode("95070"+j);
				shippingAddress.setState("glassgow"+j);					
				
				tansactionsDetails.setShippingAddress(shippingAddress);
				//tansactionsDetails.setItemList(itemList);
				
				
			}
			
			 personalInfo.setTansactionsDetails(tansactionsDetailsList);		   
			 personalInfoList.add(personalInfo);
			  
			
			}
		    
		  
		   CustomerContract.setPersonalInfo(personalInfoList);	
		   
		   
			
			CustomerContract.setPersonalInfo(personalInfoList);
			personalInfo.setTansactionsDetails(tansactionsDetailsList);
			tansactionsDetails.setItemList(itemList);
			item.setShippingAddress(shippingAddress);		
			}catch(Exception ex){
				
			}
			return MessageHelper.toJsonString(CustomerContract);
		    
			return MessageHelper.toJsonString(CustomerContract);
		}	
		*/
		
		@RequestMapping(value = "/getDetails", method = RequestMethod.GET)
		@ResponseBody
		public String getTransactionDetails(){
			
		CustomerContract customerContract = new CustomerContract();

		List<CustomerContract> customerContractList = new ArrayList<CustomerContract>();

		TansactionsDetails tansactionsDetails = null;
		List<TansactionsDetails> tansactionsDetailsList = new ArrayList<TansactionsDetails>();

		ItemList item = null;
		List<ItemList> itemList = new ArrayList<ItemList>();

		ShippingAddress shippingAddress = null;

		PersonalInfo personalInfo = null;
		ProfessionalInfo professionalInfo = null;

		personalInfo = new PersonalInfo();
		personalInfo.setFirstName("John");
		personalInfo.setLastName("Doe");
		personalInfo.setPostalCode("nn4 7sg");
		personalInfo.setCountry("UK");
		personalInfo.setPhoneNumber("650-965-6000");
		personalInfo.setMobileNumber("650-965-6000");
		personalInfo.setEmail("avenges2016.lma@gmail.com");
		personalInfo.setMaratialStatus("Single");
		personalInfo.setChildren("2");

		professionalInfo = new ProfessionalInfo();
		professionalInfo.setCompanyType("cognizant");
		professionalInfo.setDesignation("");
		professionalInfo.setSalary("");
		professionalInfo.setYearOfExp("");		
		
		customerContract.setPersonaInfo(personalInfo);

		customerContract.setProfessionaInfo(professionalInfo);

		tansactionsDetails = new TansactionsDetails();
		tansactionsDetails.setDescription("This is the payment transaction description.");
		tansactionsDetails.setType("travel");
		tansactionsDetails.setCustom("EMS_90048630024435");
		tansactionsDetails.setInvoiceNumber("48787589677");
		tansactionsDetails.setAllowedPaymentMethod("INSTANT_FUNDING_SOURCE");
		tansactionsDetails.setSoftDescriptor("ECHI5786786");
		tansactionsDetails.setBillingDate("");
		tansactionsDetails.setTotalAmount("10");

		shippingAddress = new ShippingAddress();
		shippingAddress.setRecipientName("Betsy Buyer");
		shippingAddress.setLine1("111 First Street");
		shippingAddress.setCity("Saratoga");
		shippingAddress.setCountryCode("UK");
		shippingAddress.setPostalCode("95070");
		shippingAddress.setState("glassgow");

		tansactionsDetails.setShippingAddress(shippingAddress);

		tansactionsDetailsList.add(tansactionsDetails);

		tansactionsDetails = new TansactionsDetails();
		tansactionsDetails
				.setDescription("This is the payment transaction description.");
		tansactionsDetails.setType("shopping");
		tansactionsDetails.setCustom("EMS_90048630024435");
		tansactionsDetails.setInvoiceNumber("48787589677");
		tansactionsDetails.setAllowedPaymentMethod("INSTANT_FUNDING_SOURCE");
		tansactionsDetails.setSoftDescriptor("ECHI5786786");
		tansactionsDetails.setBillingDate("20-1-2016");
		tansactionsDetails.setTotalAmount("20");

		shippingAddress = new ShippingAddress();
		shippingAddress.setRecipientName("Betsy Buyer");
		shippingAddress.setLine1("111 First Street");
		shippingAddress.setCity("Saratoga");
		shippingAddress.setCountryCode("UK");
		shippingAddress.setPostalCode("95070");
		shippingAddress.setState("glassgow");

		tansactionsDetails.setShippingAddress(shippingAddress);

		tansactionsDetailsList.add(tansactionsDetails);

		personalInfo.setTansactionsDetails(tansactionsDetailsList);

		customerContractList.add(customerContract);

		return MessageHelper.toJsonString(customerContractList);
		}
		
}
