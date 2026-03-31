
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultiResidentialConstructionFeaturesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultiResidentialConstructionFeaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FloorLevel" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ConstructionType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ConstructionType"/>
 *         &lt;element name="BasementPresent" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BooleanWithUnknownType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiResidentialConstructionFeaturesType", propOrder = {
    "floorLevel",
    "constructionType",
    "basementPresent"
})
public class MultiResidentialConstructionFeaturesType {

    @XmlElement(name = "FloorLevel", required = true)
    protected BigInteger floorLevel;
    @XmlElement(name = "ConstructionType", required = true)
    @XmlSchemaType(name = "string")
    protected ConstructionType constructionType;
    @XmlElement(name = "BasementPresent", required = true)
    @XmlSchemaType(name = "string")
    protected BooleanWithUnknownType basementPresent;

    /**
     * Gets the value of the floorLevel property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloorLevel() {
        return floorLevel;
    }

    /**
     * Sets the value of the floorLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloorLevel(BigInteger value) {
        this.floorLevel = value;
    }

    /**
     * Gets the value of the constructionType property.
     * 
     * @return
     *     possible object is
     *     {@link ConstructionType }
     *     
     */
    public ConstructionType getConstructionType() {
        return constructionType;
    }

    /**
     * Sets the value of the constructionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstructionType }
     *     
     */
    public void setConstructionType(ConstructionType value) {
        this.constructionType = value;
    }

    /**
     * Gets the value of the basementPresent property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public BooleanWithUnknownType getBasementPresent() {
        return basementPresent;
    }

    /**
     * Sets the value of the basementPresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanWithUnknownType }
     *     
     */
    public void setBasementPresent(BooleanWithUnknownType value) {
        this.basementPresent = value;
    }

}
