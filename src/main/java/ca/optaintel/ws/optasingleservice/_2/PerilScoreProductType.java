
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerilScoreProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerilScoreProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Perils" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PerilScorePerilsType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerilScoreProductType", propOrder = {
    "perils"
})
public class PerilScoreProductType
    extends BaseProductType
{

    @XmlElement(name = "Perils", required = true)
    protected PerilScorePerilsType perils;

    /**
     * Gets the value of the perils property.
     * 
     * @return
     *     possible object is
     *     {@link PerilScorePerilsType }
     *     
     */
    public PerilScorePerilsType getPerils() {
        return perils;
    }

    /**
     * Sets the value of the perils property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerilScorePerilsType }
     *     
     */
    public void setPerils(PerilScorePerilsType value) {
        this.perils = value;
    }

}
