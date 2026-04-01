
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialRoofSurfacesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialRoofSurfacesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoofSurface" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofSurfaceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialRoofSurfacesType", propOrder = {
    "roofSurface"
})
public class CommercialRoofSurfacesType {

    @XmlElement(name = "RoofSurface")
    @XmlSchemaType(name = "string")
    protected List<CommercialRoofSurfaceType> roofSurface;

    /**
     * Gets the value of the roofSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roofSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoofSurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialRoofSurfaceType }
     * 
     * 
     */
    public List<CommercialRoofSurfaceType> getRoofSurface() {
        if (roofSurface == null) {
            roofSurface = new ArrayList<CommercialRoofSurfaceType>();
        }
        return this.roofSurface;
    }

}
