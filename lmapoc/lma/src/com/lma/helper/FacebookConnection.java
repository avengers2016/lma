/**
 * 
 */
package com.lma.helper;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

/**
 * @author RAHUL
 *
 */
public class FacebookConnection {
	
	public static Facebook getFacebookConnection(){
		
				ConfigurationBuilder confBuilder = new ConfigurationBuilder();
				confBuilder.setDebugEnabled(true);
				// Set application id, secret key and access token
				confBuilder.setOAuthAppId("1555610554733722");
				confBuilder.setOAuthAppSecret("bb2458c96cd6f563b077e2bdfab12f39");
				confBuilder.setOAuthAccessToken("EAAWG0c6GFJoBAPLoXE3BXsh9DznLfeN5NOk7wMUOiq6jqzx70KfWZBkFi3AWN4ZC9RuYaguU6v6CocpZBTmjNO4kV6SH6zDaZB9BYIwudaLxC12Gx7Yx4IZC5ZCywC0TUv874M8Rq4wjyVq8qpsE4ZCDYWzXTirQ7odeKMHPFcyDQZDZD");
				
				confBuilder.setUseSSL(false);
				confBuilder.setJSONStoreEnabled(true);
				// Create configuration object
				Configuration configuration = confBuilder.build();
				// Create facebook instance
				FacebookFactory ff = new FacebookFactory(configuration);
				return ff.getInstance();
	}

}
