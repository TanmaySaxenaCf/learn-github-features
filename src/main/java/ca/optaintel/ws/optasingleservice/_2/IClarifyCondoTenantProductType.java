
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for iClarifyCondoTenantProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iClarifyCondoTenantProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Property" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseCondoTenantPropertyType" minOccurs="0"/>
 *         &lt;element name="CondoTenantPerilScore" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseCondoTenantPerilScoreType" minOccurs="0"/>
 *         &lt;element name="CondoTenantPerilScores" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseCondoTenantPerilScoresType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iClarifyCondoTenantProductType", propOrder = {
    "property",
    "condoTenantPerilScore",
    "condoTenantPerilScores"
})
public class IClarifyCondoTenantProductType
    extends BaseProductType
{

    @XmlElement(name = "Property")
    protected ResponseCondoTenantPropertyType property;
    @XmlElement(name = "CondoTenantPerilScore")
    protected ResponseCondoTenantPerilScoreType condoTenantPerilScore;
    @XmlElement(name = "CondoTenantPerilScores")
    protected ResponseCondoTenantPerilScoresType condoTenantPerilScores;

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCondoTenantPropertyType }
     *     
     */
    public ResponseCondoTenantPropertyType getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCondoTenantPropertyType }
     *     
     */
    public void setProperty(ResponseCondoTenantPropertyType value) {
        this.property = value;
    }

    /**
     * Gets the value of the condoTenantPerilScore property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCondoTenantPerilScoreType }
     *     
     */
    public ResponseCondoTenantPerilScoreType getCondoTenantPerilScore() {
        return condoTenantPerilScore;
    }

    /**
     * Sets the value of the condoTenantPerilScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCondoTenantPerilScoreType }
     *     
     */
    public void setCondoTenantPerilScore(ResponseCondoTenantPerilScoreType value) {
        this.condoTenantPerilScore = value;
    }

    /**
     * Gets the value of the condoTenantPerilScores property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCondoTenantPerilScoresType }
     *     
     */
    public ResponseCondoTenantPerilScoresType getCondoTenantPerilScores() {
        return condoTenantPerilScores;
    }

    /**
     * Sets the value of the condoTenantPerilScores property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCondoTenantPerilScoresType }
     *     
     */
    public void setCondoTenantPerilScores(ResponseCondoTenantPerilScoresType value) {
        this.condoTenantPerilScores = value;
    }

}
