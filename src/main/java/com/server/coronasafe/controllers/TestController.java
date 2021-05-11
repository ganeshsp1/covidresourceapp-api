package com.server.coronasafe.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.coronasafe.utils.FirebaseUtil;

@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/testmessage")
	public String index(@RequestParam(name="token", required = true) String registrationToken) throws Exception {
		FirebaseUtil.testSendMessage(registrationToken);
	    return "Message send to "+registrationToken+" successfully!";
	}
	
	

}