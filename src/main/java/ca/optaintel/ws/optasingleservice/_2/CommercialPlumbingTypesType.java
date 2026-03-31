
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialPlumbingTypesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialPlumbingTypesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PlumbingType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialPlumbingTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialPlumbingTypesType", propOrder = {
    "plumbingType"
})
public class CommercialPlumbingTypesType {

    @XmlElement(name = "PlumbingType")
    @XmlSchemaType(name = "string")
    protected List<CommercialPlumbingTypeType> plumbingType;

    /**
     * Gets the value of the plumbingType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plumbingType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlumbingType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialPlumbingTypeType }
     * 
     * 
     */
    public List<CommercialPlumbingTypeType> getPlumbingType() {
        if (plumbingType == null) {
            plumbingType = new ArrayList<CommercialPlumbingTypeType>();
        }
        return this.plumbingType;
    }

}
