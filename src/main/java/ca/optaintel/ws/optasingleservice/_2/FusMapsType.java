
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FusMapsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FusMapsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FusMap" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FusMapType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FusMapsType", propOrder = {
    "fusMap"
})
public class FusMapsType {

    @XmlElement(name = "FusMap", required = true)
    protected List<FusMapType> fusMap;

    /**
     * Gets the value of the fusMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fusMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFusMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FusMapType }
     * 
     * 
     */
    public List<FusMapType> getFusMap() {
        if (fusMap == null) {
            fusMap = new ArrayList<FusMapType>();
        }
        return this.fusMap;
    }

}
