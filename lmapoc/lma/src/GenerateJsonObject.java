import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lma.model.CustomerContract;
import com.lma.model.CustomerTransactionsDetails;
import com.lma.model.PersonalInfo;


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
