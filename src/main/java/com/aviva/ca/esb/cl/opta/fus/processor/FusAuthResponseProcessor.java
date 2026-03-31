package com.aviva.ca.esb.cl.opta.fus.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ca.optaintel.ws.optasingleservice._2.OSSResponseType;

public class FusAuthResponseProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		OSSResponseType res = exchange.getIn().getBody(OSSResponseType.class);
		exchange.getOut().setBody(res.getResponseBody());
		
	}
}
