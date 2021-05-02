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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.coronasafe.models.Data;

@RestController
@RequestMapping("/initialise")
public class DataInitialisingController {

	@RequestMapping("/activeDistricts")
	public String activeDistricts() throws Exception {		
		 addData("active_district_data","https://life-api.coronasafe.network/data/active_district_data_v2.json");
		return "Active District Data Added!";
	}
	
	@RequestMapping("/ambulance")
	public String ambulance() throws Exception {
		
		 addData("ambulance","https://life-api.coronasafe.network/data/ambulance_v2.json");
		 return "Ambulance Data Added";
	}
	
	@RequestMapping("/helpline")
	public String helpline() throws Exception {
		
		 addData("helpline","https://life-api.coronasafe.network/data/helpline_v2.json");
		 return "Helpline Data Added";
	}
	
	@RequestMapping("/hospitals")
	public String hospitals() throws Exception {		
		 addData("hospitals","	https://life-api.coronasafe.network/data/hospital_v2.json");
		return "Hospitals Data Added!";
	}
	
	@RequestMapping("/medicine")
	public String medicine() throws Exception {
		
		 addData("ambulance","https://life-api.coronasafe.network/data/medicine_v2.json");
		 return "Medicine Added";
	}
	
	@RequestMapping("/oxygen")
	public String oxygen() throws Exception {
		
		 addData("oxygen","https://life-api.coronasafe.network/data/oxygen_v2.json");
		 return "Oxygen Data Added";
	}

	private void addData(String resource, String urlPath) throws MalformedURLException, IOException, ProtocolException, JsonProcessingException,
			JsonMappingException, Exception {
		int responsecode = 404;
		URL url = new URL(urlPath);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		conn.setRequestMethod("GET");
		conn.connect();
		
		responsecode = conn.getResponseCode();		
		
		if (responsecode != 200) {
		    throw new RuntimeException("HttpResponseCode: " + responsecode + "  msg "+ conn.getResponseMessage());
		} else {
			
			BufferedReader r  = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));

			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null) {
			    sb.append(line);
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			Data details = objectMapper.readValue(sb.toString(),Data.class);
		    String projectId = "coronasafe-life";
		    CoronasafelifeFirestore cryptoFirestore = (projectId != null) ? new CoronasafelifeFirestore(projectId) : new CoronasafelifeFirestore();
		    cryptoFirestore.addData(details,resource);
		    cryptoFirestore.close();

		}
	}
	
	@RequestMapping("/")
	public String index() throws Exception {
		return "Greetings from Spring Boot!";
	}

}
