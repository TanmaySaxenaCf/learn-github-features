
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialWiringTypesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialWiringTypesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WiringType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialWiringTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialWiringTypesType", propOrder = {
    "wiringType"
})
public class CommercialWiringTypesType {

    @XmlElement(name = "WiringType")
    @XmlSchemaType(name = "string")
    protected List<CommercialWiringTypeType> wiringType;

    /**
     * Gets the value of the wiringType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wiringType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWiringType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialWiringTypeType }
     * 
     * 
     */
    public List<CommercialWiringTypeType> getWiringType() {
        if (wiringType == null) {
            wiringType = new ArrayList<CommercialWiringTypeType>();
        }
        return this.wiringType;
    }

}
