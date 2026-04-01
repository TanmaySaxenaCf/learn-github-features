package com.aviva.ca.esb.cl.opta.fus.logging;

import java.util.Date;

public class FusTransactionLog {

	private String transactionId;
	private String application;
	private String url;
	private Date transactionTime;
	private String clientID;
	private String clientName;
	private String clientGUID;
	private String dwellingFireProtection;
	private String streetName;
	private String postalCode;
	private String municipality;
	private String province;
	private String reqPayload;
	private String resPayload;
	private String status;
	private String errorCode;
	private String errorMessage;
	
	public FusTransactionLog(String transactionId, String application, String url, Date transactionTime,
			String clientID, String clientName, String clientGUID, String dwellingFireProtection, String streetName,
			String postalCode, String municipality, String province, String reqPayload, String resPayload,
			String status, String errorCode, String errorMessage) {
		super();
		this.transactionId = transactionId;
		this.application = application;
		this.url = url;
		this.transactionTime = transactionTime;
		this.clientID = clientID;
		this.clientName = clientName;
		this.clientGUID = clientGUID;
		this.dwellingFireProtection = dwellingFireProtection;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.municipality = municipality;
		this.province = province;
		this.reqPayload = reqPayload;
		this.resPayload = resPayload;
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientGUID() {
		return clientGUID;
	}

	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}

	public String getDwellingFireProtection() {
		return dwellingFireProtection;
	}

	public void setDwellingFireProtection(String dwellingFireProtection) {
		this.dwellingFireProtection = dwellingFireProtection;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getReqPayload() {
		return reqPayload;
	}

	public void setReqPayload(String reqPayload) {
		this.reqPayload = reqPayload;
	}

	public String getResPayload() {
		return resPayload;
	}

	public void setResPayload(String resPayload) {
		this.resPayload = resPayload;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}