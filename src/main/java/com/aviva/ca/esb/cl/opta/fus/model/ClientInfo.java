package com.aviva.ca.esb.cl.opta.fus.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="clientInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clientInfo", propOrder = {
    "clientID",
    "clientName",
    "clientGUID",
    "transactionTime"
})
public class ClientInfo {
	@XmlElement(name = "clientID", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String clientID;
	@XmlElement(name = "clientName", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String clientName;
	@XmlElement(name = "clientGUID", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String clientGUID;
	@XmlElement(name = "transactionTime", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String transactionTime;
	/**
	 * @return the clientID
	 */
	public String getClientID() {
		return clientID;
	}
	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return the clientGUID
	 */
	public String getClientGUID() {
		return clientGUID;
	}
	/**
	 * @param clientGUID the clientGUID to set
	 */
	public void setClientGUID(String clientGUID) {
		this.clientGUID = clientGUID;
	}
	/**
	 * @return the transactionTime
	 */
	public String getTransactionTime() {
		return transactionTime;
	}
	/**
	 * @param transactionTime the transactionTime to set
	 */
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	
}
