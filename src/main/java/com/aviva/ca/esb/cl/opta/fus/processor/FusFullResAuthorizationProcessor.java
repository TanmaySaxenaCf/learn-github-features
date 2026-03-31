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
import com.aviva.ca.esb.cl.opta.fus.model.FusProductRequest;

public class FusFullResAuthorizationProcessor implements Processor {

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
		FusProductRequest req = inMessage.getBody(FusProductRequest.class);
		if (null != req) {
			fusLoggingHelper(exchange,req);
			String province = req.getProvince();
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
	
	public void fusLoggingHelper(Exchange exchange,FusProductRequest req) {

		String url = StringUtils.EMPTY;
		Map<String, Object> exchangeMap = exchange.getIn().getHeaders();
		MessageImpl messageMap = null;
		if (exchangeMap.get("CamelCxfMessage") instanceof MessageImpl) {
			messageMap = (MessageImpl) exchangeMap.get("CamelCxfMessage");
			url = (messageMap != null && null != messageMap.get("org.apache.cxf.request.url"))
					? (String) messageMap.get("org.apache.cxf.request.url") : null;
		exchange.setProperty(LoggerConstants.LOG_URL, url);
		}
		
		if ("SOAP".equals(exchange.getProperty("CALL_TYPE"))) {
			exchange.setProperty(LoggerConstants.LOG_APPLICATION, LoggerConstants.APPLICATION_PRODUCT);
		}else{
			exchange.setProperty(LoggerConstants.LOG_APPLICATION, LoggerConstants.APPLICATION_REST);
		}
		
		exchange.setProperty("INITIAL_REQUEST", req);
		exchange.setProperty(LoggerConstants.LOG_TRANSACTION_ID, UUID.randomUUID().toString());
		exchange.setProperty(LoggerConstants.LOG_STREET_NAME, req.getStreetName());
		exchange.setProperty(LoggerConstants.LOG_POSTAL_CODE, req.getPostalCode());
		exchange.setProperty(LoggerConstants.LOG_MUNICIPALITY, req.getMunicipality());
		exchange.setProperty(LoggerConstants.LOG_PROVINCE, req.getProvince());
	}

}
