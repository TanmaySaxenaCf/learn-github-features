
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestBusinessType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestBusinessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndustryCodes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestedIndustryCodeType"/>
 *         &lt;element name="OptaPlaceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TotalRevenue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="EmployeeCount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestBusinessType", propOrder = {
    "name",
    "industryCodes",
    "optaPlaceID",
    "totalRevenue",
    "employeeCount"
})
public class RequestBusinessType {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "IndustryCodes", required = true)
    protected RequestedIndustryCodeType industryCodes;
    @XmlElement(name = "OptaPlaceID", required = true)
    protected String optaPlaceID;
    @XmlElement(name = "TotalRevenue")
    protected Double totalRevenue;
    @XmlElement(name = "EmployeeCount")
    protected Double employeeCount;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the industryCodes property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedIndustryCodeType }
     *     
     */
    public RequestedIndustryCodeType getIndustryCodes() {
        return industryCodes;
    }

    /**
     * Sets the value of the industryCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedIndustryCodeType }
     *     
     */
    public void setIndustryCodes(RequestedIndustryCodeType value) {
        this.industryCodes = value;
    }

    /**
     * Gets the value of the optaPlaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptaPlaceID() {
        return optaPlaceID;
    }

    /**
     * Sets the value of the optaPlaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptaPlaceID(String value) {
        this.optaPlaceID = value;
    }

    /**
     * Gets the value of the totalRevenue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * Sets the value of the totalRevenue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalRevenue(Double value) {
        this.totalRevenue = value;
    }

    /**
     * Gets the value of the employeeCount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getEmployeeCount() {
        return employeeCount;
    }

    /**
     * Sets the value of the employeeCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setEmployeeCount(Double value) {
        this.employeeCount = value;
    }

}
