/**
 * 
 */
package com.aviva.ca.esb.cl.opta.fus.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.aviva.ca.esb.cl.opta.fus.model.FusAuthRequest;

/**
 * @author tcs_2250441
 *
 */
public class FusAuthServiceProcessor implements Processor{
	String authToken;
	String grantType;
	String clientSecret;
	String clientId;
	
	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		FusAuthRequest req = new FusAuthRequest();
		req.setGrant_type(grantType);
		req.setClient_secret(clientSecret);
		req.setClient_id(clientId);
		req.setRefresh_token(authToken);
		String query = "grant_type="+grantType+"&client_secret="+clientSecret+"&client_id="+clientId+"&refresh_token="+authToken;
		exchange.getOut().setBody(query);

		exchange.getOut().getHeaders().remove(Exchange.CONTENT_TYPE);
		exchange.getOut().setHeader(Exchange.CONTENT_TYPE, "application/x-www-form-urlencoded");
	}
}
