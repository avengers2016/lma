/**
 * 
 */
package com.lma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lma.exception.ErrorResponse;
import com.lma.helper.MessageHelper;



/**
 * @author RAHUL
 *
 */
@Controller
public class ExceptionController {
	
		@ResponseBody
		@ExceptionHandler(NullPointerException.class)
	  public String handleNullPointerException(NullPointerException ex) {
		ErrorResponse response = new ErrorResponse();
		response.setErrCode("Value is null");
		response.setErrMsg(ex.getMessage());
	    return MessageHelper.toJsonString(response);
	  }
	}



