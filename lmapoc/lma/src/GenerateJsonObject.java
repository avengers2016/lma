import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lma.model.CustomerContract;


public class GenerateJsonObject {
	
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		CustomerContract CustomerContract =  new  CustomerContract();
		
		
		
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
