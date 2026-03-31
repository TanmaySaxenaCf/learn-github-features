
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseComparablesCondoBuildingFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseComparablesCondoBuildingFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="YearBuilt" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="MultiResidentialStyleType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MultiResidentialStyleType" minOccurs="0"/>
 *         &lt;element name="NumberOfStoreys" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="GarageType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialParkingTypeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseComparablesCondoBuildingFeaturesType", propOrder = {
    "yearBuilt",
    "multiResidentialStyleType",
    "numberOfStoreys",
    "garageType"
})
public class ResponseComparablesCondoBuildingFeaturesType {

    @XmlElement(name = "YearBuilt")
    protected BigInteger yearBuilt;
    @XmlElement(name = "MultiResidentialStyleType")
    @XmlSchemaType(name = "string")
    protected MultiResidentialStyleType multiResidentialStyleType;
    @XmlElement(name = "NumberOfStoreys")
    protected BigInteger numberOfStoreys;
    @XmlElement(name = "GarageType")
    @XmlSchemaType(name = "string")
    protected CommercialParkingTypeType garageType;

    /**
     * Gets the value of the yearBuilt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearBuilt() {
        return yearBuilt;
    }

    /**
     * Sets the value of the yearBuilt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearBuilt(BigInteger value) {
        this.yearBuilt = value;
    }

    /**
     * Gets the value of the multiResidentialStyleType property.
     * 
     * @return
     *     possible object is
     *     {@link MultiResidentialStyleType }
     *     
     */
    public MultiResidentialStyleType getMultiResidentialStyleType() {
        return multiResidentialStyleType;
    }

    /**
     * Sets the value of the multiResidentialStyleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiResidentialStyleType }
     *     
     */
    public void setMultiResidentialStyleType(MultiResidentialStyleType value) {
        this.multiResidentialStyleType = value;
    }

    /**
     * Gets the value of the numberOfStoreys property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfStoreys() {
        return numberOfStoreys;
    }

    /**
     * Sets the value of the numberOfStoreys property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfStoreys(BigInteger value) {
        this.numberOfStoreys = value;
    }

    /**
     * Gets the value of the garageType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialParkingTypeType }
     *     
     */
    public CommercialParkingTypeType getGarageType() {
        return garageType;
    }

    /**
     * Sets the value of the garageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialParkingTypeType }
     *     
     */
    public void setGarageType(CommercialParkingTypeType value) {
        this.garageType = value;
    }

}
