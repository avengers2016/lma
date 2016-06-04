import com.lma.helper.MessageHelper;
import com.lma.model.CustomerTransactionsDetails;


public class GenerateJsonObject {
	
	public static void main(String[] args) {
		
		String json  = MessageHelper.toJsonString(CustomerTransactionsDetails.class);
		System.out.println(json);
		
	}

}
