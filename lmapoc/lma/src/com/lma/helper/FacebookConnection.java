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
				confBuilder.setOAuthAccessToken("EAAWG0c6GFJoBAMoDD07wLM3kc5mzTvKJRjHHgZCibDzd4S5Dq4hXJPmPJVZCWsTWdtbyuQYp7xkMN7ghfijpU1r23JjMY5J4J8JjnbaxfKSQX7QZBmIMQtIyl38Ek9yn1mIkQyE6OuEENgLSaCmyGq0KB4KR4YZD");
				
				confBuilder.setUseSSL(true);
				confBuilder.setJSONStoreEnabled(true);
				// Create configuration object
				Configuration configuration = confBuilder.build();
				// Create facebook instance
				FacebookFactory ff = new FacebookFactory(configuration);
				return ff.getInstance();
	}

}
