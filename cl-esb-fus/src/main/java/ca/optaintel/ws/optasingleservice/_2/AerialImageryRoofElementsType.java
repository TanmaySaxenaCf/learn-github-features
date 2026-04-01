
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryRoofElementsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryRoofElementsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACUnit" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Chimney" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="RoofVent" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="SatelliteDish" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Skylight" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryRoofElementsType", propOrder = {
    "acUnit",
    "chimney",
    "roofVent",
    "satelliteDish",
    "skylight"
})
public class AerialImageryRoofElementsType {

    @XmlElement(name = "ACUnit")
    protected BigInteger acUnit;
    @XmlElement(name = "Chimney")
    protected BigInteger chimney;
    @XmlElement(name = "RoofVent")
    protected BigInteger roofVent;
    @XmlElement(name = "SatelliteDish")
    protected BigInteger satelliteDish;
    @XmlElement(name = "Skylight")
    protected BigInteger skylight;

    /**
     * Gets the value of the acUnit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getACUnit() {
        return acUnit;
    }

    /**
     * Sets the value of the acUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setACUnit(BigInteger value) {
        this.acUnit = value;
    }

    /**
     * Gets the value of the chimney property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getChimney() {
        return chimney;
    }

    /**
     * Sets the value of the chimney property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setChimney(BigInteger value) {
        this.chimney = value;
    }

    /**
     * Gets the value of the roofVent property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRoofVent() {
        return roofVent;
    }

    /**
     * Sets the value of the roofVent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRoofVent(BigInteger value) {
        this.roofVent = value;
    }

    /**
     * Gets the value of the satelliteDish property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSatelliteDish() {
        return satelliteDish;
    }

    /**
     * Sets the value of the satelliteDish property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSatelliteDish(BigInteger value) {
        this.satelliteDish = value;
    }

    /**
     * Gets the value of the skylight property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSkylight() {
        return skylight;
    }

    /**
     * Sets the value of the skylight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSkylight(BigInteger value) {
        this.skylight = value;
    }

}
