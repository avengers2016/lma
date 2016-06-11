package com.lma.model;

public class TwitterConsumerKeys {
	
	private int id;
	private String consumerKey;
	private String consumerSecret;
	private String socialChannel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConsumerKey() {
		return consumerKey;
	}
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}
	public String getConsumerSecret() {
		return consumerSecret;
	}
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}
	public String getSocialChannel() {
		return socialChannel;
	}
	public void setSocialChannel(String socialChannel) {
		this.socialChannel = socialChannel;
	}

}
