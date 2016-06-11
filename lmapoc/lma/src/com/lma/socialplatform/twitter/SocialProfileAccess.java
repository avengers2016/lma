package com.lma.socialplatform.twitter;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.lma.model.SocialProfile;

public class SocialProfileAccess {
	
	public Map<String, Integer> getSocialStatisticsForKeywords(String strConsumerKey, String strConsumerSecret, String strAccessToken, String strAccessTokenSecret, String[] productRelatedKeywords) {
	
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(strConsumerKey)
		  .setOAuthConsumerSecret(strConsumerSecret)
		  .setOAuthAccessToken(strAccessToken)
		  .setOAuthAccessTokenSecret(strAccessTokenSecret);
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		
		int valueToReturn = 0 ;
		Map<String, Integer> keywordsAndCountMapping = new HashMap<String, Integer>();
		 
		try {
		        // gets Twitter instance with default credentials
		    	Twitter twitter = tf.getInstance();
		        User user = twitter.verifyCredentials();
		        List<Status> TweetsFromProfile= twitter.getHomeTimeline();
		        List<Status> FavouriteTweets = twitter.getFavorites();        
		        List<User> FriendsList=twitter.getFriendsList(twitter.getId(), -1);
		        List<User> FollowersList = twitter.getFollowersList(twitter.getId(), -1);
		        
		        
		        System.out.println("\n\nShowing Tweets from @" + user.getScreenName() + "'s home timeline.");
		        
				String strParentTweetDescription = new String();
				String strParentFavouriteTweets = new String();
				String strParentUserFollowsDescription = new String();
				String strParentUserFollowersDescription = new String();
				
		        
		        for (Status status : TweetsFromProfile) {
		            System.out.println("\nTweets : " + status.getText());
		            strParentTweetDescription += status.getText();
		        }
		        
		        System.out.println("\n\nShowing Favorite Tweets");        
		        
		        for (Status status : FavouriteTweets) {
		            System.out.println("\nFavourites Tweets - " + status.getText());
		            System.out.println(", Favourite Count - " + status.getFavoriteCount());
		            strParentFavouriteTweets += status.getText();
		        }
		        
		        System.out.println("\n\nShowing Friends (i.e. profiles which user follows) List : ");        
		        
		        for (User status : FriendsList) {
		            System.out.println("\nDescription - " + status.getDescription());
		            strParentUserFollowsDescription += status.getDescription();
		        }        
		        
		        System.out.println("\n\nShowing Followers List : ");        
		        
		        for (User status : FollowersList) {
		            System.out.println("\nDescription - " + status.getDescription());
		            strParentUserFollowersDescription += status.getDescription();
		        }     
		        
		        //Check for keyword occurrence.
		        
				int productNameOccurrenceCount = 0;
				boolean productNameExistsInTweets = false;
				boolean productNameExistsInFavTweets = false;
				boolean productNameExistsInFollowsTweets = false;
				boolean productNameExistsInFollowersTweets = false;
										
				//Determine whether the product name exists in the tweets or not.
				
				for (int i = 0; i< productRelatedKeywords.length; i++) {
				
					String strProductNameToken = productRelatedKeywords[i]; 
							
					StringTokenizer st = new StringTokenizer(strProductNameToken, " ");
							
					while (st.hasMoreElements()) {
					
						//System.out.println("StringTokenizer Output: " + st.nextElement());
						
						String tempProductName = (String) st.nextElement();
							
							if ( strParentTweetDescription.matches("(?i:.*"+tempProductName+".*)") != false) {								
								//Productname exists in tweets.			
									productNameExistsInTweets = true;	
							}
				
							if ( strParentFavouriteTweets.matches("(?i:.*"+tempProductName+".*)") != false) {
								//Productname exists in Favourites.			
									productNameExistsInFavTweets = true;			
							}
				
							if ( strParentUserFollowsDescription.matches("(?i:.*"+tempProductName+".*)") != false) {		
								//Productname exists in Follows Description.			
									productNameExistsInFollowsTweets = true;			
							}	
							
							if ( strParentUserFollowersDescription.matches("(?i:.*"+tempProductName+".*)") != false) {
								//Productname exists in Followers Description.			
									productNameExistsInFollowersTweets = true;			
							}	
				 			
					}
							if( productNameExistsInTweets == true || productNameExistsInFavTweets == true || productNameExistsInFollowsTweets == true || productNameExistsInFollowersTweets == true ) {	
								valueToReturn++; 
								keywordsAndCountMapping.put(strProductNameToken, valueToReturn); 
								valueToReturn = 0;
							}else {
								valueToReturn = 0;	 
							}
							
							productNameExistsInTweets = false;
							productNameExistsInFavTweets = false;		  	
							productNameExistsInFollowsTweets = false;
							productNameExistsInFollowersTweets = false;		 
					} 	        
				        
			} catch (TwitterException te) {
				        te.printStackTrace();
				        System.out.println("Failed to get timeline: " + te.getMessage());
				        System.exit(-1);
			}		 
    	
		if( keywordsAndCountMapping.size() > 0 ) {
				return keywordsAndCountMapping;
		}
		return null;
	}
	
