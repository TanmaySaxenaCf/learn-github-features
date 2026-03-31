package com.aviva.ca.esb.cl.opta.fus.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="baseResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseResponse", propOrder = {
    "clientInfo",
    "isSuccessful"     
})
public class BaseResponse {
	@XmlElement(name = "clientInfo", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	ClientInfo clientInfo;
	@XmlElement(name = "isSuccessful", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	boolean isSuccessful;
	/**
	 * @return the clientInfo
	 */
	public ClientInfo getClientInfo() {
		return clientInfo;
	}
	/**
	 * @param clientInfo the clientInfo to set
	 */
	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}
	/**
	 * @return the isSuccessful
	 */
	public boolean isSuccessful() {
		return isSuccessful;
	}
	/**
	 * @param isSuccessful the isSuccessful to set
	 */
	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	
}
