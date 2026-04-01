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
import com.aviva.ca.esb.cl.opta.fus.model.FusProductRequest;

/**
 * @author tcs_2250441
 *
 */
public class FusFullResRequestPreProcessor implements Processor {
	private static final Logger LOG = LoggerFactory
			.getLogger(FusFullResRequestPreProcessor.class);
	
	final String INVALID_REQUEST = "Invalid Request, Missing Fields: ";
	final String DELIMITER = " , ";
	final String EMPTY = "";
	@Override
	public void process(Exchange exchange) throws Exception {
		Message inMessage = exchange.getIn();
		FusProductRequest req = inMessage.getBody(FusProductRequest.class);
		if(validateField(req.getStreetName())){
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1001");
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Street Address field is blank");
			throw new ResponseError("FS1001","Street Address field is blank");
		}
		if(validateField(req.getPostalCode())){
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1002");
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Postal Code field is blank");
			throw new ResponseError("FS1002","Postal Code field is blank");
		}
		if(validateField(req.getMunicipality())){
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1003");
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Municipality field is blank");
			throw new ResponseError("FS1003","Municipality field is blank");
		}
		if(validateField(req.getProvince())){
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, "FS1004");
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, "Province field is blank");
			throw new ResponseError("FS1004","Province field is blank");
		}
		//exchange.setProperty("INITIAL_REQUEST", req);
	}

	private boolean validateField(String value) {

		if (StringUtils.isBlank(value))
			return true;
		return false;
	}

}
