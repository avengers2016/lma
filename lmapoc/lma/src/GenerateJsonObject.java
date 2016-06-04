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
		PersonalInfo personalInfo2 = new PersonalInfo();
		
		CustomerTransactionsDetails1.setPersonalInfo(personalInfo1);
		CustomerTransactionsDetails2.setPersonalInfo(personalInfo2);
		customerTransactionsDetails.add(CustomerTransactionsDetails1);
		customerTransactionsDetails.add(CustomerTransactionsDetails2);
		
		CustomerContract.setCustomerTransactionsDetails(customerTransactionsDetails);
		
		
		List<TansactionsDetails> tansactionsDetails = new ArrayList<TansactionsDetails>();
		
		TansactionsDetails tansactionsDetails1 = new TansactionsDetails();
		TansactionsDetails tansactionsDetails2 = new TansactionsDetails();
		tansactionsDetails.add(tansactionsDetails1);
		tansactionsDetails.add(tansactionsDetails2);
		
		CustomerTransactionsDetails1.setTansactionsDetails(tansactionsDetails);
		
		List<ItemList> itemList = new ArrayList<ItemList>();
		ItemList itemList1 = new ItemList();
		ItemList itemList2 = new ItemList();
		itemList.add(itemList1);
		itemList.add(itemList2);
		
		tansactionsDetails1.setItemList(itemList);
		
		ShippingAddress shippingAddress = new ShippingAddress();
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
