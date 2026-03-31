
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryDiscolorationTypesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryDiscolorationTypesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlgaeStaining" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportItemType" minOccurs="0"/>
 *         &lt;element name="VentStaining" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportItemType" minOccurs="0"/>
 *         &lt;element name="WaterPooling" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportItemType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryDiscolorationTypesType", propOrder = {
    "algaeStaining",
    "ventStaining",
    "waterPooling"
})
public class AerialImageryDiscolorationTypesType {

    @XmlElement(name = "AlgaeStaining")
    protected AerialImageryRoofConditionReportItemType algaeStaining;
    @XmlElement(name = "VentStaining")
    protected AerialImageryRoofConditionReportItemType ventStaining;
    @XmlElement(name = "WaterPooling")
    protected AerialImageryRoofConditionReportItemType waterPooling;

    /**
     * Gets the value of the algaeStaining property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public AerialImageryRoofConditionReportItemType getAlgaeStaining() {
        return algaeStaining;
    }

    /**
     * Sets the value of the algaeStaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public void setAlgaeStaining(AerialImageryRoofConditionReportItemType value) {
        this.algaeStaining = value;
    }

    /**
     * Gets the value of the ventStaining property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public AerialImageryRoofConditionReportItemType getVentStaining() {
        return ventStaining;
    }

    /**
     * Sets the value of the ventStaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public void setVentStaining(AerialImageryRoofConditionReportItemType value) {
        this.ventStaining = value;
    }

    /**
     * Gets the value of the waterPooling property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public AerialImageryRoofConditionReportItemType getWaterPooling() {
        return waterPooling;
    }

    /**
     * Sets the value of the waterPooling property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofConditionReportItemType }
     *     
     */
    public void setWaterPooling(AerialImageryRoofConditionReportItemType value) {
        this.waterPooling = value;
    }

}
