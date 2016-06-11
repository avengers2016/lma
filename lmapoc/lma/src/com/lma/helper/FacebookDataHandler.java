/**
 * 
 */
package com.lma.helper;

import facebook4j.Event;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Post;
import facebook4j.ResponseList;

/**
 * @author RAHUL
 *
 */
public class FacebookDataHandler {
	
	public static String getFacebookLikes(Facebook facebook)
			throws FacebookException {
		
		ResponseList<Event> eventsResults = facebook.getEvents();
			
		return eventsResults.toString();
	}
	
	
	public static String getFacebookAllPosts(Facebook facebook)
			throws FacebookException {
		
		ResponseList<Post> results = facebook.getPosts();
				
		return results.toString();
	}

}
