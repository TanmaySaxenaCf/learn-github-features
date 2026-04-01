package com.aviva.ca.esb.cl.opta.fus.json.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aviva.ca.esb.cl.opta.fus.json.model.AuthorizationLookup;
import com.aviva.ca.esb.cl.opta.fus.json.model.ErrorMessageLookup;
import com.aviva.ca.esb.cl.opta.fus.json.model.OptaOssACL;
import com.aviva.ca.esb.cl.opta.fus.json.model.UserInfo;


public class DataCacheLoader {

	private static final Logger LOG = LoggerFactory.getLogger(DataCacheLoader.class);

	public void loadJsonData(List dataList) {
		
		if (dataList != null && dataList.size() > 0) {
			if (dataList.get(0) instanceof ErrorMessageLookup) {
				Map<String, ErrorMessageLookup> errorMessageLookup = new HashMap<String, ErrorMessageLookup>();
				List<ErrorMessageLookup> errorMsgLookupArrayList = (ArrayList<ErrorMessageLookup>) dataList;
				for (ErrorMessageLookup errorMessageLookUp : errorMsgLookupArrayList) {
					errorMessageLookup.put(errorMessageLookUp.getErrorCode(),
									errorMessageLookUp);
					}				
				DataCache.getInstance().setErrorLookup(errorMessageLookup);
			}
		}

		if (dataList != null && dataList.size() > 0) {
			if (dataList.get(0) instanceof AuthorizationLookup) {
				Map<String, String[]> authLookupMap = new HashMap<String, String[]>();
				List<AuthorizationLookup> authLookupArrayList = (ArrayList<AuthorizationLookup>) dataList;
				for (AuthorizationLookup authLookUp : authLookupArrayList) {
					OptaOssACL optaAcl = authLookUp.getOptaOssACL();
					for (UserInfo userinfo : optaAcl.getUserInfo()) {
						authLookupMap.put(userinfo.getUserName(),
								userinfo.getAllowedProvinces());
					}
				}
				DataCache.getInstance().setUserInfo(authLookupMap);
			}
		}
	
	}
}
