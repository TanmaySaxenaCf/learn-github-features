
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireFactorsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WildfireFactorsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WildfireFactor" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}WildfireFactorType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WildfireFactorsType", propOrder = {
    "wildfireFactor"
})
public class WildfireFactorsType {

    @XmlElement(name = "WildfireFactor", required = true)
    protected List<WildfireFactorType> wildfireFactor;

    /**
     * Gets the value of the wildfireFactor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wildfireFactor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWildfireFactor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WildfireFactorType }
     * 
     * 
     */
    public List<WildfireFactorType> getWildfireFactor() {
        if (wildfireFactor == null) {
            wildfireFactor = new ArrayList<WildfireFactorType>();
        }
        return this.wildfireFactor;
    }

}
