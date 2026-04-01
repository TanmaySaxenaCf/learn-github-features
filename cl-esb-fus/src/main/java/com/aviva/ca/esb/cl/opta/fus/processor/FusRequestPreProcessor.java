/**
 * 
 */
package com.aviva.ca.esb.cl.opta.fus.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aviva.ca.esb.cl.opta.fus.json.model.ResponseError;
import com.aviva.ca.esb.cl.opta.fus.logging.LoggerConstants;
import com.aviva.ca.esb.cl.opta.fus.model.FusRequest;

/**
 * @author tcs_2250441
 *
 */
public class FusRequestPreProcessor implements Processor {
	private static final Logger LOG = LoggerFactory
			.getLogger(FusRequestPreProcessor.class);
	
	final String INVALID_REQUEST = "Invalid Request, Missing Fields: ";
	final String DELIMITER = " , ";
	final String EMPTY = "";
	@Override
	public void process(Exchange exchange) throws Exception {
		Message inMessage = exchange.getIn();
		FusRequest req = inMessage.getBody(FusRequest.class);
		if(validateField(req.getDwellingFireProtectionRequest().getStreetName())){
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1001");
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Street Address field is blank");
			throw new ResponseError("FS1001","Street Address field is blank");
		}
		if(validateField(req.getDwellingFireProtectionRequest().getPostalCode())){
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1002");
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Postal Code field is blank");
			throw new ResponseError("FS1002","Postal Code field is blank");
		}
		if(validateField(req.getDwellingFireProtectionRequest().getMunicipality())){
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1003");
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Municipality field is blank");
			throw new ResponseError("FS1003","Municipality field is blank");
		}
		if(validateField(req.getDwellingFireProtectionRequest().getProvince())){
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1004");
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Province field is blank");
			throw new ResponseError("FS1004","Province field is blank");
		}
		/*if(validateField(req.getDwellingFireProtectionRequest().getFullResReq())){
			throw new ResponseError("FUS006","Full Response Required Field will be Y or N");
		}*/
	}

	private boolean validateField(String value) {

		if (StringUtils.isBlank(value))
			return true;
		return false;
	}

}
