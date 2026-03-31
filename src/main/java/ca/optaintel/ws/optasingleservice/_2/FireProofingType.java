
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FireProofingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FireProofingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cemetitious" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SprayedFibre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FireProofingType", propOrder = {
    "cemetitious",
    "sprayedFibre"
})
public class FireProofingType {

    @XmlElement(name = "Cemetitious")
    protected String cemetitious;
    @XmlElement(name = "SprayedFibre")
    protected String sprayedFibre;

    /**
     * Gets the value of the cemetitious property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCemetitious() {
        return cemetitious;
    }

    /**
     * Sets the value of the cemetitious property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCemetitious(String value) {
        this.cemetitious = value;
    }

    /**
     * Gets the value of the sprayedFibre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSprayedFibre() {
        return sprayedFibre;
    }

    /**
     * Sets the value of the sprayedFibre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSprayedFibre(String value) {
        this.sprayedFibre = value;
    }

}
