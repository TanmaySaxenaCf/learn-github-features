package com.aviva.ca.esb.cl.opta.fus.processor;

import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aviva.ca.esb.cl.opta.fus.json.cache.DataCache;
import com.aviva.ca.esb.cl.opta.fus.json.model.ErrorDetails;
import com.aviva.ca.esb.cl.opta.fus.json.model.ErrorMessageLookup;
import com.aviva.ca.esb.cl.opta.fus.json.model.ResponseError;
import com.aviva.ca.esb.cl.opta.fus.logging.LoggerConstants;
import com.aviva.ca.esb.cl.opta.fus.model.DetailException;
import com.aviva.ca.esb.cl.opta.fus.model.SOAPServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorProcessor implements Processor {

	private static final Logger LOG = LoggerFactory
			.getLogger(ErrorProcessor.class);
	private static final String UNKNOWN_ERR_CD = "FS2001";

	@Override
	public void process(Exchange exchange) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		Throwable exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT,
				Throwable.class);

		LOG.info("Error Handling exception in route as non 200 HTTP response. Exception::::"
				+ exception.getMessage());
		
		exchange.setProperty(LoggerConstants.LOG_STATUS, LoggerConstants.ERROR);
		
		if (exception != null) {
			// javax.naming.AuthenticationException: [LDAP: error code 49 -
			// Invalid Credentials]
			// org.apache.cxf.interceptor.security.AccessDeniedException:
			// Unauthorized
			Map<String, ErrorMessageLookup> errorLookup = DataCache
					.getInstance().getErrorLookup();

			ErrorMessageLookup errorMessage = null;
			if (exception instanceof ResponseError) {
				ResponseError res = (ResponseError) exception;
				if("FS3001".equals(res.getCode())||"FS7001".equals(res.getCode())){
					errorMessage  = new ErrorMessageLookup();
					errorMessage.setErrorCode(res.getCode());
					errorMessage.setErrorDesc(res.getMessage());
				} else {
				errorMessage = errorLookup.get(res.getCode());
				LOG.info(errorMessage.getErrorCode() + "-->"
						+ errorMessage.getErrorDesc());
				}
			} else {
				errorMessage = errorLookup.get(UNKNOWN_ERR_CD);
			}

			ErrorDetails objErrorDetails = new ErrorDetails(
					errorMessage.getErrorCode(), errorMessage.getErrorDesc());
			
			exchange.setProperty(LoggerConstants.LOG_ERRORCODE, errorMessage.getErrorCode());
			exchange.setProperty(LoggerConstants.LOG_ERRORMESSAGE, errorMessage.getErrorDesc());
			
			
			if ("SOAP".equals(exchange.getProperty("CALL_TYPE"))) {
				LOG.debug("Inside SOAP Response");
				convertToSoapFault(objErrorDetails,exchange);
			} else {
				int statusCode ;
				if (errorMessage.getErrorCode().equals("FS1005")) {
					statusCode = 403;
				} else if (errorMessage.getErrorCode().equals("FS3001")
						|| errorMessage.getErrorCode().equals("FS7001")) {
					statusCode = 500;
				} else {
					statusCode = 400;
				}
				
				String jsonResponse = mapper.writeValueAsString(objErrorDetails);
				
				Response response = Response.status(statusCode)
						.entity(jsonResponse)
						.build();
				
				exchange.setProperty(LoggerConstants.LOG_RESPAYLOAD, jsonResponse);
				exchange.getOut().setBody(response);
			}
		}
	}
	
	private void convertToSoapFault(ErrorDetails errorResponse,Exchange exchange) throws SOAPServiceException {
		if (null != errorResponse) {
			DetailException detailException = new DetailException();
			detailException.setErrorCode(errorResponse.getCode());
			detailException.setErrorMessage(errorResponse.getMessage());
			SOAPServiceException errorRes = new SOAPServiceException("Exception Occured", detailException);
			exchange.setProperty(LoggerConstants.LOG_RESPAYLOAD, errorRes.getFaultInfo());
			exchange.getOut().setBody(detailException);
		}
	}
	
	public void returnSoapResponse(Exchange exchange) throws SOAPServiceException {
			DetailException detailException = exchange.getIn().getBody(DetailException.class);
			throw new SOAPServiceException("Exception Occured", detailException);
	}
}
 