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

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.server.coronasafe.models.Data;

/**
 * A simple Quick start application demonstrating how to connect to Firestore
 * and add and query documents.
 */
public class CoronasafelifeFirestore {

	private Firestore db;

	/**
	 * Initialize Firestore using default project ID.
	 */
	public CoronasafelifeFirestore() {
		// [START fs_initialize]
		// [START firestore_setup_client_create]
		Firestore db = FirestoreOptions.getDefaultInstance().getService();
		// [END firestore_setup_client_create]
		// [END fs_initialize]
		this.db = db;
	}

	public CoronasafelifeFirestore(String projectId) throws Exception {
		FileInputStream serviceAccount = new FileInputStream("coronasafe-life-firebase-adminsdk-9w2x4-0b766bc577.json");	
		// [START fs_initialize_project_id]
		// [START firestore_setup_client_create_with_project_id]
		FirestoreOptions firestoreOptions =
				FirestoreOptions.getDefaultInstance().toBuilder()
				.setProjectId(projectId)
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();
		Firestore db = firestoreOptions.getService();
		// [END firestore_setup_client_create_with_project_id]
		// [END fs_initialize_project_id]
		this.db = db;
	}

	Firestore getDb() {
		return db;
	}


	void runQuery() throws Exception {
		// [START fs_add_query]
		// asynchronously query for all users born before 1900
		ApiFuture<QuerySnapshot> query =
				db.collection("users").whereLessThan("born", 1900).get();
		// ...
		// query.get() blocks on response
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			System.out.println("User: " + document.getId());
			System.out.println("First: " + document.getString("first"));
			if (document.contains("middle")) {
				System.out.println("Middle: " + document.getString("middle"));
			}
			System.out.println("Last: " + document.getString("last"));
			System.out.println("Born: " + document.getLong("born"));
		}
		// [END fs_add_query]
	}

	void addData( Data details, String resource) throws Exception {

		DocumentReference docRef = db.collection("data").document(resource);
		ApiFuture<WriteResult> result = docRef.create(details);
		
		System.out.println(result.toString());
	}


	/** Closes the gRPC channels associated with this instance and frees up their resources. */
	void close() throws Exception {
		db.close();
	}

	public void getAllUsers() throws InterruptedException, ExecutionException {
		ApiFuture<QuerySnapshot> query = db.collection("Users").get();
		// ...
		// query.get() blocks on response
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
			System.out.println("User: " + document.getId());
			System.out.println("Token: " + document.getString("token"));
		}

	}
	
	public Data getData(String resource) throws InterruptedException, ExecutionException {
		ApiFuture<DocumentSnapshot> query = db.collection("data").document(resource).get();
		DocumentSnapshot querySnapshot = query.get();
		ObjectMapper mapper = new ObjectMapper();
		Data data = mapper.convertValue(querySnapshot.getData(), Data.class);
		return data;
	}
}
