import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lma.model.CustomerContract;
import com.lma.model.CustomerTransactionsDetails;
import com.lma.model.ItemList;
import com.lma.model.PersonalInfo;
import com.lma.model.ShippingAddress;
import com.lma.model.TansactionsDetails;


public class GenerateJsonObject {
	
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		CustomerContract CustomerContract =  new  CustomerContract();
		List<CustomerTransactionsDetails>  customerTransactionsDetails =  new ArrayList<CustomerTransactionsDetails>();
		
		CustomerTransactionsDetails CustomerTransactionsDetails1 = new  CustomerTransactionsDetails();
		CustomerTransactionsDetails CustomerTransactionsDetails2 = new  CustomerTransactionsDetails();
		
		PersonalInfo personalInfo1 = new PersonalInfo();		
			
		personalInfo1.setFirstName("John");
		personalInfo1.setLastName("Doe");
		personalInfo1.setStreet1("1295 Charleston Rd.");
		personalInfo1.setStreet2("1295 Charleston Rd.");
		personalInfo1.setCity("Mountain View");
		personalInfo1.setState("liverpool");
		personalInfo1.setPostalCode("nn4 7sg");
		personalInfo1.setCountry("UK");
		personalInfo1.setPhoneNumber("650-965-6000");
		personalInfo1.setMobileNumber("650-965-6000");
		personalInfo1.setEmail("avenges2016.lma@gmail.com");
		personalInfo1.setEmail1("jdoe@example.com");
		personalInfo1.setMaratialStatus("Single");
		personalInfo1.setChildren("2");
		
		
		//PersonalInfo personalInfo2 = new PersonalInfo();
		
		CustomerTransactionsDetails1.setPersonalInfo(personalInfo1);
		//CustomerTransactionsDetails2.setPersonalInfo(personalInfo2);
		customerTransactionsDetails.add(CustomerTransactionsDetails1);
		//customerTransactionsDetails.add(CustomerTransactionsDetails2);
		
		CustomerContract.setCustomerTransactionsDetails(customerTransactionsDetails);
		
		
		List<TansactionsDetails> tansactionsDetails = new ArrayList<TansactionsDetails>();
		
		TansactionsDetails tansactionsDetails1 = new TansactionsDetails();
		tansactionsDetails1.setDescription("This is the payment transaction description.");
		tansactionsDetails1.setType("travel");		
		tansactionsDetails1.setCustom("EMS_90048630024435");
		tansactionsDetails1.setInvoiceNumber("48787589677");
		tansactionsDetails1.setAllowedPaymentMethod("INSTANT_FUNDING_SOURCE");
		tansactionsDetails1.setSoftDescriptor("ECHI5786786");
		
		//TansactionsDetails tansactionsDetails2 = new TansactionsDetails();
		tansactionsDetails.add(tansactionsDetails1);
		//tansactionsDetails.add(tansactionsDetails2);
		
		CustomerTransactionsDetails1.setTansactionsDetails(tansactionsDetails);
		
		List<ItemList> itemList = new ArrayList<ItemList>();
		
			
		ItemList itemList1 = new ItemList();
		itemList1.setName("bowling");
		itemList1.setDescription("Bowling Team Shirt");
		itemList1.setPrice("5");
		itemList1.setQuantity("3");
		itemList1.setTax("0.03");
		itemList1.setCurrency("GBP");
		
		//ItemList itemList2 = new ItemList();
		itemList.add(itemList1);
		//itemList.add(itemList2);
		
		tansactionsDetails1.setItemList(itemList);
		
		
		ShippingAddress shippingAddress = new ShippingAddress();
		shippingAddress.setRecipientName("Betsy Buyer");
		shippingAddress.setLine1("111 First Street");
		shippingAddress.setCity("Saratoga");
		shippingAddress.setCountryCode("UK");
		shippingAddress.setPostalCode("95070");
		shippingAddress.setState("glassgow");
		
		itemList1.setShippingAddress(shippingAddress);
		
		
		try {
		   
		   System.out.println( mapper.writeValueAsString(CustomerContract));
		}

		  // catch various errors
		  catch (JsonGenerationException e) {
		    e.printStackTrace();
		} 
		  catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
