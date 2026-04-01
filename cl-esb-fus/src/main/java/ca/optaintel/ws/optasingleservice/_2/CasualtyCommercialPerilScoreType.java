
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CasualtyCommercialPerilScoreType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CasualtyCommercialPerilScoreType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialPerilScoreType">
 *       &lt;sequence>
 *         &lt;element name="PerilType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CasualtyCommercialPerilType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CasualtyCommercialPerilScoreType", propOrder = {
    "perilType"
})
public class CasualtyCommercialPerilScoreType
    extends CommercialPerilScoreType
{

    @XmlElement(name = "PerilType", required = true)
    @XmlSchemaType(name = "string")
    protected CasualtyCommercialPerilType perilType;

    /**
     * Gets the value of the perilType property.
     * 
     * @return
     *     possible object is
     *     {@link CasualtyCommercialPerilType }
     *     
     */
    public CasualtyCommercialPerilType getPerilType() {
        return perilType;
    }

    /**
     * Sets the value of the perilType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CasualtyCommercialPerilType }
     *     
     */
    public void setPerilType(CasualtyCommercialPerilType value) {
        this.perilType = value;
    }

}
