
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ElectricalTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElectricalTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ElectricalWiring" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ElectricalCovering" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ElectricalPanel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectricalTypes", propOrder = {
    "electricalWiring",
    "electricalCovering",
    "electricalPanel"
})
public class ElectricalTypes {

    @XmlElement(name = "ElectricalWiring")
    protected String electricalWiring;
    @XmlElement(name = "ElectricalCovering")
    protected String electricalCovering;
    @XmlElement(name = "ElectricalPanel")
    protected String electricalPanel;

    /**
     * Gets the value of the electricalWiring property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElectricalWiring() {
        return electricalWiring;
    }

    /**
     * Sets the value of the electricalWiring property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElectricalWiring(String value) {
        this.electricalWiring = value;
    }

    /**
     * Gets the value of the electricalCovering property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElectricalCovering() {
        return electricalCovering;
    }

    /**
     * Sets the value of the electricalCovering property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElectricalCovering(String value) {
        this.electricalCovering = value;
    }

    /**
     * Gets the value of the electricalPanel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElectricalPanel() {
        return electricalPanel;
    }

    /**
     * Sets the value of the electricalPanel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElectricalPanel(String value) {
        this.electricalPanel = value;
    }

}
