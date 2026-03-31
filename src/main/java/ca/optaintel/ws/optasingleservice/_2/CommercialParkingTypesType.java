
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialParkingTypesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialParkingTypesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ParkingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialParkingTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialParkingTypesType", propOrder = {
    "parkingType"
})
public class CommercialParkingTypesType {

    @XmlElement(name = "ParkingType")
    @XmlSchemaType(name = "string")
    protected List<CommercialParkingTypeType> parkingType;

    /**
     * Gets the value of the parkingType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parkingType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParkingType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialParkingTypeType }
     * 
     * 
     */
    public List<CommercialParkingTypeType> getParkingType() {
        if (parkingType == null) {
            parkingType = new ArrayList<CommercialParkingTypeType>();
        }
        return this.parkingType;
    }

}
