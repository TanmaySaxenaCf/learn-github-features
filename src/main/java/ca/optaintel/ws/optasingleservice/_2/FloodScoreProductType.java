
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FloodScoreProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FloodScoreProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="FloodScores" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FloodScoresType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FloodScoreProductType", propOrder = {
    "floodScores"
})
public class FloodScoreProductType
    extends BaseProductType
{

    @XmlElement(name = "FloodScores", required = true)
    protected FloodScoresType floodScores;

    /**
     * Gets the value of the floodScores property.
     * 
     * @return
     *     possible object is
     *     {@link FloodScoresType }
     *     
     */
    public FloodScoresType getFloodScores() {
        return floodScores;
    }

    /**
     * Sets the value of the floodScores property.
     * 
     * @param value
     *     allowed object is
     *     {@link FloodScoresType }
     *     
     */
    public void setFloodScores(FloodScoresType value) {
        this.floodScores = value;
    }

}
