
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for iClarifyCommercialOccupancyProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iClarifyCommercialOccupancyProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="Occupant" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialOccupant" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iClarifyCommercialOccupancyProductType", propOrder = {
    "occupant"
})
public class IClarifyCommercialOccupancyProductType
    extends BaseProductType
{

    @XmlElement(name = "Occupant")
    protected List<CommercialOccupant> occupant;

    /**
     * Gets the value of the occupant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the occupant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOccupant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialOccupant }
     * 
     * 
     */
    public List<CommercialOccupant> getOccupant() {
        if (occupant == null) {
            occupant = new ArrayList<CommercialOccupant>();
        }
        return this.occupant;
    }

}
