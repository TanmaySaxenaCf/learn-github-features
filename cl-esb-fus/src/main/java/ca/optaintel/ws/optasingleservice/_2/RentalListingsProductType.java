
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RentalListingsProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RentalListingsProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="RentalListings" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyValuesType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentalListingsProductType", propOrder = {
    "rentalListings"
})
public class RentalListingsProductType
    extends BaseProductType
{

    @XmlElement(name = "RentalListings")
    protected List<PropertyValuesType> rentalListings;

    /**
     * Gets the value of the rentalListings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalListings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalListings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyValuesType }
     * 
     * 
     */
    public List<PropertyValuesType> getRentalListings() {
        if (rentalListings == null) {
            rentalListings = new ArrayList<PropertyValuesType>();
        }
        return this.rentalListings;
    }

}
