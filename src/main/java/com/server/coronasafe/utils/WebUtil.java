package com.server.coronasafe.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebUtil {
	/**
	 * 
	 * @param urlPath
	 * @return
	 * @throws IOException
	 */
	public static String getJsonStringFromAPI(String urlPath) throws IOException{
		InputStream is = null ;
		StringBuilder sb = new StringBuilder();
		try {
			int responsecode = 404;
			URL url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestMethod("GET");
			conn.connect();
			responsecode = conn.getResponseCode();		
			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode + "  msg "+ conn.getResponseMessage());
			} 
			is = conn.getInputStream();
			BufferedReader r  = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

			String line;
			while ((line = r.readLine()) != null) {
				sb.append(line);
			}
		}finally {
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param urlPath
	 * @param objectClazz 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static Object getObjectFromAPI(String urlPath, Class objectClazz) throws IOException{
		String json = WebUtil.getJsonStringFromAPI(urlPath);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Object details = objectMapper.readValue(json,objectClazz);
		return details;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String getDataString(Object data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(data);
		return jsonString;
	}
}
