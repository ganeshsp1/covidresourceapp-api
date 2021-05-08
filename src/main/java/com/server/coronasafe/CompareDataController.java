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
@RequestMapping("/compare")
public class CompareDataController {

	@RequestMapping("/ambulance")
	public String compareAmbulance() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.compareData(ResourcesEnum.AMBULANCE,FirebaseUtil.getCurrentLastCommit(ResourcesEnum.AMBULANCE.resource)));
	}
	
	@RequestMapping("/hospital")
	public String compareHospitals() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.compareData(ResourcesEnum.HOSPITALS,FirebaseUtil.getCurrentLastCommit(ResourcesEnum.HOSPITALS.resource)));
	}
	
	@RequestMapping("/medicine")
	public String compareMedicine() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.compareData(ResourcesEnum.MEDICINE,FirebaseUtil.getCurrentLastCommit(ResourcesEnum.MEDICINE.resource)));
	}
	
	@RequestMapping("/oxygen")
	public String compareOxygen() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.compareData(ResourcesEnum.OXYGEN,FirebaseUtil.getCurrentLastCommit(ResourcesEnum.OXYGEN.resource)));
	}
	
	@RequestMapping("/food")
	public String compareFood() throws Exception {		
		return FirebaseUtil.getDataString(FirebaseUtil.compareData(ResourcesEnum.FOOD,FirebaseUtil.getCurrentLastCommit(ResourcesEnum.FOOD.resource)));
	}
	
	@RequestMapping("/resources")
	public String findResources() throws Exception {		
		 return FirebaseUtil.sendMessages();
	}
	
	

}
