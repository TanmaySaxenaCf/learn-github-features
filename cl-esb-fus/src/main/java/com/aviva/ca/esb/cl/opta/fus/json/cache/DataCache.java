package com.aviva.ca.esb.cl.opta.fus.json.cache;

import java.util.HashMap;
import java.util.Map;

import com.aviva.ca.esb.cl.opta.fus.json.model.ErrorMessageLookup;


public class DataCache {

	public static DataCache dataCache_instance;
	Map<String, ErrorMessageLookup> errorLookup = new HashMap<String, ErrorMessageLookup>();
	Map<String, String[]> userInfo = new HashMap<String, String[]>();
	
	private DataCache() {
	}

	public static DataCache getInstance() {
		if (dataCache_instance == null) {
			synchronized (DataCache.class) {
				if (dataCache_instance == null) {
					dataCache_instance = new DataCache();
				}
			}
		}
		return dataCache_instance;
	}

	public Map<String, ErrorMessageLookup> getErrorLookup() {
		return errorLookup;
	}

	public void setErrorLookup(Map<String, ErrorMessageLookup> errorLookup) {
		this.errorLookup = errorLookup;
	}

	public Map<String, String[]> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Map<String, String[]> userInfo) {
		this.userInfo = userInfo;
	}
		
}
