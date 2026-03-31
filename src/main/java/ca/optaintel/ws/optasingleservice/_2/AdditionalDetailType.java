
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdditionalDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdditionalDetailType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetailType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DetailValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalDetailType", propOrder = {
    "detailType",
    "detailValue"
})
public class AdditionalDetailType {

    @XmlElement(name = "DetailType")
    protected String detailType;
    @XmlElement(name = "DetailValue")
    protected String detailValue;

    /**
     * Gets the value of the detailType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailType() {
        return detailType;
    }

    /**
     * Sets the value of the detailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailType(String value) {
        this.detailType = value;
    }

    /**
     * Gets the value of the detailValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailValue() {
        return detailValue;
    }

    /**
     * Sets the value of the detailValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailValue(String value) {
        this.detailValue = value;
    }

}
