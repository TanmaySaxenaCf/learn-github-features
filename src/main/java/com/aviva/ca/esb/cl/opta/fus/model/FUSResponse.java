/**
 * 
 */
package com.aviva.ca.esb.cl.opta.fus.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ca.optaintel.ws.optasingleservice._2.FUSProductCommercialType;
import ca.optaintel.ws.optasingleservice._2.FUSProductDwellingType;
import ca.optaintel.ws.optasingleservice._2.ResponseBodyType;

/**
 * @author tcs_2250441
 *
 */
@XmlRootElement(name = "FUSResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FUSResponse", propOrder = { //"ResponseBodyType",
		"DwellingFireProtectionResponse" })
public class FUSResponse {
	/*@XmlElement(name = "ResponseBodyType", required = false)
	ResponseBodyType ResponseBodyType;*/
	@XmlElement(name = "DwellingFireProtectionResponse", required = false)
	DwellingFireProtectionResponse DwellingFireProtectionResponse;
	/**
	 * @return the responseBodyType
	 *//*
	public ResponseBodyType getResponseBodyType() {
		return ResponseBodyType;
	}
	*//**
	 * @param responseBodyType the responseBodyType to set
	 *//*
	public void setResponseBodyType(ResponseBodyType responseBodyType) {
		ResponseBodyType = responseBodyType;
	}*/
	/**
	 * @return the dwellingFireProtectionResponse
	 */
	public DwellingFireProtectionResponse getDwellingFireProtectionResponse() {
		return DwellingFireProtectionResponse;
	}
	/**
	 * @param dwellingFireProtectionResponse the dwellingFireProtectionResponse to set
	 */
	public void setDwellingFireProtectionResponse(
			DwellingFireProtectionResponse dwellingFireProtectionResponse) {
		DwellingFireProtectionResponse = dwellingFireProtectionResponse;
	}

	
}
