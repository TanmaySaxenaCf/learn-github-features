
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActualCashValuePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualCashValuePropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Buildings" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActualCashValueBuildingsType" minOccurs="0"/>
 *         &lt;element name="Valuation" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActualCashValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualCashValuePropertyType", propOrder = {
    "buildings",
    "valuation"
})
public class ActualCashValuePropertyType {

    @XmlElement(name = "Buildings")
    protected ActualCashValueBuildingsType buildings;
    @XmlElement(name = "Valuation")
    protected ActualCashValueType valuation;

    /**
     * Gets the value of the buildings property.
     * 
     * @return
     *     possible object is
     *     {@link ActualCashValueBuildingsType }
     *     
     */
    public ActualCashValueBuildingsType getBuildings() {
        return buildings;
    }

    /**
     * Sets the value of the buildings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualCashValueBuildingsType }
     *     
     */
    public void setBuildings(ActualCashValueBuildingsType value) {
        this.buildings = value;
    }

    /**
     * Gets the value of the valuation property.
     * 
     * @return
     *     possible object is
     *     {@link ActualCashValueType }
     *     
     */
    public ActualCashValueType getValuation() {
        return valuation;
    }

    /**
     * Sets the value of the valuation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualCashValueType }
     *     
     */
    public void setValuation(ActualCashValueType value) {
        this.valuation = value;
    }

}
