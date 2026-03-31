package com.aviva.ca.esb.cl.opta.fus.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.aviva.ca.esb.cl.opta.fus.model.FUSResponse;
import com.aviva.ca.esb.cl.opta.fus.model.FusRequest;
import com.aviva.ca.esb.cl.opta.fus.model.SOAPServiceException;

@WebService(name = "OssFUSService", targetNamespace = "http://api.esb.ca.aviva.com/v1.0/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface FusSvc {
	@WebMethod
	@WebResult(name = "FUSResponse", targetNamespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", partName = "Response")
	public FUSResponse getFusScore(
			@WebParam(name = "FusRequest", targetNamespace = "http://api.esb.ca.aviva.com/v1.0/", partName = "Request") FusRequest parameters)
			throws SOAPServiceException;
}
