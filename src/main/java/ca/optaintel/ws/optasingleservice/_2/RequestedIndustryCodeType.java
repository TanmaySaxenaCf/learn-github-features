
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestedIndustryCodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestedIndustryCodeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SICCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBCCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAICSCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestedIndustryCodeType", propOrder = {
    "sicCode",
    "ibcCode",
    "naicsCode"
})
public class RequestedIndustryCodeType {

    @XmlElement(name = "SICCode")
    protected String sicCode;
    @XmlElement(name = "IBCCode")
    protected String ibcCode;
    @XmlElement(name = "NAICSCode")
    protected String naicsCode;

    /**
     * Gets the value of the sicCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSICCode() {
        return sicCode;
    }

    /**
     * Sets the value of the sicCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSICCode(String value) {
        this.sicCode = value;
    }

    /**
     * Gets the value of the ibcCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBCCode() {
        return ibcCode;
    }

    /**
     * Sets the value of the ibcCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBCCode(String value) {
        this.ibcCode = value;
    }

    /**
     * Gets the value of the naicsCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAICSCode() {
        return naicsCode;
    }

    /**
     * Sets the value of the naicsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAICSCode(String value) {
        this.naicsCode = value;
    }

}