	public static boolean containsIgnoreCase(final String str, final String searchStr) {
	    if (str == null || searchStr == null) {
	        return false;
	    }
	    final int len = searchStr.length();
	    final int max = str.length() - len;
	    for (int i = 0; i <= max; i++) {
	        if (str.regionMatches(true, i, searchStr, 0, len)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void getUserTweetsFromProfile() {
		
		String strConsumerKey = "B8u99qpRC9k1xMQrWCLF8Ix68";
		String strConsumerSecret = "Pyg5uKCne9mpZhq7SgnlOPgg8r5x4l1KbmXMBeBFegZCvV2Z4d";
		String strAccessToken = "107982591-c4KGTPTl4bThUpyvQK8S1fadyO2tXPOZ2KzDLiS3";
		String strAccessTokenSecret = "4pqL1eQcuecTNsIJInVOEuhDM1g532c90ZJzh6cr78iZv";

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(strConsumerKey)
		  .setOAuthConsumerSecret(strConsumerSecret)
		  .setOAuthAccessToken(strAccessToken)
		  .setOAuthAccessTokenSecret(strAccessTokenSecret);
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		
    try {
        // gets Twitter instance with default credentials
    	Twitter twitter = tf.getInstance();
        User user = twitter.verifyCredentials();
        List<Status> TweetsFromProfile= twitter.getHomeTimeline();
        List<Status> FavouriteTweets = twitter.getFavorites();        
        List<User> FriendsList=twitter.getFriendsList(twitter.getId(), -1);
        List<User> FollowersList = twitter.getFollowersList(twitter.getId(), -1);
        
        
        System.out.println("\n\nShowing Tweets from @" + user.getScreenName() + "'s home timeline.");
        
        for (Status status : TweetsFromProfile) {
            System.out.println("\nTweets : " + status.getText());
        }
        
        System.out.println("\n\nShowing Favorite Tweets");        
        
        for (Status status : FavouriteTweets) {
            System.out.println("\nFavourites Tweets - " + status.getText());
            System.out.println(", Favourite Count - " + status.getFavoriteCount());
        }
        
        System.out.println("\n\nShowing Friends (i.e. profiles which user follows) List : ");        
        
        for (User status : FriendsList) {
            System.out.println("\nDescription - " + status.getDescription());
        }        
        
        System.out.println("\n\nShowing Followers List : ");        
        
        for (User status : FollowersList) {
            System.out.println("\nDescription - " + status.getDescription());
        }             
        
    } catch (TwitterException te) {
        te.printStackTrace();
        System.out.println("Failed to get timeline: " + te.getMessage());
        System.exit(-1);
    }
    
	}
}
