
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalSecurityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PhysicalSecurityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PhysicalSecurityType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PhysicalSecurityItemsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalSecurityType", propOrder = {
    "physicalSecurityType"
})
public class PhysicalSecurityType {

    @XmlElement(name = "PhysicalSecurityType")
    @XmlSchemaType(name = "string")
    protected List<PhysicalSecurityItemsType> physicalSecurityType;

    /**
     * Gets the value of the physicalSecurityType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physicalSecurityType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysicalSecurityType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalSecurityItemsType }
     * 
     * 
     */
    public List<PhysicalSecurityItemsType> getPhysicalSecurityType() {
        if (physicalSecurityType == null) {
            physicalSecurityType = new ArrayList<PhysicalSecurityItemsType>();
        }
        return this.physicalSecurityType;
    }

}
