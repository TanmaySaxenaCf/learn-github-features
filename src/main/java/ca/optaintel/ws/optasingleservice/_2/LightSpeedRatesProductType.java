
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LightSpeedRatesProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LightSpeedRatesProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Coverages" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialCoveragesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LightSpeedRatesProductType", propOrder = {
    "coverages"
})
public class LightSpeedRatesProductType
    extends BaseProductType
{

    @XmlElement(name = "Coverages")
    protected CommercialCoveragesType coverages;

    /**
     * Gets the value of the coverages property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialCoveragesType }
     *     
     */
    public CommercialCoveragesType getCoverages() {
        return coverages;
    }

    /**
     * Sets the value of the coverages property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialCoveragesType }
     *     
     */
    public void setCoverages(CommercialCoveragesType value) {
        this.coverages = value;
    }

}
