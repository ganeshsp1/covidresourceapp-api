/*
 * Copyright 2021 CovidWarriors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.server.coronasafe.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.coronasafe.utils.FirebaseUtil;


@RestController
@RequestMapping("/webhooks")
public class WebhooksController {

	@RequestMapping("/add")
	public String activeDistricts(@RequestParam(name="token", required = true) String registrationToken, @RequestParam(name="url", required = true) String url) throws Exception {		
		if(registrationToken.equals(System.getenv("token"))) {
		return FirebaseUtil.addWebhookData(url);
		}
		else {
			return "Invalid Token";
		}
	}

	@RequestMapping("/all")
	public String allWebhooks() throws Exception {		
		return FirebaseUtil.getAllWebhookData().toString();
	}
	
	@PostMapping("/post")
	public String postWebhookUrls(@RequestBody String changedResource) throws Exception {		
		return "Yeayyyyyyy Passed!!!!!"+ changedResource;
	}

}
