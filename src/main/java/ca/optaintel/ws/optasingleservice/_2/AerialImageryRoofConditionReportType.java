
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryRoofConditionReportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryRoofConditionReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Debris" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportItemType" minOccurs="0"/>
 *         &lt;element name="MissingMaterial" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportItemType" minOccurs="0"/>
 *         &lt;element name="Patch" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportItemType" minOccurs="0"/>
 *         &lt;element name="Tarp" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportItemType" minOccurs="0"/>
 *         &lt;element name="Discoloration" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryDiscolorationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryRoofConditionReportType", propOrder = {
    "debris",
    "missingMaterial",
    "patch",
    "tarp",
    "discoloration"
})
public class AerialImageryRoofConditionReportType {

    @XmlElement(name = "Debris")
    protected AerialImageryRoofConditionReportItemType debris;
    @XmlElement(name = "MissingMaterial")
    protected AerialImageryRoofConditionReportItemType missingMaterial;
    @XmlElement(name = "Patch")
    protected AerialImageryRoofConditionReportItemType patch;
    @XmlElement(name = "Tarp")
    protected AerialImageryRoofConditionReportItemType tarp;
    @XmlElement(name = "Discoloration")
    protected AerialImageryDiscolorationType discoloration;

    /**
     * Gets the value of the debris property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public AerialImageryRoofConditionReportItemType getDebris() {
        return debris;
    }

    /**
     * Sets the value of the debris property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public void setDebris(AerialImageryRoofConditionReportItemType value) {
        this.debris = value;
    }

    /**
     * Gets the value of the missingMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public AerialImageryRoofConditionReportItemType getMissingMaterial() {
        return missingMaterial;
    }

    /**
     * Sets the value of the missingMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public void setMissingMaterial(AerialImageryRoofConditionReportItemType value) {
        this.missingMaterial = value;
    }

    /**
     * Gets the value of the patch property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public AerialImageryRoofConditionReportItemType getPatch() {
        return patch;
    }

    /**
     * Sets the value of the patch property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public void setPatch(AerialImageryRoofConditionReportItemType value) {
        this.patch = value;
    }

    /**
     * Gets the value of the tarp property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public AerialImageryRoofConditionReportItemType getTarp() {
        return tarp;
    }

    /**
     * Sets the value of the tarp property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public void setTarp(AerialImageryRoofConditionReportItemType value) {
        this.tarp = value;
    }

    /**
     * Gets the value of the discoloration property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryDiscolorationType }
     *     
     */
    public AerialImageryDiscolorationType getDiscoloration() {
        return discoloration;
    }

    /**
     * Sets the value of the discoloration property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryDiscolorationType }
     *     
     */
    public void setDiscoloration(AerialImageryDiscolorationType value) {
        this.discoloration = value;
    }

}
