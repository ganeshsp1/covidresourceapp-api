package com.example.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.models.Data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HelloController {

	@RequestMapping("/activeDistricts")
	public String activeDistricts() throws Exception {		
		 addData("active_district_data","https://life-api.coronasafe.network/data/active_district_data.json");
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

	private void addData(String resource, String urlPath) throws MalformedURLException, IOException, ProtocolException, JsonProcessingException,
			JsonMappingException, Exception {
		int responsecode = 404;
		URL url = new URL(urlPath);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		conn.setRequestMethod("GET");
		conn.connect();

		//Getting the response code
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
//			System.out.println(sb.toString());
			
			ObjectMapper objectMapper = new ObjectMapper();
			Data details = objectMapper.readValue(sb.toString(),Data.class);
//		    System.out.println(details);
		    
		    
		    
		    String projectId = "coronasafe-life";
		    CoronasafelifeFirestore cryptoFirestore = (projectId != null) ? new CoronasafelifeFirestore(projectId) : new CoronasafelifeFirestore();
		    cryptoFirestore.run(details,resource);
		    cryptoFirestore.close();

		}
	}
	
	@RequestMapping("/")
	public String index() throws Exception {
		return "Greetings from Spring Boot!";
	}

}
