
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialOccupant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialOccupant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrimaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ActiveIndicatorCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActiveIndicatorType"/>
 *         &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Industry" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BusinessIndustryType" minOccurs="0"/>
 *         &lt;element name="CompanyFirmographics" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialOccupancyFirmographicsType" minOccurs="0"/>
 *         &lt;element name="ParentCompanyFirmographics" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialOccupancyFirmographicsType" minOccurs="0"/>
 *         &lt;element name="Credit" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialOccupancyCreditType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialOccupant", propOrder = {
    "primaryName",
    "activeIndicatorCode",
    "websiteURL",
    "industry",
    "companyFirmographics",
    "parentCompanyFirmographics",
    "credit"
})
public class CommercialOccupant {

    @XmlElement(name = "PrimaryName", required = true)
    protected String primaryName;
    @XmlElement(name = "ActiveIndicatorCode", required = true)
    @XmlSchemaType(name = "string")
    protected ActiveIndicatorType activeIndicatorCode;
    @XmlElement(name = "WebsiteURL")
    protected String websiteURL;
    @XmlElement(name = "Industry")
    protected BusinessIndustryType industry;
    @XmlElement(name = "CompanyFirmographics")
    protected CommercialOccupancyFirmographicsType companyFirmographics;
    @XmlElement(name = "ParentCompanyFirmographics")
    protected CommercialOccupancyFirmographicsType parentCompanyFirmographics;
    @XmlElement(name = "Credit")
    protected CommercialOccupancyCreditType credit;

    /**
     * Gets the value of the primaryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryName() {
        return primaryName;
    }

    /**
     * Sets the value of the primaryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryName(String value) {
        this.primaryName = value;
    }

    /**
     * Gets the value of the activeIndicatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveIndicatorType }
     *     
     */
    public ActiveIndicatorType getActiveIndicatorCode() {
        return activeIndicatorCode;
    }

    /**
     * Sets the value of the activeIndicatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveIndicatorType }
     *     
     */
    public void setActiveIndicatorCode(ActiveIndicatorType value) {
        this.activeIndicatorCode = value;
    }

    /**
     * Gets the value of the websiteURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebsiteURL() {
        return websiteURL;
    }

    /**
     * Sets the value of the websiteURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebsiteURL(String value) {
        this.websiteURL = value;
    }

    /**
     * Gets the value of the industry property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessIndustryType }
     *     
     */
    public BusinessIndustryType getIndustry() {
        return industry;
    }

    /**
     * Sets the value of the industry property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessIndustryType }
     *     
     */
    public void setIndustry(BusinessIndustryType value) {
        this.industry = value;
    }

    /**
     * Gets the value of the companyFirmographics property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialOccupancyFirmographicsType }
     *     
     */
    public CommercialOccupancyFirmographicsType getCompanyFirmographics() {
        return companyFirmographics;
    }

    /**
     * Sets the value of the companyFirmographics property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialOccupancyFirmographicsType }
     *     
     */
    public void setCompanyFirmographics(CommercialOccupancyFirmographicsType value) {
        this.companyFirmographics = value;
    }

    /**
     * Gets the value of the parentCompanyFirmographics property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialOccupancyFirmographicsType }
     *     
     */
    public CommercialOccupancyFirmographicsType getParentCompanyFirmographics() {
        return parentCompanyFirmographics;
    }

    /**
     * Sets the value of the parentCompanyFirmographics property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialOccupancyFirmographicsType }
     *     
     */
    public void setParentCompanyFirmographics(CommercialOccupancyFirmographicsType value) {
        this.parentCompanyFirmographics = value;
    }

    /**
     * Gets the value of the credit property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialOccupancyCreditType }
     *     
     */
    public CommercialOccupancyCreditType getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialOccupancyCreditType }
     *     
     */
    public void setCredit(CommercialOccupancyCreditType value) {
        this.credit = value;
    }

}
