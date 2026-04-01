
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlumbingTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlumbingTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PlumbingType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlumbingTypes", propOrder = {
    "plumbingType"
})
public class PlumbingTypes {

    @XmlElement(name = "PlumbingType")
    protected String plumbingType;

    /**
     * Gets the value of the plumbingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlumbingType() {
        return plumbingType;
    }

    /**
     * Sets the value of the plumbingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlumbingType(String value) {
        this.plumbingType = value;
    }

}
