/**
 * 
 */
package com.aviva.ca.esb.cl.opta.fus.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author tcs_2250441
 *
 */
@XmlRootElement(name="baseRequest")
 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "baseRequest", propOrder = {
     "clientInfo",
     "language"     
 })
public class BaseRequest {
	@XmlElement(name = "clientInfo", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	ClientInfo clientInfo;
	@XmlElement(name = "language", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String language;
	
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
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
