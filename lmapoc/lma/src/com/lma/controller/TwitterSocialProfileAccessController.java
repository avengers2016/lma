package com.lma.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lma.helper.MessageHelper;
import com.lma.model.KeyValuePairForPieChart;
import com.lma.model.SocialProfile;
import com.lma.model.TwitterConsumerKeys;
import com.lma.socialplatform.twitter.SocialProfileAccess;

@Controller
public class TwitterSocialProfileAccessController {
	
		public static void main(String args[]) {
			ModelMap model = new ModelMap();
			new TwitterSocialProfileAccessController().getTweetsFromProfile(model);
		}
			
		/**
		 * This method will provide the medium to add a new user.
		 */
		@RequestMapping(value = { "/showpiechart" }, method = RequestMethod.GET)
		public String getTweetsFromProfile(ModelMap model) {
						 
			return "showpiechart";
		}	
		 
		
		@RequestMapping(value = { "/showcolumnchart" }, method = RequestMethod.GET) 
		public String getColumnChart(ModelMap model) {			
		
			
			
			

			Map<String, SocialProfile> socialProfileMap = new HashMap<String, SocialProfile>();
			
			TwitterConsumerKeys objTwitterKeys = new TwitterConsumerKeys();
			
			objTwitterKeys.setId(1);
			objTwitterKeys.setConsumerKey("B8u99qpRC9k1xMQrWCLF8Ix68");
			objTwitterKeys.setConsumerSecret("Pyg5uKCne9mpZhq7SgnlOPgg8r5x4l1KbmXMBeBFegZCvV2Z4d");
			objTwitterKeys.setSocialChannel("twitter");
			
			
			SocialProfile objCustomerSocialProfile1 = new SocialProfile();
			objCustomerSocialProfile1.setSocialProfileId(1);
			objCustomerSocialProfile1.setScreenName("user1");
			objCustomerSocialProfile1.setSocialChannel("twitter");
			objCustomerSocialProfile1.setAccessTokenOauthToken("107982591-c4KGTPTl4bThUpyvQK8S1fadyO2tXPOZ2KzDLiS3");
			objCustomerSocialProfile1.setAccessTokenOauthTokenSecret("4pqL1eQcuecTNsIJInVOEuhDM1g532c90ZJzh6cr78iZv");
			
			SocialProfile objCustomerSocialProfile2 = new SocialProfile();
			objCustomerSocialProfile2.setSocialProfileId(2);
			objCustomerSocialProfile2.setScreenName("user2");
			objCustomerSocialProfile2.setSocialChannel("twitter");
			objCustomerSocialProfile2.setAccessTokenOauthToken("740916447317135361-WpB2CcE7ZbYwlJojIMqu3jJTTuDsiMt");
			objCustomerSocialProfile2.setAccessTokenOauthTokenSecret("odkbgCpS68efWZrF1BYhm2acIuXcdtqbFaSWmIRSCIqlY");
			
			socialProfileMap.put("customer1", objCustomerSocialProfile1 );
			socialProfileMap.put("customer2", objCustomerSocialProfile2 );
			 
			String[] productRelatedKeywords = { "Barclaycard - Arrival", "Barclaycard - Rewards", "Barclaycard - Cashforward" };
			
			Map<String, Integer> SocialStaticsForCustomer1 = (new SocialProfileAccess()).getSocialStatisticsForKeywords(objTwitterKeys.getConsumerKey(), objTwitterKeys.getConsumerSecret(), objCustomerSocialProfile1.getAccessTokenOauthToken(), objCustomerSocialProfile1.getAccessTokenOauthTokenSecret(), productRelatedKeywords);
			Map<String, Integer> SocialStaticsForCustomer2 = (new SocialProfileAccess()).getSocialStatisticsForKeywords(objTwitterKeys.getConsumerKey(), objTwitterKeys.getConsumerSecret(), objCustomerSocialProfile2.getAccessTokenOauthToken(), objCustomerSocialProfile2.getAccessTokenOauthTokenSecret(), productRelatedKeywords);			
			
			
			Map<String, Integer> FinalStatisticsMap = new HashMap<String, Integer>();
			
			if( SocialStaticsForCustomer1 != null ) {				
					for( int i=0; i<SocialStaticsForCustomer1.size(); i++) {
						FinalStatisticsMap.put(productRelatedKeywords[i], SocialStaticsForCustomer1.get(productRelatedKeywords[i]));
					}			
			}
			
			if( SocialStaticsForCustomer2 != null ) {				
				for( int i=0; i<SocialStaticsForCustomer2.size(); i++) {
					int count = FinalStatisticsMap.get(productRelatedKeywords[i]);
					count = count + SocialStaticsForCustomer1.get(productRelatedKeywords[i]);
					FinalStatisticsMap.put(productRelatedKeywords[i], count);
				}		
			}
			
			//Need to form array like = ['Barclaycard - Arrival', 'Barclaycard - Rewards','Barclaycard - Cashforward']
			
			//Need to form array like = [2, 1 , 1]
			
			
			String sendJSONTOClient = "";
			String sendJSONTOProductCount = "";
			String prefix = "[";
			String suffix = "]";
			 
			try {
				
			Iterator<Map.Entry<String, Integer>> entries = FinalStatisticsMap.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry<String, Integer> entry = entries.next(); 			    
			    //sendJSONTOClient += prefix + entry.getKey() +","+ entry.getValue() + suffix +",";
			    
			    sendJSONTOClient += "\'"+ entry.getKey()  + "\'" + ",";
			    
			    sendJSONTOProductCount += entry.getValue() + ",";
			}
			
			System.out.println(sendJSONTOClient);
			
			sendJSONTOClient = sendJSONTOClient.substring(0, sendJSONTOClient.length()-1);			 
			sendJSONTOClient += prefix + sendJSONTOClient + suffix;
			

			sendJSONTOProductCount = sendJSONTOProductCount.substring(0, sendJSONTOProductCount.length()-1);			 
			sendJSONTOProductCount += prefix + sendJSONTOProductCount + suffix;
			 
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("Final String : "+ sendJSONTOClient.substring((sendJSONTOClient.length() / 2)-1, sendJSONTOClient.length()));

			model.addAttribute("productNames", sendJSONTOClient.substring((sendJSONTOClient.length() / 2)-1, sendJSONTOClient.length()));  
			model.addAttribute("productCount", sendJSONTOProductCount.substring((sendJSONTOProductCount.length() / 2)-1, sendJSONTOProductCount.length()));
			
			System.out.println("Final String : "+model.get("productNames"));
			System.out.println("Final String : "+model.get("productCount"));
			
			return "showcolumnchart";
		}
		
		
		
