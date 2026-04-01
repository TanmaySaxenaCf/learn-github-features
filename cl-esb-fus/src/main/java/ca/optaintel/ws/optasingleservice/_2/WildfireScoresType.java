
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireScoresType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WildfireScoresType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WildfireScore" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireScoreType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WildfireScoresType", propOrder = {
    "wildfireScore"
})
public class WildfireScoresType {

    @XmlElement(name = "WildfireScore", required = true)
    protected List<WildfireScoreType> wildfireScore;

    /**
     * Gets the value of the wildfireScore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wildfireScore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWildfireScore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WildfireScoreType }
     * 
     * 
     */
    public List<WildfireScoreType> getWildfireScore() {
        if (wildfireScore == null) {
            wildfireScore = new ArrayList<WildfireScoreType>();
        }
        return this.wildfireScore;
    }

}
