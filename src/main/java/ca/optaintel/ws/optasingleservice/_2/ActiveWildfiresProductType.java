
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActiveWildfiresProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActiveWildfiresProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="ActiveFires" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActiveFiresType" minOccurs="0"/>
 *         &lt;element name="FireHotspots" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FireHotspotsType" minOccurs="0"/>
 *         &lt;element name="FirePerimeters" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FirePerimetersType" minOccurs="0"/>
 *         &lt;element name="FireDanger" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FireDangerType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActiveWildfiresProductType", propOrder = {
    "activeFires",
    "fireHotspots",
    "firePerimeters",
    "fireDanger"
})
public class ActiveWildfiresProductType
    extends BaseProductType
{

    @XmlElement(name = "ActiveFires")
    protected ActiveFiresType activeFires;
    @XmlElement(name = "FireHotspots")
    protected FireHotspotsType fireHotspots;
    @XmlElement(name = "FirePerimeters")
    protected FirePerimetersType firePerimeters;
    @XmlElement(name = "FireDanger")
    protected FireDangerType fireDanger;

    /**
     * Gets the value of the activeFires property.
     * 
     * @return
     *     possible object is
     *     {@link ActiveFiresType }
     *     
     */
    public ActiveFiresType getActiveFires() {
        return activeFires;
    }

    /**
     * Sets the value of the activeFires property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveFiresType }
     *     
     */
    public void setActiveFires(ActiveFiresType value) {
        this.activeFires = value;
    }

    /**
     * Gets the value of the fireHotspots property.
     * 
     * @return
     *     possible object is
     *     {@link FireHotspotsType }
     *     
     */
    public FireHotspotsType getFireHotspots() {
        return fireHotspots;
    }

    /**
     * Sets the value of the fireHotspots property.
     * 
     * @param value
     *     allowed object is
     *     {@link FireHotspotsType }
     *     
     */
    public void setFireHotspots(FireHotspotsType value) {
        this.fireHotspots = value;
    }

    /**
     * Gets the value of the firePerimeters property.
     * 
     * @return
     *     possible object is
     *     {@link FirePerimetersType }
     *     
     */
    public FirePerimetersType getFirePerimeters() {
        return firePerimeters;
    }

    /**
     * Sets the value of the firePerimeters property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirePerimetersType }
     *     
     */
    public void setFirePerimeters(FirePerimetersType value) {
        this.firePerimeters = value;
    }

    /**
     * Gets the value of the fireDanger property.
     * 
     * @return
     *     possible object is
     *     {@link FireDangerType }
     *     
     */
    public FireDangerType getFireDanger() {
        return fireDanger;
    }

    /**
     * Sets the value of the fireDanger property.
     * 
     * @param value
     *     allowed object is
     *     {@link FireDangerType }
     *     
     */
    public void setFireDanger(FireDangerType value) {
        this.fireDanger = value;
    }

}
