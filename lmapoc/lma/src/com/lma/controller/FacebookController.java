package com.lma.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lma.helper.FacebookConnection;
import com.lma.helper.FacebookDataHandler;

import facebook4j.Facebook;
import facebook4j.FacebookException;

@Controller
@RequestMapping("/facebook")
public class FacebookController {

	Facebook facebook;
  public FacebookController() {
	  facebook = FacebookConnection.getFacebookConnection();
}
  	@ResponseBody
    @RequestMapping(value="/getFacebookLikes",method=RequestMethod.GET)
    public String getFacebookLikes() {
      String responseData = null;
    	try {
    		responseData =  FacebookDataHandler.getFacebookLikes(facebook);
		} catch (FacebookException e) {
			StringWriter sw = new StringWriter();
		      PrintWriter pw = new PrintWriter(sw);
		      e.printStackTrace(pw);
		    
			responseData =sw.toString().toUpperCase();
		}
		return responseData;
    }
    
  	@ResponseBody
    @RequestMapping(value="/getFacebookAllPosts",method=RequestMethod.GET)
    public String getFacebookAllPosts() {
  		String responseData = null;
    	try {
    		responseData = FacebookDataHandler.getFacebookAllPosts(facebook);
		} catch (FacebookException e) {
			StringWriter sw = new StringWriter();
		      PrintWriter pw = new PrintWriter(sw);
		        e.printStackTrace(pw);
		        responseData =sw.toString().toUpperCase();
		}
		return responseData;
    }
  
}
