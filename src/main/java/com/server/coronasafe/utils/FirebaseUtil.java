package com.server.coronasafe.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.server.coronasafe.constants.ResourcesEnum;
import com.server.coronasafe.models.ResourceQuery;
import com.server.coronasafe.models.User;
import com.server.coronasafe.models.io.quicktype.Data;
import com.server.coronasafe.models.io.quicktype.ResourceData;

public class FirebaseUtil {


	private static final String NOTMODIFIED = "NOTMODIFIED";

	static {
		try {
			GoogleCredentials credentials = GoogleCredentials.fromStream(new ByteArrayInputStream(System.getenv("FIREBASE_JSON").getBytes()))
					.createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(credentials)
					.setDatabaseUrl("https://"+System.getenv("PROJECT_ID")+".firebaseio.com/")
					.build();

			FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	public static List<User> getUsers() throws Exception {
		List<User> usersList = null;
		try(CoronasafelifeFirestore coronasafeFirestore = new CoronasafelifeFirestore()){
			usersList = coronasafeFirestore.getAllUsers();
		}
		return usersList;
	}


	public static String sendMessages() throws Exception{
		List<ResourceData> allData = compareAllData();
		if(allData==null||allData.isEmpty()) {
			return "No New Data";
		}

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			List<User> users;
			try {
				users = getUsers();
				List<User> activeUsers = users.stream().filter((user)->{return user.isActive();}).collect(Collectors. < User > toList());
				//				StringBuilder stringBuilder = new StringBuilder();
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
							//							stringBuilder.append("For User : "+user.getToken()+" resources found : "+finalData.stream().map(ResourceData::getDistrict).collect(Collectors.toList()) );
							//							System.out.println("For User : "+user.getToken()+" resources found : "+finalData.stream().map(ResourceData::getDistrict).collect(Collectors.toList()) );
						}
					}
				});	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		executor.submit(() -> {
			List<String> urls;
			try {
				urls = getAllWebhookData();
				for( String urlPath: urls) {

					new Thread(new Runnable() {

						@Override
						public void run() {
							try {
								int responsecode = 404;					
								URL url = new URL(urlPath);
								HttpURLConnection conn = (HttpURLConnection) url.openConnection();
								conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
								conn.setRequestMethod("POST");
								conn.setRequestProperty("Accept", "application/json");
								conn.setDoOutput(true);
								try(OutputStream os = conn.getOutputStream()) {
									byte[] input = WebUtil.getDataString(allData).getBytes("utf-8");
									os.write(input, 0, input.length);			
								}
								conn.connect();
								responsecode = conn.getResponseCode();	

							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}).start();


				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		return "Successfully started sending update";

	}

	private static void sendMessageToUser(User user, List<ResourceData> finalData) throws FirebaseMessagingException, JsonProcessingException {
		String registrationToken = user.getToken();

		for(ResourceData resourceData : finalData ) {
			AndroidConfig config = AndroidConfig.builder()
					.setPriority(AndroidConfig.Priority.HIGH).build();
			String camelRes = toCamelCase(resourceData.getCategory());
			Notification notification = Notification.builder()
					.setTitle(camelRes+" updated !")
					.setBody(resourceData.getTitle()+" \n "+resourceData.getDistrict()+", "+resourceData.getState()).build();
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
				.setTitle("Oxygen updated !")
				.setBody("Hemkunt Foundation \n Kochi, Kerala").build();

		Message message = Message.builder()
				.setNotification(notification)
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
		String currentsha = getCurrentLastCommit(ResourcesEnum.OXYGEN.getResource());

		try(CoronasafelifeFirestore coronasafeFirestore = new CoronasafelifeFirestore()){
			Object oldsha = coronasafeFirestore.getLastCheckedCommit();
			if(oldsha!=null && currentsha.equals(oldsha)) {
				return null;
			}
			coronasafeFirestore.addLastCheckedCommit(currentsha);
			coronasafeFirestore.close();
		}
		List<ResourceData> finalResourceList = new ArrayList<ResourceData>();
		for(ResourcesEnum resource: ResourcesEnum.values()) {
			finalResourceList.addAll(compareResourceData(resource,currentsha));
		}
		return finalResourceList;
	}

	public static String getCurrentLastCommit(String resource)throws Exception {
		String json = null;
		try (CoronasafelifeFirestore coronasafeFirestore = new CoronasafelifeFirestore()){
			Object eTagObj = coronasafeFirestore.getEtag();
			String etag = eTagObj==null?"":eTagObj.toString();
			json = getJsonStringFromAPIIfChanged("https://api.github.com/repos/coronasafe/life/commits?path=data%2F"+resource+"_v2.json&page=1&per_page=2",etag,coronasafeFirestore);
			if(json.equals(NOTMODIFIED)) {
				String oldSha = coronasafeFirestore.getLastCheckedCommit();
				coronasafeFirestore.close();
				return oldSha;
			}
			coronasafeFirestore.close();
		}
		JSONParser parser = new JSONParser(json);
		Object obj = parser.parse();
		String currentsha = ((Map)((ArrayList)obj).get(1)).get("sha").toString();		
		return currentsha;
	}

	private static String getJsonStringFromAPIIfChanged(String urlPath,String eTag, CoronasafelifeFirestore coronasafeFirestore) throws Exception {
		int responsecode = 404;
		URL url = new URL(urlPath);
		InputStream is = null;
		StringBuilder sb = new StringBuilder();
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.setRequestProperty("if-none-match", eTag);
			conn.setRequestMethod("GET");
			conn.connect();
			responsecode = conn.getResponseCode();	
			if(responsecode == 304) {
				return NOTMODIFIED;
			}
			else if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode + "  msg "+ conn.getResponseMessage());
			} 

			coronasafeFirestore.addetag(conn.getHeaderField("etag"));
			is  = conn.getInputStream();
			BufferedReader r  = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String line;
			while ((line = r.readLine()) != null) {
				sb.append(line);
			}
		}finally {
			if(is!=null) {
				is.close();
			}
		}
		return sb.toString();
	}


	private static class QueryPredicates {

		public static Predicate<ResourceData> isMatchingQuery(List<ResourceQuery> queries) {

			return p -> {
				return queries.stream().filter((query)-> query.isActive()).anyMatch(
						(query)-> 
						p.getDistrict().trim().equalsIgnoreCase(query.getDistrict().trim())
						&& p.getState().trim().equalsIgnoreCase(query.getState().trim())
						&& query.getResource().trim().equalsIgnoreCase(p.getCategory().trim()));
			};
		}

	}
	public static Data compareData(ResourcesEnum resource,String commitSha) throws IOException{
		Data ret = new Data();
		ret.setData(compareResourceData(resource,commitSha));
		return ret;
	}

	private static List<ResourceData> compareResourceData(ResourcesEnum resource,String commitSha) throws IOException{
		Data apiData = getDataFromAPI(resource.getUrlPath());
		Data oldApiData = getDataFromAPI("https://raw.githubusercontent.com/coronasafe/life/"+commitSha+"/data/"+resource.getResource()+"_v2.json");

		List<ResourceData> comparedDataList = new ArrayList<ResourceData>(apiData.getData());
		comparedDataList.removeAll(oldApiData.getData());
		return comparedDataList;
	}

	private static Data getDataFromAPI(String urlPath) throws IOException {
		return (Data) WebUtil.getObjectFromAPI(urlPath, Data.class);
	}

	public static String addWebhookData(String url) throws Exception {
		try(CoronasafelifeFirestore coronasafeFirestore = new CoronasafelifeFirestore()){
			coronasafeFirestore.addWebhookData(url);
		}
		return "Webhook added for "+url;
	}

	public static List<String> getAllWebhookData() throws Exception {
		List<String> webhooks = null;
		try(CoronasafelifeFirestore coronasafeFirestore = new CoronasafelifeFirestore()){
			webhooks = coronasafeFirestore.getAllWebhookData();
		}
		return webhooks;
	}
}
