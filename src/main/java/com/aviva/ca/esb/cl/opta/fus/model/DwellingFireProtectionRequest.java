package com.aviva.ca.esb.cl.opta.fus.model;

import io.swagger.annotations.ApiParam;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="DwellingFireProtectionRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DwellingFireProtectionRequest", propOrder = {
    "streetName",
    "postalCode",
    "municipality",
    "province",
    //"fullResReq",
    "ibcCode",
    "naicsCode",
    "sicCode"
})
public class DwellingFireProtectionRequest {
	@ApiParam(name = "streetAddress", required = true, value = "Stree Address")
	//@QueryParam("streetAddress")
	@XmlElement(name = "streetName", required = true,namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String streetName;
	
	@ApiParam(name = "postalCode", required = true, value = "Postal Code")
	//@QueryParam("postalCode") 
	@XmlElement(name = "postalCode", required = true, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String postalCode;
	
	@ApiParam(name = "municipality", required = true, value = "Municipality")
	//@QueryParam("municipality")
	@XmlElement(name = "municipality", required = true, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String municipality;
	
	@ApiParam(name = "province", required = true, value = "province")
	//@QueryParam("province")
	@XmlElement(name = "province", required = true,namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String province;
	
	/*@ApiParam(name = "fullResReq", required = true, value = "fullResReq")
	@QueryParam("fullResReq")
	@XmlElement(name = "fullResReq", required = true,  namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String fullResReq;
	*/
	@ApiParam(name = "ibcCode", required = false, value = "IBCCode")
	//@QueryParam("ibcCode")
	@XmlElement(name = "ibcCode", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String ibcCode;
	
	@ApiParam(name = "naicsCode", required = false, value = "NAICSCode")
	//@QueryParam("naicsCode")
	@XmlElement(name = "naicsCode",  required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String naicsCode;

	@ApiParam(name = "sicCode", required = false, value = "SICCode")
	//@QueryParam("sicCode")
	@XmlElement(name = "sicCode", required = false,  namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String sicCode;
	
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

	/**
	 * @return the ibcCode
	 */
	public String getIbcCode() {
		return ibcCode;
	}

	/**
	 * @param ibcCode the ibcCode to set
	 */
	public void setIbcCode(String ibcCode) {
		this.ibcCode = ibcCode;
	}

	/**
	 * @return the naicsCode
	 */
	public String getNaicsCode() {
		return naicsCode;
	}

	/**
	 * @param naicsCode the naicsCode to set
	 */
	public void setNaicsCode(String naicsCode) {
		this.naicsCode = naicsCode;
	}

	/**
	 * @return the sicCode
	 */
	public String getSicCode() {
		return sicCode;
	}

	/**
	 * @param sicCode the sicCode to set
	 */
	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}

	/**
	 * @return the fullResReq
	 *//*
	public String getFullResReq() {
		return fullResReq;
	}

	*//**
	 * @param fullResReq the fullResReq to set
	 *//*
	public void setFullResReq(String fullResReq) {
		this.fullResReq = fullResReq;
	}*/
	

}
