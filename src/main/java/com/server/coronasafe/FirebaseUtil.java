package com.server.coronasafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.coronasafe.models.Data;
import com.server.coronasafe.models.ResourceData;

public class FirebaseUtil {

	static final String projectId = "coronasafe-life";

	/**
	 * 
	 * @param resource
	 * @param urlPath
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 * @throws Exception
	 */
	public static void addDataFromAPI(String resource, String urlPath) throws MalformedURLException, IOException, ProtocolException, JsonProcessingException,
	JsonMappingException, Exception {

		Data details = getDataFromAPI(urlPath);


		CoronasafelifeFirestore cryptoFirestore = (projectId != null) ? new CoronasafelifeFirestore(projectId) : new CoronasafelifeFirestore();
		cryptoFirestore.addData(details,resource);
		cryptoFirestore.close();

	}

	/**
	 * 
	 * @param urlPath
	 * @return
	 * @throws IOException
	 */
	public static Data getDataFromAPI(String urlPath) throws IOException{
		int responsecode = 404;
		URL url = new URL(urlPath);
		Data details = null;
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
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			details = objectMapper.readValue(sb.toString(),Data.class);
		}
		return details;
	}

	/**
	 * 
	 * @param resource
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 * @throws Exception
	 */
	public static Data getData(String resource) throws MalformedURLException, IOException, ProtocolException, JsonProcessingException,
	JsonMappingException, Exception {
		CoronasafelifeFirestore cryptoFirestore = (projectId != null) ? new CoronasafelifeFirestore(projectId) : new CoronasafelifeFirestore();
		Data data = cryptoFirestore.getData(resource);
		cryptoFirestore.close();
		return data;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String getDataString(Data data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(data);
		return jsonString;
	}

	/**
	 * 
	 * @param urlPath
	 * @param resource
	 * @return
	 * @throws Exception
	 */
	public static Data compareData(String urlPath, String resource) throws Exception {
		Data apiData = getDataFromAPI(urlPath);
		Data dbData = getData(resource);

		List<ResourceData> apiList = new ArrayList<ResourceData>(apiData.getData());
		apiList.removeAll(dbData.getData());

		Data ret = new Data();
		ret.setData(apiList);
		return ret;
	}

	public static String getUsers() throws Exception {
		CoronasafelifeFirestore cryptoFirestore = (projectId != null) ? new CoronasafelifeFirestore(projectId) : new CoronasafelifeFirestore();
		cryptoFirestore.getAllUsers();
		cryptoFirestore.close();
		return "Done";
	}
}
