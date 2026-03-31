
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyConstructionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyConstructionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConstructionClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CombustibilityClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoofDetails" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RoofDetailsType" minOccurs="0"/>
 *         &lt;element name="ExteriorWalls" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ExteriorWallsType" minOccurs="0"/>
 *         &lt;element name="HeatingTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}HeatingTypes" minOccurs="0"/>
 *         &lt;element name="PlumbingTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PlumbingTypes" minOccurs="0"/>
 *         &lt;element name="ElectricalTypes" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ElectricalTypes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyConstructionType", propOrder = {
    "constructionClass",
    "combustibilityClass",
    "roofDetails",
    "exteriorWalls",
    "heatingTypes",
    "plumbingTypes",
    "electricalTypes"
})
public class PropertyConstructionType {

    @XmlElement(name = "ConstructionClass")
    protected String constructionClass;
    @XmlElement(name = "CombustibilityClass")
    protected String combustibilityClass;
    @XmlElement(name = "RoofDetails")
    protected RoofDetailsType roofDetails;
    @XmlElement(name = "ExteriorWalls")
    protected ExteriorWallsType exteriorWalls;
    @XmlElement(name = "HeatingTypes")
    protected HeatingTypes heatingTypes;
    @XmlElement(name = "PlumbingTypes")
    protected PlumbingTypes plumbingTypes;
    @XmlElement(name = "ElectricalTypes")
    protected ElectricalTypes electricalTypes;

    /**
     * Gets the value of the constructionClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstructionClass() {
        return constructionClass;
    }

    /**
     * Sets the value of the constructionClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstructionClass(String value) {
        this.constructionClass = value;
    }

    /**
     * Gets the value of the combustibilityClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCombustibilityClass() {
        return combustibilityClass;
    }

    /**
     * Sets the value of the combustibilityClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCombustibilityClass(String value) {
        this.combustibilityClass = value;
    }

    /**
     * Gets the value of the roofDetails property.
     * 
     * @return
     *     possible object is
     *     {@link RoofDetailsType }
     *     
     */
    public RoofDetailsType getRoofDetails() {
        return roofDetails;
    }

    /**
     * Sets the value of the roofDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoofDetailsType }
     *     
     */
    public void setRoofDetails(RoofDetailsType value) {
        this.roofDetails = value;
    }

    /**
     * Gets the value of the exteriorWalls property.
     * 
     * @return
     *     possible object is
     *     {@link ExteriorWallsType }
     *     
     */
    public ExteriorWallsType getExteriorWalls() {
        return exteriorWalls;
    }

    /**
     * Sets the value of the exteriorWalls property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExteriorWallsType }
     *     
     */
    public void setExteriorWalls(ExteriorWallsType value) {
        this.exteriorWalls = value;
    }

    /**
     * Gets the value of the heatingTypes property.
     * 
     * @return
     *     possible object is
     *     {@link HeatingTypes }
     *     
     */
    public HeatingTypes getHeatingTypes() {
        return heatingTypes;
    }

    /**
     * Sets the value of the heatingTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeatingTypes }
     *     
     */
    public void setHeatingTypes(HeatingTypes value) {
        this.heatingTypes = value;
    }

    /**
     * Gets the value of the plumbingTypes property.
     * 
     * @return
     *     possible object is
     *     {@link PlumbingTypes }
     *     
     */
    public PlumbingTypes getPlumbingTypes() {
        return plumbingTypes;
    }

    /**
     * Sets the value of the plumbingTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlumbingTypes }
     *     
     */
    public void setPlumbingTypes(PlumbingTypes value) {
        this.plumbingTypes = value;
    }

    /**
     * Gets the value of the electricalTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ElectricalTypes }
     *     
     */
    public ElectricalTypes getElectricalTypes() {
        return electricalTypes;
    }

    /**
     * Sets the value of the electricalTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectricalTypes }
     *     
     */
    public void setElectricalTypes(ElectricalTypes value) {
        this.electricalTypes = value;
    }

}
