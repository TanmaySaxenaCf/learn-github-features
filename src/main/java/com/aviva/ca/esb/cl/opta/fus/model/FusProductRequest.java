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
@XmlRootElement(name="FusProductRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FusProductRequest", propOrder = {    "streetName",
	    "postalCode",
	    "municipality",
	    "province",
	    "ibcCode",
	    "naicsCode",
	    "sicCode"
})
public class FusProductRequest {
	@ApiParam(name = "streetAddress", required = true, value = "Stree Address")
	@QueryParam("streetAddress")
	@XmlElement(name = "streetName", required = true,namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String streetName;
	
	@ApiParam(name = "postalCode", required = true, value = "Postal Code")
	@QueryParam("postalCode") 
	@XmlElement(name = "postalCode", required = true, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String postalCode;
	
	@ApiParam(name = "municipality", required = true, value = "Municipality")
	@QueryParam("municipality")
	@XmlElement(name = "municipality", required = true, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String municipality;
	
	@ApiParam(name = "province", required = true, value = "province")
	@QueryParam("province")
	@XmlElement(name = "province", required = true,namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String province;
	
	@ApiParam(name = "ibcCode", required = false, value = "IBCCode")
	@QueryParam("ibcCode")
	@XmlElement(name = "ibcCode", required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String ibcCode;
	
	@ApiParam(name = "naicsCode", required = false, value = "NAICSCode")
	@QueryParam("naicsCode")
	@XmlElement(name = "naicsCode",  required = false, namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String naicsCode;

	@ApiParam(name = "sicCode", required = false, value = "SICCode")
	@QueryParam("sicCode")
	@XmlElement(name = "sicCode", required = false,  namespace = "http://api.esb.ca.aviva.com/v1.0/")
	String sicCode;

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the municipality
	 */
	public String getMunicipality() {
		return municipality;
	}

	/**
	 * @param municipality the municipality to set
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
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
	
}
