
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarketValueComparablesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MarketValueComparablesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseAddressType"/>
 *         &lt;choice>
 *           &lt;element name="ResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseComparablesResidentialConstructionFeaturesType"/>
 *           &lt;element name="MultiResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseComparablesCondoConstructionFeaturesType"/>
 *         &lt;/choice>
 *         &lt;element name="Image" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseImageType" minOccurs="0"/>
 *         &lt;element name="PropertyValues" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyValuesType" minOccurs="0"/>
 *         &lt;element name="DistanceFromSubjectProperty" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="LotFrontage" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="LotDepth" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MarketValueComparablesType", propOrder = {
    "address",
    "residentialBuilding",
    "multiResidentialBuilding",
    "image",
    "propertyValues",
    "distanceFromSubjectProperty",
    "lotFrontage",
    "lotDepth"
})
public class MarketValueComparablesType {

    @XmlElement(name = "Address", required = true)
    protected ResponseAddressType address;
    @XmlElement(name = "ResidentialBuilding")
    protected ResponseComparablesResidentialConstructionFeaturesType residentialBuilding;
    @XmlElement(name = "MultiResidentialBuilding")
    protected ResponseComparablesCondoConstructionFeaturesType multiResidentialBuilding;
    @XmlElement(name = "Image")
    protected BaseImageType image;
    @XmlElement(name = "PropertyValues")
    protected PropertyValuesType propertyValues;
    @XmlElement(name = "DistanceFromSubjectProperty")
    protected Float distanceFromSubjectProperty;
    @XmlElement(name = "LotFrontage")
    protected Float lotFrontage;
    @XmlElement(name = "LotDepth")
    protected Float lotDepth;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseAddressType }
     *     
     */
    public ResponseAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseAddressType }
     *     
     */
    public void setAddress(ResponseAddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the residentialBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseComparablesResidentialConstructionFeaturesType }
     *     
     */
    public ResponseComparablesResidentialConstructionFeaturesType getResidentialBuilding() {
        return residentialBuilding;
    }

    /**
     * Sets the value of the residentialBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseComparablesResidentialConstructionFeaturesType }
     *     
     */
    public void setResidentialBuilding(ResponseComparablesResidentialConstructionFeaturesType value) {
        this.residentialBuilding = value;
    }

    /**
     * Gets the value of the multiResidentialBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseComparablesCondoConstructionFeaturesType }
     *     
     */
    public ResponseComparablesCondoConstructionFeaturesType getMultiResidentialBuilding() {
        return multiResidentialBuilding;
    }

    /**
     * Sets the value of the multiResidentialBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseComparablesCondoConstructionFeaturesType }
     *     
     */
    public void setMultiResidentialBuilding(ResponseComparablesCondoConstructionFeaturesType value) {
        this.multiResidentialBuilding = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link BaseImageType }
     *     
     */
    public BaseImageType getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseImageType }
     *     
     */
    public void setImage(BaseImageType value) {
        this.image = value;
    }

    /**
     * Gets the value of the propertyValues property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyValuesType }
     *     
     */
    public PropertyValuesType getPropertyValues() {
        return propertyValues;
    }

    /**
     * Sets the value of the propertyValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyValuesType }
     *     
     */
    public void setPropertyValues(PropertyValuesType value) {
        this.propertyValues = value;
    }

    /**
     * Gets the value of the distanceFromSubjectProperty property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDistanceFromSubjectProperty() {
        return distanceFromSubjectProperty;
    }

    /**
     * Sets the value of the distanceFromSubjectProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDistanceFromSubjectProperty(Float value) {
        this.distanceFromSubjectProperty = value;
    }

    /**
     * Gets the value of the lotFrontage property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLotFrontage() {
        return lotFrontage;
    }

    /**
     * Sets the value of the lotFrontage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLotFrontage(Float value) {
        this.lotFrontage = value;
    }

    /**
     * Gets the value of the lotDepth property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLotDepth() {
        return lotDepth;
    }

    /**
     * Sets the value of the lotDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLotDepth(Float value) {
        this.lotDepth = value;
    }

}
