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

package com.server.coronasafe.utils;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.server.coronasafe.models.ResourceQuery;
import com.server.coronasafe.models.User;

/**
 * A simple Quick start application demonstrating how to connect to Firestore
 * and add and query documents.
 */
public class CoronasafelifeFirestore {

	private Firestore db;
	

	
	public CoronasafelifeFirestore() throws Exception {	
		FirestoreOptions firestoreOptions =
				FirestoreOptions.getDefaultInstance().toBuilder()
				.setProjectId(System.getenv("PROJECT_ID"))
				.setCredentials(GoogleCredentials.fromStream(new ByteArrayInputStream(System.getenv("FIREBASE_JSON").getBytes())))
				.build();
		Firestore db = firestoreOptions.getService();
		this.db = db;
	}

	Firestore getDb() {
		return db;
	}


	/** Closes the gRPC channels associated with this instance and frees up their resources. */
	void close() throws Exception {
		db.close();
	}

	public List<User> getAllUsers() throws InterruptedException, ExecutionException {
		ApiFuture<QuerySnapshot> query = db.collection("Users").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		List<User> usersList = new ArrayList<User>();
		for (QueryDocumentSnapshot document : documents) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			User user = mapper.convertValue(document.getData(), User.class);
			List<ResourceQuery> resourceQueries = new ArrayList<ResourceQuery>();

			QuerySnapshot resourceQuerySnapshot  = document.getReference().collection("queries").get().get();
			for(QueryDocumentSnapshot resourceQueryDocument: resourceQuerySnapshot.getDocuments()) {
				ResourceQuery resourceQuery = mapper.convertValue(resourceQueryDocument.getData(), ResourceQuery.class);
				resourceQueries.add(resourceQuery);
			}
			user.setQueries(resourceQueries);
			usersList.add(user);
		}

		return usersList;

	}

	

	public String getLastCheckedCommit() throws InterruptedException, ExecutionException {
		return getConfigDocumentFromDB("compare","commit","lastcommit");
	}
	
	public void addLastCheckedCommit(String lastCommit) {
		setConfigDataToDb(lastCommit,"compare","commit","lastcommit"  );
	}

	

	public Object getEtag() throws InterruptedException, ExecutionException  {
		return getConfigDocumentFromDB("compare","etags","etag");
	}
	
	public void addetag(String eTag) {
		setConfigDataToDb(eTag,"compare","etags","etag"  );
	}

	public void addWebhookData(String url) {
		DocumentReference docRef = db.collection("webhooks").document();
		Map<String, Object> docData = new HashMap<>();
		docData.put("url", url);
		docRef.set(docData,SetOptions.merge());
	}
	
	public List<String> getAllWebhookData() throws InterruptedException, ExecutionException  {
		ApiFuture<QuerySnapshot> query = db.collection("webhooks").get();
		QuerySnapshot querySnapshot = query.get();
		List<String> webhookUrlList = new ArrayList<String>();
		
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			webhookUrlList.add(document.getString("url"));
		}
		return webhookUrlList;
	}
	


	/**
	 * @param collection 
	 * @param docId 
	 * @param document 
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private String getConfigDocumentFromDB(String collection, String docId, String document) throws InterruptedException, ExecutionException {
		ApiFuture<DocumentSnapshot> query = db.collection(collection).document(docId).get();
		DocumentSnapshot querySnapshot = query.get();
		return (String) querySnapshot.getData().get(document);
	}
	
	/**
	 * @param data
	 * @param collection 
	 * @param docId 
	 * @param document 
	 */
	private void setConfigDataToDb(String data, String collection, String docId, String document) {
		DocumentReference docRef = db.collection(collection).document(docId);
		Map<String, Object> docData = new HashMap<>();
		docData.put(document, data);
		docRef.set(docData,SetOptions.merge());
	}
}
