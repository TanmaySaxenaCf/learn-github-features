
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RentalValuationProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RentalValuationProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="RentalValuation" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RentalValuationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentalValuationProductType", propOrder = {
    "rentalValuation"
})
public class RentalValuationProductType
    extends BaseProductType
{

    @XmlElement(name = "RentalValuation")
    protected List<RentalValuationType> rentalValuation;

    /**
     * Gets the value of the rentalValuation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentalValuation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentalValuation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RentalValuationType }
     * 
     * 
     */
    public List<RentalValuationType> getRentalValuation() {
        if (rentalValuation == null) {
            rentalValuation = new ArrayList<RentalValuationType>();
        }
        return this.rentalValuation;
    }

}
