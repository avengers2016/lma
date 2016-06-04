package com.lma.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lma.helper.MessageHelper;

@Controller

public class ProductController {
	
	
		@RequestMapping(value = "/getDetails", method = RequestMethod.GET)
		@ResponseBody
		public String getDetailsAsJson() {
		Person p = new Person();
		p.setName("Rahul");
		p.setSex("M");
		p.setAge("29");
		    
	   return MessageHelper.toJsonString(p);
		}
}
