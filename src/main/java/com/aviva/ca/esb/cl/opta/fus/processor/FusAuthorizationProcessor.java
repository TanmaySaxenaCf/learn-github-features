package com.aviva.ca.esb.cl.opta.fus.processor;

import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.message.MessageImpl;

import com.aviva.ca.esb.cl.opta.fus.json.model.ResponseError;
import com.aviva.ca.esb.cl.opta.fus.logging.LoggerConstants;
import com.aviva.ca.esb.cl.opta.fus.model.ClientInfo;
import com.aviva.ca.esb.cl.opta.fus.model.DwellingFireProtectionRequest;
import com.aviva.ca.esb.cl.opta.fus.model.FusRequest;

public class FusAuthorizationProcessor implements Processor {

	private String UNAUTHORISED = "FS1005";
	private String CONST_AUTH_ERROR = "Provided Province is not authorized to view operation.";
	
	private String provinceIds;
	public String getProvinceIds() {
		return provinceIds;
	}
	public void setProvinceIds(String provinceIds) {
		this.provinceIds = provinceIds;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		Message inMessage = exchange.getIn();
		FusRequest req = inMessage.getBody(FusRequest.class);
		if (null != req) {
			fusLoggingHelper(exchange,req);
			String province = req.getDwellingFireProtectionRequest().getProvince();
			if (StringUtils.isNotEmpty(province)) {
				province = province.toUpperCase(Locale.ROOT);
			}else{
				exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1004");
				exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Province field is blank");
				throw new ResponseError("FS1004","Province field is blank");
			}
			
			if (provinceIds.isEmpty() || !isProvincePresent(provinceIds,province)) {
				exchange.setProperty(LoggerConstants.LOG_ERRORCODE, UNAUTHORISED);
				exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, CONST_AUTH_ERROR);
				throw new ResponseError(UNAUTHORISED, CONST_AUTH_ERROR);
			}
			
		}
	
	}
	
	private boolean isProvincePresent(String provinceList,String province){
		boolean isAvailable = false;
		String[] provinceIds = provinceList.split(",");
		for(String prov: provinceIds){
			if(province.equalsIgnoreCase(prov.trim())){
				isAvailable = true;
				break;
			}
		}
		return isAvailable;
	} 
	
	public void fusLoggingHelper(Exchange exchange,FusRequest req) {

		String url = StringUtils.EMPTY;
		Map<String, Object> exchangeMap = exchange.getIn().getHeaders();
		MessageImpl messageMap = null;
		if (exchangeMap.get("CamelCxfMessage") instanceof MessageImpl) {
			messageMap = (MessageImpl) exchangeMap.get("CamelCxfMessage");
			url = (messageMap != null && null != messageMap.get("org.apache.cxf.request.url"))
					? (String) messageMap.get("org.apache.cxf.request.url") : null;
		exchange.setProperty(LoggerConstants.LOG_URL, url);
		}
		exchange.setProperty("INITIAL_REQUEST", req);
		exchange.setProperty(LoggerConstants.LOG_TRANSACTION_ID, UUID.randomUUID().toString());
		exchange.setProperty(LoggerConstants.LOG_APPLICATION, LoggerConstants.APPLICATION_SOAP);
		//exchange.setProperty(LoggerConstants.LOG_TRANSACTION_TIME, new Date());
		
		if (req.getBaseRequest() != null && req.getBaseRequest().getClientInfo() != null) {
			ClientInfo inputClientInfo = req.getBaseRequest().getClientInfo();
			exchange.setProperty(LoggerConstants.LOG_CLIENTGUID, inputClientInfo.getClientGUID());
			exchange.setProperty(LoggerConstants.LOG_CLIENTID, inputClientInfo.getClientID());
			exchange.setProperty(LoggerConstants.LOG_CLIENTNAME, inputClientInfo.getClientName());
		}
		
		if(req.getDwellingFireProtectionRequest()!=null){
			DwellingFireProtectionRequest dwellRes = req.getDwellingFireProtectionRequest();
			if(dwellRes.getMunicipality()!=null){
				exchange.setProperty(LoggerConstants.LOG_MUNICIPALITY, dwellRes.getMunicipality());
			}
			if(dwellRes.getPostalCode()!=null){
				exchange.setProperty(LoggerConstants.LOG_POSTAL_CODE, dwellRes.getPostalCode());
			}
			if(dwellRes.getProvince()!=null){
				exchange.setProperty(LoggerConstants.LOG_PROVINCE, dwellRes.getProvince());
			}
			if(dwellRes.getStreetName()!=null){
				exchange.setProperty(LoggerConstants.LOG_STREET_NAME, dwellRes.getStreetName());
			}
		}
	}
}
