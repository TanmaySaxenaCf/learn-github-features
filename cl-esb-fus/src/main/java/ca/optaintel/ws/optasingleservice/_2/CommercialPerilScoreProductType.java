
package ca.optaintel.ws.optasingleservice._2;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialPerilScoreProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialPerilScoreProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="AllPerilsScore" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialPerilScoreType"/>
 *         &lt;element name="PropertyPerilScores" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyCommercialPerilsType"/>
 *         &lt;element name="CasualtyPerilScores" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CasualtyCommercialPerilsType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialPerilScoreProductType", propOrder = {
    "allPerilsScore",
    "propertyPerilScores",
    "casualtyPerilScores"
})
public class CommercialPerilScoreProductType
    extends BaseProductType implements Serializable{
        
    	private static final long serialVersionUID = 1L;

    @XmlElement(name = "AllPerilsScore", required = true)
    protected CommercialPerilScoreType allPerilsScore;
    @XmlElement(name = "PropertyPerilScores", required = true)
    protected PropertyCommercialPerilsType propertyPerilScores;
    @XmlElement(name = "CasualtyPerilScores", required = true)
    protected CasualtyCommercialPerilsType casualtyPerilScores;

    /**
     * Gets the value of the allPerilsScore property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialPerilScoreType }
     *     
     */
    public CommercialPerilScoreType getAllPerilsScore() {
        return allPerilsScore;
    }

    /**
     * Sets the value of the allPerilsScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialPerilScoreType }
     *     
     */
    public void setAllPerilsScore(CommercialPerilScoreType value) {
        this.allPerilsScore = value;
    }

    /**
     * Gets the value of the propertyPerilScores property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyCommercialPerilsType }
     *     
     */
    public PropertyCommercialPerilsType getPropertyPerilScores() {
        return propertyPerilScores;
    }

    /**
     * Sets the value of the propertyPerilScores property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyCommercialPerilsType }
     *     
     */
    public void setPropertyPerilScores(PropertyCommercialPerilsType value) {
        this.propertyPerilScores = value;
    }

    /**
     * Gets the value of the casualtyPerilScores property.
     * 
     * @return
     *     possible object is
     *     {@link CasualtyCommercialPerilsType }
     *     
     */
    public CasualtyCommercialPerilsType getCasualtyPerilScores() {
        return casualtyPerilScores;
    }

    /**
     * Sets the value of the casualtyPerilScores property.
     * 
     * @param value
     *     allowed object is
     *     {@link CasualtyCommercialPerilsType }
     *     
     */
    public void setCasualtyPerilScores(CasualtyCommercialPerilsType value) {
        this.casualtyPerilScores = value;
    }

}
