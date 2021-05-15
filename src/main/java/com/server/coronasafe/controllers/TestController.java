package com.server.coronasafe.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.coronasafe.constants.ResourcesEnum;
import com.server.coronasafe.models.io.quicktype.Converter;
import com.server.coronasafe.models.io.quicktype.Data;
import com.server.coronasafe.utils.FirebaseUtil;
import com.server.coronasafe.utils.WebUtil;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/testmessage")
	public String testmessage(@RequestParam(name="token", required = true) String registrationToken) throws Exception {
		FirebaseUtil.testSendMessage(registrationToken);
	    return "Message send to "+registrationToken+" successfully!";
	}
	
	@RequestMapping("/oxygen")
	public String resource() throws Exception {
	    return Converter.toJsonString((Data) WebUtil.getObjectFromAPI(ResourcesEnum.OXYGEN.getUrlPath(), Data.class));
	}
	

}