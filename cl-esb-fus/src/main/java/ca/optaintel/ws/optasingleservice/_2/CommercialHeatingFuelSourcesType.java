
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialHeatingFuelSourcesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialHeatingFuelSourcesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HeatingFuelSource" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialFuelSourceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialHeatingFuelSourcesType", propOrder = {
    "heatingFuelSource"
})
public class CommercialHeatingFuelSourcesType {

    @XmlElement(name = "HeatingFuelSource")
    @XmlSchemaType(name = "string")
    protected List<CommercialFuelSourceType> heatingFuelSource;

    /**
     * Gets the value of the heatingFuelSource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the heatingFuelSource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHeatingFuelSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialFuelSourceType }
     * 
     * 
     */
    public List<CommercialFuelSourceType> getHeatingFuelSource() {
        if (heatingFuelSource == null) {
            heatingFuelSource = new ArrayList<CommercialFuelSourceType>();
        }
        return this.heatingFuelSource;
    }

}
