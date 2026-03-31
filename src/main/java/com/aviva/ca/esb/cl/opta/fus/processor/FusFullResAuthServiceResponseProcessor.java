package com.aviva.ca.esb.cl.opta.fus.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.optaintel.ws.optasingleservice._2.OSSResponseType;

import com.aviva.ca.esb.cl.opta.fus.model.FusProductResponse;

public class FusFullResAuthServiceResponseProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		OSSResponseType res = exchange.getIn().getBody(OSSResponseType.class);
		FusProductResponse finalResponse = new FusProductResponse();
		finalResponse.setResponseBodyType(res.getResponseBody());
		exchange.getOut().setBody(finalResponse);
	}
}
