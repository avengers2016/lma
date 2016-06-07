package com.lma.socialplatform.twitter;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class SocialProfileAccess {
	
	public static void main(String[] args) {
		
		(new SocialProfileAccess()).getUserTweetsFromProfile();
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
