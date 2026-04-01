/**
 * 
 */
package com.aviva.ca.esb.cl.opta.fus.model;

import io.swagger.annotations.ApiParam;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author tcs_2250441
 *
 */
@XmlRootElement(name="FusRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FusRequest", propOrder = {
    "baseRequest",
    "DwellingFireProtectionRequest"
})
public class FusRequest {
	@XmlElement(name = "baseRequest", required = true,namespace = "http://api.esb.ca.aviva.com/v1.0/")
	BaseRequest baseRequest;
	@XmlElement(name = "DwellingFireProtectionRequest", required = true,namespace = "http://api.esb.ca.aviva.com/v1.0/")
	DwellingFireProtectionRequest DwellingFireProtectionRequest;
	/**
	 * @return the baseRequest
	 */
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}
	/**
	 * @param baseRequest the baseRequest to set
	 */
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}
	/**
	 * @return the dwellingFireProtectionRequest
	 */
	public DwellingFireProtectionRequest getDwellingFireProtectionRequest() {
		return DwellingFireProtectionRequest;
	}
	/**
	 * @param dwellingFireProtectionRequest the dwellingFireProtectionRequest to set
	 */
	public void setDwellingFireProtectionRequest(
			DwellingFireProtectionRequest dwellingFireProtectionRequest) {
		DwellingFireProtectionRequest = dwellingFireProtectionRequest;
	}
	
	
}
