package com.aviva.ca.esb.cl.opta.fus.processor;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import ca.optaintel.ws.optasingleservice._2.OSSRequestType;
import ca.optaintel.ws.optasingleservice._2.ProductType;
import ca.optaintel.ws.optasingleservice._2.RequestAddressType;
import ca.optaintel.ws.optasingleservice._2.RequestBodyType;
import ca.optaintel.ws.optasingleservice._2.RequestBusinessType;
import ca.optaintel.ws.optasingleservice._2.RequestHeaderType;
import ca.optaintel.ws.optasingleservice._2.RequestPropertyType;
import ca.optaintel.ws.optasingleservice._2.RequestedIndustryCodeType;
import ca.optaintel.ws.optasingleservice._2.RequestedProductsType;
import ca.optaintel.ws.optasingleservice._2.RequestorType;

import com.aviva.ca.esb.cl.opta.fus.model.FusAuthResponse;
import com.aviva.ca.esb.cl.opta.fus.model.FusProductRequest;

public class FusFullResAuthRequestProcessor implements Processor {

	private static final String DEFAULT_ADDRESS_ID = "1";
	private static final String OPERATION_NAME = "operationName";
	private static final String OPERATION_NAME_SPACE = "operationNamespace";
	private static final String CALL_METHOD_NAME = "call";
	private static final String CALL_METHOD_NAME_SPACE = "http://www.optaintel.ca/ws/OptaSingleService/1.0";
	
	private String reqid;
	private String broker;
	private String carrier;
	private String user;
	
	
	public String getReqid() {
		return reqid;
	}

	public void setReqid(String reqid) {
		this.reqid = reqid;
	}

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		

		Message inMessage = exchange.getIn();
		Message outMessage = exchange.getOut();

		FusAuthResponse res = inMessage.getBody(FusAuthResponse.class);
		FusProductRequest req = (FusProductRequest)exchange.getProperty("INITIAL_REQUEST");
		// Constructing the Req Obj
		OSSRequestType reqType = new OSSRequestType();
		// Constructing the Header Obj
		RequestHeaderType header = new RequestHeaderType();
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		header.setRequestID(reqid + randomUUIDString);
		header.setRequestSentTimestamp(stringToXMLGregorianCalendar());

		RequestorType requestorType = new RequestorType();
		requestorType.setBrokerage(broker);
		requestorType.setCarrier(carrier);
		requestorType.setUsername(user);
		header.setRequestor(requestorType);
		reqType.setRequestHeader(header);

		// Constructing the Body Obj
		RequestBodyType bodyType = new RequestBodyType();
		RequestBusinessType reqBusType = new RequestBusinessType();
		RequestedProductsType prodType = new RequestedProductsType();
		prodType.getProduct().add(ProductType.FUS);
		bodyType.setRequestedProducts(prodType);
		RequestPropertyType reqPropertyType = new RequestPropertyType();
		RequestAddressType addType = new RequestAddressType();
		addType.setAddressID(DEFAULT_ADDRESS_ID);
		addType.setMunicipality(req.getMunicipality());
		addType.setStreetName(req.getStreetName());
		addType.setPostalCode(req.getPostalCode());
		addType.setProvince(req.getProvince());
		RequestedIndustryCodeType icode = new RequestedIndustryCodeType();
		icode.setIBCCode(req.getIbcCode());
		icode.setSICCode(req.getSicCode());
		icode.setNAICSCode(req.getNaicsCode());
		reqBusType.setIndustryCodes(icode);
		reqPropertyType.getBusiness().add(reqBusType);
		bodyType.getProperty().add(reqPropertyType);
		reqPropertyType.setAddress(addType);
		reqType.setRequestBody(bodyType);
		outMessage.setBody(reqType);
		//Setting cache key in header and exchange property (exchange property to use it to set the cache if key not in cache)
		//Using request object hash as key. Request object should implement hashCode method (generate by eclipse)
		exchange.setProperty("CamelCacheKey", String.valueOf(icode.hashCode()+addType.hashCode()));
		outMessage.setHeader("CamelCacheKey", String.valueOf(icode.hashCode()+addType.hashCode()));
		outMessage.setHeader(OPERATION_NAME, CALL_METHOD_NAME);
		outMessage.setHeader(OPERATION_NAME_SPACE, CALL_METHOD_NAME_SPACE);
		outMessage.setHeader("Authorization", "Bearer "+res.getAccesToken());
	}

	private static XMLGregorianCalendar stringToXMLGregorianCalendar()
			throws ParseException, DatatypeConfigurationException

	{
		XMLGregorianCalendar result = null;
		GregorianCalendar gregorianCalendar;
		gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
		gregorianCalendar.setTime(Calendar.getInstance().getTime());
		result = DatatypeFactory.newInstance().newXMLGregorianCalendar(
				gregorianCalendar);
		return result;

	}

}
