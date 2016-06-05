import java.io.File;
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
		
		PersonalInfo personalInfo1 = null;		
			
		for(int i=0;i<20;i++){
		personalInfo1 = new PersonalInfo();
		personalInfo1.setFirstName("John"+i);
		personalInfo1.setLastName("Doe"+i);
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
		CustomerTransactionsDetails1.setPersonalInfo(personalInfo1);
		customerTransactionsDetails.add(CustomerTransactionsDetails1);
		
		}		
		
			
		CustomerContract.setCustomerTransactionsDetails(customerTransactionsDetails);
		
		
		List<TansactionsDetails> tansactionsDetails = new ArrayList<TansactionsDetails>();
		List<ItemList> itemList = new ArrayList<ItemList>();
		
		TansactionsDetails tansactionsDetails1=null;
		
		for(int i=0;i<50;i++){
		
		tansactionsDetails1= new TansactionsDetails();
		tansactionsDetails1.setDescription("This is the payment transaction description."+i);
		tansactionsDetails1.setType("travel"+i);		
		tansactionsDetails1.setCustom("EMS_90048630024435"+i);
		tansactionsDetails1.setInvoiceNumber("48787589677"+i);
		tansactionsDetails1.setAllowedPaymentMethod("INSTANT_FUNDING_SOURCE"+i);
		tansactionsDetails1.setSoftDescriptor("ECHI5786786"+i);
		tansactionsDetails.add(tansactionsDetails1);
		
		ItemList itemList1 =null;
		
		for(int j=0;j<5;j++){	
			itemList1 = new ItemList();
			itemList1.setName("bowling"+j);
			itemList1.setDescription("Bowling Team Shirt"+j);
			itemList1.setPrice("5"+j);
			itemList1.setQuantity("3"+j);
			itemList1.setTax("0.03");
			itemList1.setCurrency("GBP");		
			itemList.add(itemList1);
			
			ShippingAddress shippingAddress = new ShippingAddress();
			shippingAddress.setRecipientName("Betsy Buyer");
			shippingAddress.setLine1("111 First Street");
			shippingAddress.setCity("Saratoga");
			shippingAddress.setCountryCode("UK");
			shippingAddress.setPostalCode("95070");
			shippingAddress.setState("glassgow");			
			itemList1.setShippingAddress(shippingAddress);
			
			}
			
			tansactionsDetails1.setItemList(itemList);
		}
		
		
		CustomerTransactionsDetails1.setTansactionsDetails(tansactionsDetails);		
		
		
		try {
		   mapper.writeValue(new File("D:\\JsonWith20Data.json"), CustomerContract);
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
