
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireMapsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WildfireMapsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WildfireMap" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireMapType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WildfireMapsType", propOrder = {
    "wildfireMap"
})
public class WildfireMapsType {

    @XmlElement(name = "WildfireMap")
    protected List<WildfireMapType> wildfireMap;

    /**
     * Gets the value of the wildfireMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wildfireMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWildfireMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WildfireMapType }
     * 
     * 
     */
    public List<WildfireMapType> getWildfireMap() {
        if (wildfireMap == null) {
            wildfireMap = new ArrayList<WildfireMapType>();
        }
        return this.wildfireMap;
    }

}