		@RequestMapping(value = "/getJSONValues", method = RequestMethod.GET)
		@ResponseBody
		public String getDetailsAsJson() {
				
			// Pie Chart Data Format : [["Barclaycard - Arrival",1],["Barclaycard - Rewards",1],["Barclaycard - Cashforward",1]]
			

			Map<String, SocialProfile> socialProfileMap = new HashMap<String, SocialProfile>();
			
			TwitterConsumerKeys objTwitterKeys = new TwitterConsumerKeys();
			
			objTwitterKeys.setId(1);
			objTwitterKeys.setConsumerKey("B8u99qpRC9k1xMQrWCLF8Ix68");
			objTwitterKeys.setConsumerSecret("Pyg5uKCne9mpZhq7SgnlOPgg8r5x4l1KbmXMBeBFegZCvV2Z4d");
			objTwitterKeys.setSocialChannel("twitter");
			
			
			SocialProfile objCustomerSocialProfile1 = new SocialProfile();
			objCustomerSocialProfile1.setSocialProfileId(1);
			objCustomerSocialProfile1.setScreenName("user1");
			objCustomerSocialProfile1.setSocialChannel("twitter");
			objCustomerSocialProfile1.setAccessTokenOauthToken("107982591-c4KGTPTl4bThUpyvQK8S1fadyO2tXPOZ2KzDLiS3");
			objCustomerSocialProfile1.setAccessTokenOauthTokenSecret("4pqL1eQcuecTNsIJInVOEuhDM1g532c90ZJzh6cr78iZv");
			
			SocialProfile objCustomerSocialProfile2 = new SocialProfile();
			objCustomerSocialProfile2.setSocialProfileId(2);
			objCustomerSocialProfile2.setScreenName("user2");
			objCustomerSocialProfile2.setSocialChannel("twitter");
			objCustomerSocialProfile2.setAccessTokenOauthToken("740916447317135361-WpB2CcE7ZbYwlJojIMqu3jJTTuDsiMt");
			objCustomerSocialProfile2.setAccessTokenOauthTokenSecret("odkbgCpS68efWZrF1BYhm2acIuXcdtqbFaSWmIRSCIqlY");
			
			socialProfileMap.put("customer1", objCustomerSocialProfile1 );
			socialProfileMap.put("customer2", objCustomerSocialProfile2 );
			 
			String[] productRelatedKeywords = { "Barclaycard - Arrival", "Barclaycard - Rewards", "Barclaycard - Cashforward" };
			
			Map<String, Integer> SocialStaticsForCustomer1 = (new SocialProfileAccess()).getSocialStatisticsForKeywords(objTwitterKeys.getConsumerKey(), objTwitterKeys.getConsumerSecret(), objCustomerSocialProfile1.getAccessTokenOauthToken(), objCustomerSocialProfile1.getAccessTokenOauthTokenSecret(), productRelatedKeywords);
			Map<String, Integer> SocialStaticsForCustomer2 = (new SocialProfileAccess()).getSocialStatisticsForKeywords(objTwitterKeys.getConsumerKey(), objTwitterKeys.getConsumerSecret(), objCustomerSocialProfile2.getAccessTokenOauthToken(), objCustomerSocialProfile2.getAccessTokenOauthTokenSecret(), productRelatedKeywords);			
			
			
			Map<String, Integer> FinalStatisticsMap = new HashMap<String, Integer>();
			
			if( SocialStaticsForCustomer1 != null ) {				
					for( int i=0; i<SocialStaticsForCustomer1.size(); i++) {
						FinalStatisticsMap.put(productRelatedKeywords[i], SocialStaticsForCustomer1.get(productRelatedKeywords[i]));
					}			
			}
			
			if( SocialStaticsForCustomer2 != null ) {				
				for( int i=0; i<SocialStaticsForCustomer2.size(); i++) {
					int count = FinalStatisticsMap.get(productRelatedKeywords[i]);
					count = count + SocialStaticsForCustomer1.get(productRelatedKeywords[i]);
					FinalStatisticsMap.put(productRelatedKeywords[i], count);
				}		
			}
			
			
			String sendJSONTOClient = "";
			String prefix = "[";
			String suffix = "]";
			 
			try {
				
			Iterator<Map.Entry<String, Integer>> entries = FinalStatisticsMap.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry<String, Integer> entry = entries.next(); 			    
			    //sendJSONTOClient += prefix + entry.getKey() +","+ entry.getValue() + suffix +",";
			    
			    sendJSONTOClient += prefix + "\""+ entry.getKey()  + "\""+","+ entry.getValue() + suffix +",";
			}
			
			System.out.println(sendJSONTOClient);
			
			sendJSONTOClient = sendJSONTOClient.substring(0, sendJSONTOClient.length()-1);			 
			sendJSONTOClient += prefix + sendJSONTOClient + suffix;
			
			/*
		    sendJSONTOClient += prefix + prefix + "\""+ objKeyValuePairForPieChart1.getProductName() + "\""+","+ objKeyValuePairForPieChart1.getCount() + suffix +"," +
		    					prefix +  "\""+ objKeyValuePairForPieChart2.getProductName() + "\""+","+ objKeyValuePairForPieChart2.getCount() + suffix +"," + 
		    					prefix +  "\""+ objKeyValuePairForPieChart3.getProductName() +"\""+ ","+ objKeyValuePairForPieChart3.getCount() + suffix + suffix;
		    */
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("Final String : "+ sendJSONTOClient.substring((sendJSONTOClient.length() / 2)-2, sendJSONTOClient.length()));

			return sendJSONTOClient.substring((sendJSONTOClient.length() / 2)-2, sendJSONTOClient.length());
			
			}
}