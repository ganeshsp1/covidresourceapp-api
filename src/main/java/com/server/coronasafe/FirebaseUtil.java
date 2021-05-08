package com.server.coronasafe;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
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
	public static void addDataFromAPI(String resource, String urlPath) throws Exception {

		Data details = getDataFromAPI(urlPath);


		CoronasafelifeFirestore cryptoFirestore = new CoronasafelifeFirestore(System.getenv("PROJECT_ID"));
		cryptoFirestore.addData(details,resource);
		cryptoFirestore.close();

	}

	public static void addDataFromAPI(ResourcesEnum resource) throws Exception {
		addDataFromAPI(resource.getResource(), resource.getUrlPath());
	}

	/**
	 * 
	 * @param urlPath
	 * @return
	 * @throws IOException
	 */
	public static Data getDataFromAPI(String urlPath) throws IOException{
		String json = getJsonStringFromAPI(urlPath);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Data details = objectMapper.readValue(json,Data.class);
		return details;
	}

	private static String getJsonStringFromAPI(String urlPath) throws IOException {
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

		BufferedReader r  = new BufferedReader(new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8")));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = r.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
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
	//	public static Data compareData(ResourcesEnum resource) throws Exception {
	//		Data ret = new Data();
	//		ret.setData(compareResourceData(resource));
	//		return ret;
	//	}

	public static List<User> getUsers() throws Exception {
		CoronasafelifeFirestore cryptoFirestore = new CoronasafelifeFirestore(System.getenv("PROJECT_ID"));
		List<User> usersList = cryptoFirestore.getAllUsers();
		cryptoFirestore.close();
		return usersList;
	}


	public static String sendMessages() throws Exception{
		List<ResourceData> allData = compareAllData();
		if(allData==null||allData.isEmpty()) {
			return "No New Data";
		}
		List<User> users = getUsers();
		List<User> activeUsers = users.stream().filter((user)->{return user.isActive();}).collect(Collectors. < User > toList());
		StringBuilder stringBuilder = new StringBuilder();
		activeUsers.forEach((user) -> {

			if(user.getQueries()!=null) {
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
					stringBuilder.append("For User : "+user.getToken()+" resources found : "+finalData.stream().map(ResourceData::getDistrict).collect(Collectors.toList()) );
					System.out.println("For User : "+user.getToken()+" resources found : "+finalData.stream().map(ResourceData::getDistrict).collect(Collectors.toList()) );
				}
			}
		});		
		return stringBuilder.toString().isEmpty()?" New Data found, but No Alerts Send":stringBuilder.toString();

	}

	private static void sendMessageToUser(User user, List<ResourceData> finalData) throws FirebaseMessagingException, JsonProcessingException {
		String registrationToken = user.getToken();

		// See documentation on defining a message payload.
		//		Message message = Message.builder()
		//				.putData("resource", getDataString(finalData))
		//				.setToken(registrationToken)
		//				.build();

		//		System.out.println("Sending message: " + getDataString(finalData));

		for(ResourceData resourceData : finalData ) {
			AndroidConfig config = AndroidConfig.builder()
					.setPriority(AndroidConfig.Priority.HIGH).build();
			String camelRes = toCamelCase(resourceData.getCategory());
			Notification notification = Notification.builder()
					.setTitle(camelRes+" Available !")
					.setBody(camelRes+" available in "+resourceData.getDistrict()+", "+resourceData.getState()).build();
			ObjectMapper oMapper = new ObjectMapper();
			oMapper.setSerializationInclusion(Include.NON_NULL);
			Map<String, String> map = oMapper.convertValue(resourceData, Map.class);

			Message message = Message.builder()
					.setNotification(notification)
					.putAllData(map)
					.setAndroidConfig(config)
					.setToken(registrationToken)
					.build();
			FirebaseMessaging.getInstance().send(message);

		}

	}

	 public static String toCamelCase(final String init) {
    if (init == null)
        return null;

    final StringBuilder ret = new StringBuilder(init.length());

    for (final String word : init.split(" ")) {
        if (!word.isEmpty()) {
            ret.append(Character.toUpperCase(word.charAt(0)));
            ret.append(word.substring(1).toLowerCase());
        }
        if (!(ret.length() == init.length()))
            ret.append(" ");
    }

    return ret.toString();
}
	public static void testSendMessage(String registrationToken) throws FirebaseMessagingException
	{
		AndroidConfig config = AndroidConfig.builder()
				.setPriority(AndroidConfig.Priority.HIGH).build();
		Notification notification = Notification.builder()
				.setTitle("Corona Resource Found")
				.setBody("Oxygen found in Delhi!!!").build();
		Message message = Message.builder()
				.setNotification(notification )
				.putData("volume","2")
				.putData("address","A 104/2, Sanjay Colony II, Pocket A, Sanjay Colony, Okhla Phase II, Okhla Industrial Area, New Delhi, Delhi 110020")
				.setAndroidConfig(config)
				.setToken(registrationToken)
				.build();
		FirebaseMessaging.getInstance().send(message);
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	private static List<ResourceData> compareAllData() throws Exception{
		CoronasafelifeFirestore cryptoFirestore = new CoronasafelifeFirestore(System.getenv("PROJECT_ID"));
		String currentsha = getCurrentLastCommit(ResourcesEnum.OXYGEN.resource);
		Object oldsha = cryptoFirestore.getLastCheckedCommit();
		if(oldsha!=null && currentsha.equals(oldsha)) {
			return null;
		}
		cryptoFirestore.addLastCheckedCommit(currentsha);
		cryptoFirestore.close();

		List<ResourceData> finalResourceList = new ArrayList<ResourceData>();
		for(ResourcesEnum resource: ResourcesEnum.values()) {
			finalResourceList.addAll(compareResourceData(resource,currentsha));
		}
		return finalResourceList;
	}

	static String getCurrentLastCommit(String resource)throws Exception {

		String json = getJsonStringFromAPI("https://api.github.com/repos/coronasafe/life/commits?path=data%2F"+resource+"_v2.json&page=1&per_page=2");
		JSONParser parser = new JSONParser(json);
		Object obj = parser.parse();
		ArrayList array = (ArrayList)obj;
		Map obj2 = (Map)array.get(1); 
		String currentsha = obj2.get("sha").toString();
		return currentsha;
	}

	//	private static List<ResourceData> compareResourceData(ResourcesEnum resource) throws Exception {
	//		Data apiData = getDataFromAPI(resource.getUrlPath());
	//		Data dbData = getData(resource.getResource());
	//		List<ResourceData> apiList = new ArrayList<ResourceData>(apiData.getData());
	//		apiList.removeAll(dbData.getData());
	//		return apiList;
	//	}

	private static class QueryPredicates {

		public static Predicate<ResourceData> isMatchingQuery(List<ResourceQuery> queries) {

			return p -> {
				return queries.stream().filter((query)-> query.isActive()).anyMatch(
						(query)-> 
						p.getDistrict().equals(query.getDistrict())
						&& p.getState().equals(query.getState())
						&& query.getResource().equals(p.getCategory()));
			};
		}

	}

	public static void addFoodDataFromAPI(ResourcesEnum food) throws Exception {
		Data details = getDataFromAPI(food.getUrlPath());
		CoronasafelifeFirestore cryptoFirestore = new CoronasafelifeFirestore(System.getenv("PROJECT_ID"));
		cryptoFirestore.addFoodData(details,food.getResource());
		cryptoFirestore.close();

	}

	public static Data compareData(ResourcesEnum resource,String commitSha) throws Exception {
		Data ret = new Data();
		ret.setData(compareResourceData(resource,commitSha));
		return ret;
	}

	private static List<ResourceData> compareResourceData(ResourcesEnum resource,String commitSha) throws Exception {
		Data apiData = getDataFromAPI(resource.getUrlPath());
		//		String commitSha = getCurrentLastCommit(resource.getResource());
		Data oldApiData = getDataFromAPI("https://raw.githubusercontent.com/coronasafe/life/"+commitSha+"/data/"+resource.getResource()+"_v2.json");

		List<ResourceData> comparedDataList = new ArrayList<ResourceData>(apiData.getData());
		comparedDataList.removeAll(oldApiData.getData());
		return comparedDataList;
	}
}
