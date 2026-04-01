package com.aviva.ca.esb.cl.opta.fus.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DwellingFireProtectionResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DwellingFireProtectionResponse", propOrder = { "baseResponse",
		"DwellingFireProtection" })
public class DwellingFireProtectionResponse {
	@XmlElement(name = "baseResponse", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	BaseResponse baseResponse;
	@XmlElement(name = "DwellingFireProtection", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	List<String> DwellingFireProtection;

	/**
	 * @return the dwellingFireProtection
	 */
	public List<String> getDwellingFireProtection() {
		if (DwellingFireProtection == null) {
			DwellingFireProtection = new ArrayList<String>();
		}
		return this.DwellingFireProtection;
	}

	/**
	 * @return the baseResponse
	 */
	public BaseResponse getBaseResponse() {
		return baseResponse;
	}

	/**
	 * @param baseResponse the baseResponse to set
	 */
	public void setBaseResponse(BaseResponse baseResponse) {
		this.baseResponse = baseResponse;
	}

	
}
