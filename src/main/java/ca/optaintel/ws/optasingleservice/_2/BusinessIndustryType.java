
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusinessIndustryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessIndustryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndustryCategoryTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SICCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SICCodeType" minOccurs="0"/>
 *         &lt;element name="SICCodeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBCCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}IBCCodeType" minOccurs="0"/>
 *         &lt;element name="IBCCodeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAICSCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}NAICSCodeType" minOccurs="0"/>
 *         &lt;element name="NAICSCodeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OptaOccupancyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessIndustryType", propOrder = {
    "industryCategoryTypeCode",
    "sicCode",
    "sicCodeDescription",
    "ibcCode",
    "ibcCodeDescription",
    "naicsCode",
    "naicsCodeDescription",
    "optaOccupancyType"
})
public class BusinessIndustryType {

    @XmlElement(name = "IndustryCategoryTypeCode")
    protected String industryCategoryTypeCode;
    @XmlElement(name = "SICCode")
    protected String sicCode;
    @XmlElement(name = "SICCodeDescription")
    protected String sicCodeDescription;
    @XmlElement(name = "IBCCode")
    protected String ibcCode;
    @XmlElement(name = "IBCCodeDescription")
    protected String ibcCodeDescription;
    @XmlElement(name = "NAICSCode")
    protected String naicsCode;
    @XmlElement(name = "NAICSCodeDescription")
    protected String naicsCodeDescription;
    @XmlElement(name = "OptaOccupancyType")
    protected String optaOccupancyType;

    /**
     * Gets the value of the industryCategoryTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndustryCategoryTypeCode() {
        return industryCategoryTypeCode;
    }

    /**
     * Sets the value of the industryCategoryTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndustryCategoryTypeCode(String value) {
        this.industryCategoryTypeCode = value;
    }

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
     * Gets the value of the sicCodeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSICCodeDescription() {
        return sicCodeDescription;
    }

    /**
     * Sets the value of the sicCodeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSICCodeDescription(String value) {
        this.sicCodeDescription = value;
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
     * Gets the value of the ibcCodeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBCCodeDescription() {
        return ibcCodeDescription;
    }

    /**
     * Sets the value of the ibcCodeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBCCodeDescription(String value) {
        this.ibcCodeDescription = value;
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

    /**
     * Gets the value of the naicsCodeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAICSCodeDescription() {
        return naicsCodeDescription;
    }

    /**
     * Sets the value of the naicsCodeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAICSCodeDescription(String value) {
        this.naicsCodeDescription = value;
    }

    /**
     * Gets the value of the optaOccupancyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptaOccupancyType() {
        return optaOccupancyType;
    }

    /**
     * Sets the value of the optaOccupancyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptaOccupancyType(String value) {
        this.optaOccupancyType = value;
    }

}
