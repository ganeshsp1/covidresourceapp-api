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
package com.server.coronasafe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.coronasafe.models.Data;

@RestController
@RequestMapping("/get")
public class GetDataController {

	@RequestMapping("/activeDistricts")
	public String activeDistricts() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.getData("active_district_data"));
	}

	@RequestMapping("/ambulance")
	public String ambulance() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.getData("ambulance"));
	}

	@RequestMapping("/helpline")
	public String helpline() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.getData("helpline"));
	}

	@RequestMapping("/hospitals")
	public String hospitals() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.getData("hospitals"));
	}

	@RequestMapping("/medicine")
	public String medicine() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.getData("medicine"));
	}

	@RequestMapping("/oxygen")
	public String oxygen() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.getData("oxygen"));
	}
	
	@RequestMapping("/users")
	public String users() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.getUsers());
	}

	
	

}
