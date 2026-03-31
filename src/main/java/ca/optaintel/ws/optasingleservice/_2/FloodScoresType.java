
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FloodScoresType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FloodScoresType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FloodScore" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FloodScoreType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FloodMap" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FloodMapType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FloodScoresType", propOrder = {
    "floodScore",
    "floodMap"
})
public class FloodScoresType {

    @XmlElement(name = "FloodScore")
    protected List<FloodScoreType> floodScore;
    @XmlElement(name = "FloodMap")
    protected List<FloodMapType> floodMap;

    /**
     * Gets the value of the floodScore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the floodScore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFloodScore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FloodScoreType }
     * 
     * 
     */
    public List<FloodScoreType> getFloodScore() {
        if (floodScore == null) {
            floodScore = new ArrayList<FloodScoreType>();
        }
        return this.floodScore;
    }

    /**
     * Gets the value of the floodMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the floodMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFloodMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FloodMapType }
     * 
     * 
     */
    public List<FloodMapType> getFloodMap() {
        if (floodMap == null) {
            floodMap = new ArrayList<FloodMapType>();
        }
        return this.floodMap;
    }

}
