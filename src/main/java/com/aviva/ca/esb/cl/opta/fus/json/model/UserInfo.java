package com.aviva.ca.esb.cl.opta.fus.json.model;

public class UserInfo {

	private String userName;
	private String[] allowedProvinces;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String[] getAllowedProvinces() {
		return allowedProvinces.clone();
	}
	public void setAllowedProvinces(String[] allowedProvinces) {
		this.allowedProvinces = allowedProvinces.clone();
	}
	
	
}
