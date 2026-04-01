/**
 * 
 */
package com.aviva.ca.esb.cl.opta.fus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author tcs_2250441
 *
 */
public class FusAuthResponse {
	@JsonProperty("access_token")
	private String accesToken;
	@JsonProperty("expires_in")
	private String expiresIn;
	@JsonProperty("refresh_expires_in")
	private String refreshExpiresIn;
	@JsonProperty("refresh_token")
	private String refreshToken;
	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("not-before-policy")
	private String notBeforePolicy;
	@JsonProperty("session_state")
	private String sessionState;
	public String getAccesToken() {
		return accesToken;
	}
	public void setAccesToken(String accesToken) {
		this.accesToken = accesToken;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefreshExpiresIn() {
		return refreshExpiresIn;
	}
	public void setRefreshExpiresIn(String refreshExpiresIn) {
		this.refreshExpiresIn = refreshExpiresIn;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getNotBeforePolicy() {
		return notBeforePolicy;
	}
	public void setNotBeforePolicy(String notBeforePolicy) {
		this.notBeforePolicy = notBeforePolicy;
	}
	public String getSessionState() {
		return sessionState;
	}
	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}
	
}
