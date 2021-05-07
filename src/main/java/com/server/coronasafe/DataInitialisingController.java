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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/initialise")
public class DataInitialisingController {

	@RequestMapping("/activeDistricts")
	public String activeDistricts() throws Exception {		
		 FirebaseUtil.addDataFromAPI("active_district_data","https://life-api.coronasafe.network/data/active_district_data_v2.json");
		return "Active District Data Added!";
	}
	
	@RequestMapping("/ambulance")
	public String ambulance() throws Exception {
		
		 FirebaseUtil.addDataFromAPI(ResourcesEnum.AMBULANCE);
		 return "Ambulance Data Added";
	}
	
	@RequestMapping("/helpline")
	public String helpline() throws Exception {
		
		 FirebaseUtil.addDataFromAPI("helpline","https://life-api.coronasafe.network/data/helpline_v2.json");
		 return "Helpline Data Added";
	}
	
	@RequestMapping("/hospitals")
	public String hospitals() throws Exception {		
		 FirebaseUtil.addDataFromAPI(ResourcesEnum.HOSPITALS);
		return "Hospitals Data Added!";
	}
	
	@RequestMapping("/medicine")
	public String medicine() throws Exception {
		
		 FirebaseUtil.addDataFromAPI(ResourcesEnum.MEDICINE);
		 return "Medicine Added";
	}
	
	@RequestMapping("/oxygen")
	public String oxygen() throws Exception {
		
		 FirebaseUtil.addDataFromAPI(ResourcesEnum.OXYGEN);
		 return "Oxygen Data Added";
	}
	
	@RequestMapping("/food")
	public String food() throws Exception {
		
		 FirebaseUtil.addFoodDataFromAPI(ResourcesEnum.FOOD);
		 return "Food Data Added";
	}

}
