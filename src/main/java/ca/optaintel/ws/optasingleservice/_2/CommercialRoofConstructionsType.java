
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialRoofConstructionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialRoofConstructionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoofConstruction" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialRoofConstructionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialRoofConstructionsType", propOrder = {
    "roofConstruction"
})
public class CommercialRoofConstructionsType {

    @XmlElement(name = "RoofConstruction")
    @XmlSchemaType(name = "string")
    protected List<CommercialRoofConstructionType> roofConstruction;

    /**
     * Gets the value of the roofConstruction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roofConstruction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoofConstruction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialRoofConstructionType }
     * 
     * 
     */
    public List<CommercialRoofConstructionType> getRoofConstruction() {
        if (roofConstruction == null) {
            roofConstruction = new ArrayList<CommercialRoofConstructionType>();
        }
        return this.roofConstruction;
    }

}
