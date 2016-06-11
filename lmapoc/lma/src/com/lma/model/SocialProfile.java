/**
 * 
 */
package com.lma.model;

/**
 * @author ASUS
 *
 */
public class SocialProfile {
	
	private int socialProfileId;
	private String socialChannel;
	private String accessTokenOauthToken;
	private String accessTokenOauthTokenSecret;
	private String screenName;

	public int getSocialProfileId() {
		return socialProfileId;
	}
	public void setSocialProfileId(int socialProfileId) {
		this.socialProfileId = socialProfileId;
	}
	public String getSocialChannel() {
		return socialChannel;
	}
	public void setSocialChannel(String socialChannel) {
		this.socialChannel = socialChannel;
	}
	public String getAccessTokenOauthToken() {
		return accessTokenOauthToken;
	}
	public void setAccessTokenOauthToken(String accessTokenOauthToken) {
		this.accessTokenOauthToken = accessTokenOauthToken;
	}
	public String getAccessTokenOauthTokenSecret() {
		return accessTokenOauthTokenSecret;
	}
	public void setAccessTokenOauthTokenSecret(String accessTokenOauthTokenSecret) {
		this.accessTokenOauthTokenSecret = accessTokenOauthTokenSecret;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}