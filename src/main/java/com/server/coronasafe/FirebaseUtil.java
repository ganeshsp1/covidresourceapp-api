package com.server.coronasafe;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.server.coronasafe.models.Data;
import com.server.coronasafe.models.ResourceData;
import com.server.coronasafe.models.ResourceQuery;
import com.server.coronasafe.models.User;

public class FirebaseUtil {


	static {
		try {
			GoogleCredentials credentials = GoogleCredentials.fromStream(new ByteArrayInputStream(System.getenv("FIREBASE_JSON").getBytes()))
			        .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
			FirebaseOptions options = FirebaseOptions.builder()
				    .setCredentials(credentials)
				    .setDatabaseUrl("https://"+System.getenv("PROJECT_ID")+".firebaseio.com/")
				    .build();

			FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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


		CoronasafelifeFirestore cryptoFirestore = new CoronasafelifeFirestore(System.getenv("PROJECT_ID"));
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
		CoronasafelifeFirestore cryptoFirestore = new CoronasafelifeFirestore(System.getenv("PROJECT_ID"));
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
	public static String getDataString(Object data) throws JsonProcessingException {
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
	public static Data compareData(ResourcesEnum resource) throws Exception {
		Data ret = new Data();
		ret.setData(compareResourceData(resource));
		return ret;
	}

	public static List<User> getUsers() throws Exception {
		CoronasafelifeFirestore cryptoFirestore = new CoronasafelifeFirestore(System.getenv("PROJECT_ID"));
		List<User> usersList = cryptoFirestore.getAllUsers();
		cryptoFirestore.close();
		return usersList;
	}


	public static void sendMessages() throws Exception{
		List<ResourceData> allData = compareAllData();
		List<User> users = getUsers();
		List<User> activeUsers = users.stream().filter((user)->{return user.isActive();}).collect(Collectors. < User > toList());

		activeUsers.forEach((user) -> {
			List<ResourceData> finalData = allData.stream()
					.filter(QueryPredicates.isMatchingQuery(user.getQueries())).collect(Collectors. < ResourceData > toList());
			if(finalData!=null && !finalData.isEmpty()) {
				try {
					sendMessageToUser(user,finalData);
				} catch (FirebaseMessagingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				System.out.println("For User : "+user.getToken()+" resources found : "+finalData.stream().map(ResourceData::getDistrict).collect(Collectors.toList()) );
			}
		});		

	}

	private static void sendMessageToUser(User user, List<ResourceData> finalData) throws FirebaseMessagingException, JsonProcessingException {
		String registrationToken = user.getToken();

		// See documentation on defining a message payload.
		Message message = Message.builder()
				.putData("resource", getDataString(finalData))
				.setToken(registrationToken)
				.build();

		System.out.println("Sending message: " + getDataString(finalData));

		// Send a message to the device corresponding to the provided
		// registration token.
		String response = FirebaseMessaging.getInstance().send(message);
		// Response is a message ID string.
		System.out.println("Response : " + response);

	}

	private static List<ResourceData> compareAllData() throws Exception{

		List<ResourceData> finalResourceList = new ArrayList<ResourceData>();
		for(ResourcesEnum resource: ResourcesEnum.values()) {
			finalResourceList.addAll(compareResourceData(resource));
		}
		return finalResourceList;
	}

	private static List<ResourceData> compareResourceData(ResourcesEnum resource) throws Exception {
		Data apiData = getDataFromAPI(resource.getUrlPath());
		Data dbData = getData(resource.getResource());
		List<ResourceData> apiList = new ArrayList<ResourceData>(apiData.getData());
		apiList.removeAll(dbData.getData());
		return apiList;
	}

	private static class QueryPredicates {

		public static Predicate<ResourceData> isMatchingQuery(List<ResourceQuery> queries) {

			return p -> {
				return queries.stream().filter((query)-> query.isActive()).anyMatch(
						(query)-> 
						p.getDistrict().equals(query.getDistrict())
						&& p.getState().equals(query.getState())
						&& query.getResources().contains(p.getCategory()));
			};
		}

	}
}
