package com.aviva.ca.esb.cl.opta.fus.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.jaxrs.impl.ResponseImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aviva.ca.esb.cl.opta.fus.model.FusAuthResponse;

public class FusAuthServiceResponse implements Processor{
	private static final Logger LOG = LoggerFactory
			.getLogger(FusAuthServiceResponse.class);
	@Override
	public void process(Exchange exchange) throws Exception {
		ResponseImpl responseImpl = exchange.getIn().getBody(ResponseImpl.class);
		JSONParser parser = new JSONParser();
		JSONObject authResponse = (JSONObject) parser.parse(responseImpl.readEntity(String.class));
		FusAuthResponse res = new FusAuthResponse();
		if(null !=authResponse){
			LOG.info("Setting only accessToken");
			res.setAccesToken((String)authResponse.get("access_token"));
		}
		exchange.getOut().setBody(res);
	}
}
