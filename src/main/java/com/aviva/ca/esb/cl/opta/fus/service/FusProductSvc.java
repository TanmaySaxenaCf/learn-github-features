package com.aviva.ca.esb.cl.opta.fus.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.aviva.ca.esb.cl.opta.fus.model.FusProductRequest;
import com.aviva.ca.esb.cl.opta.fus.model.FusProductResponse;
import com.aviva.ca.esb.cl.opta.fus.model.SOAPServiceException;

@WebService(name = "FUSProductService", targetNamespace = "http://api.esb.ca.aviva.com/v1.0/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface FusProductSvc {
	@WebMethod
	@WebResult(name = "FusProductResponse", targetNamespace = "http://www.optaintel.ca/ws/OptaSingleService/1.0", partName = "Response")
	public FusProductResponse getFusScore(
			@WebParam(name = "FusProductRequest", targetNamespace = "http://api.esb.ca.aviva.com/v1.0/", partName = "Request") FusProductRequest parameters)
			throws SOAPServiceException;
}
