
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BasementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BasementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasementPresent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BasementAreaMetric" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="BasementAreaImperial" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasementType", propOrder = {
    "basementPresent",
    "basementAreaMetric",
    "basementAreaImperial"
})
public class BasementType {

    @XmlElement(name = "BasementPresent")
    protected String basementPresent;
    @XmlElement(name = "BasementAreaMetric")
    protected Float basementAreaMetric;
    @XmlElement(name = "BasementAreaImperial")
    protected Float basementAreaImperial;

    /**
     * Gets the value of the basementPresent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasementPresent() {
        return basementPresent;
    }

    /**
     * Sets the value of the basementPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasementPresent(String value) {
        this.basementPresent = value;
    }

    /**
     * Gets the value of the basementAreaMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBasementAreaMetric() {
        return basementAreaMetric;
    }

    /**
     * Sets the value of the basementAreaMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBasementAreaMetric(Float value) {
        this.basementAreaMetric = value;
    }

    /**
     * Gets the value of the basementAreaImperial property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBasementAreaImperial() {
        return basementAreaImperial;
    }

    /**
     * Sets the value of the basementAreaImperial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBasementAreaImperial(Float value) {
        this.basementAreaImperial = value;
    }

}
