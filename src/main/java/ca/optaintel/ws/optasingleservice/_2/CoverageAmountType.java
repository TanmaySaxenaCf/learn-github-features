
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CoverageAmountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoverageAmountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Building" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DetachedPrivateStructures" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Contents" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="AdditionalLivingExpenses" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoverageAmountType", propOrder = {
    "building",
    "detachedPrivateStructures",
    "contents",
    "additionalLivingExpenses"
})
public class CoverageAmountType {

    @XmlElement(name = "Building")
    protected Double building;
    @XmlElement(name = "DetachedPrivateStructures")
    protected Double detachedPrivateStructures;
    @XmlElement(name = "Contents")
    protected Double contents;
    @XmlElement(name = "AdditionalLivingExpenses")
    protected Double additionalLivingExpenses;

    /**
     * Gets the value of the building property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBuilding() {
        return building;
    }

    /**
     * Sets the value of the building property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBuilding(Double value) {
        this.building = value;
    }

    /**
     * Gets the value of the detachedPrivateStructures property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDetachedPrivateStructures() {
        return detachedPrivateStructures;
    }

    /**
     * Sets the value of the detachedPrivateStructures property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDetachedPrivateStructures(Double value) {
        this.detachedPrivateStructures = value;
    }

    /**
     * Gets the value of the contents property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getContents() {
        return contents;
    }

    /**
     * Sets the value of the contents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setContents(Double value) {
        this.contents = value;
    }

    /**
     * Gets the value of the additionalLivingExpenses property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAdditionalLivingExpenses() {
        return additionalLivingExpenses;
    }

    /**
     * Sets the value of the additionalLivingExpenses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAdditionalLivingExpenses(Double value) {
        this.additionalLivingExpenses = value;
    }

}
