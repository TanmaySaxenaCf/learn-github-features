
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FusMapType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FusMapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Business" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BusinessType"/>
 *         &lt;element name="FusContent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ContentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FusMapType", propOrder = {
    "business",
    "fusContent"
})
public class FusMapType {

    @XmlElement(name = "Business", required = true)
    @XmlSchemaType(name = "string")
    protected BusinessType business;
    @XmlElement(name = "FusContent")
    protected ContentType fusContent;

    /**
     * Gets the value of the business property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessType }
     *     
     */
    public BusinessType getBusiness() {
        return business;
    }

    /**
     * Sets the value of the business property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessType }
     *     
     */
    public void setBusiness(BusinessType value) {
        this.business = value;
    }

    /**
     * Gets the value of the fusContent property.
     * 
     * @return
     *     possible object is
     *     {@link ContentType }
     *     
     */
    public ContentType getFusContent() {
        return fusContent;
    }

    /**
     * Sets the value of the fusContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentType }
     *     
     */
    public void setFusContent(ContentType value) {
        this.fusContent = value;
    }

}
