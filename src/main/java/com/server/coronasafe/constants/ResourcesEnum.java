package com.server.coronasafe.constants;

public enum ResourcesEnum {

	OXYGEN("https://life-api.coronasafe.network/data/oxygen_v2.json","oxygen"),
	
	AMBULANCE("https://life-api.coronasafe.network/data/ambulance_v2.json","ambulance"),
	
	HOSPITALS("https://life-api.coronasafe.network/data/hospital_v2.json","hospital"),
	
	MEDICINE("https://life-api.coronasafe.network/data/medicine_v2.json","medicine"),
	
	FOOD("https://life-api.coronasafe.network/data/food_v2.json","food"),
	
	HELPLINE("https://life-api.coronasafe.network/data/helpline_v2.json","helpline");
	
	
	private String urlPath;
	private String resource;
	private ResourcesEnum(String urlPath, String resource) {
		this .urlPath = urlPath;
		this .resource = resource;
	}
	/**
	 * @return the urlPath
	 */
	public String getUrlPath() {
		return urlPath;
	}
	/**
	 * @param urlPath the urlPath to set
	 */
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	/**
	 * @return the resource
	 */
	public String getResource() {
		return resource;
	}
	/**
	 * @param resource the resource to set
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}
}
