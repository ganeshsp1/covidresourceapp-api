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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.coronasafe.models.Data;

@RestController
@RequestMapping("/get")
public class GetDataController {

	@RequestMapping("/activeDistricts")
	public String activeDistricts() throws Exception {		
		return getDataString(getData("active_district_data"));
	}

	@RequestMapping("/ambulance")
	public String ambulance() throws Exception {		
		return getDataString(getData("ambulance"));
	}

	@RequestMapping("/helpline")
	public String helpline() throws Exception {		
		return getDataString(getData("helpline"));
	}

	@RequestMapping("/hospitals")
	public String hospitals() throws Exception {		
		return getDataString(getData("hospitals"));
	}

	@RequestMapping("/medicine")
	public String medicine() throws Exception {		
		return getDataString(getData("medicine"));
	}

	@RequestMapping("/oxygen")
	public String oxygen() throws Exception {		
		return getDataString(getData("oxygen"));
	}

	private String getDataString(Data data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(data);
		return jsonString;
	}

	private Data getData(String resource) throws MalformedURLException, IOException, ProtocolException, JsonProcessingException,
	JsonMappingException, Exception {
		String projectId = "coronasafe-life";
		CoronasafelifeFirestore cryptoFirestore = (projectId != null) ? new CoronasafelifeFirestore(projectId) : new CoronasafelifeFirestore();
		Data data = cryptoFirestore.getData(resource);
		cryptoFirestore.close();
		return data;
	}

	@RequestMapping("/")
	public String index() throws Exception {
		return "Greetings from Spring Boot!";
	}

}
