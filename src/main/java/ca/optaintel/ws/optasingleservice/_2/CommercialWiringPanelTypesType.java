
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialWiringPanelTypesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialWiringPanelTypesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WiringPanelType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialWiringPanelTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialWiringPanelTypesType", propOrder = {
    "wiringPanelType"
})
public class CommercialWiringPanelTypesType {

    @XmlElement(name = "WiringPanelType")
    @XmlSchemaType(name = "string")
    protected List<CommercialWiringPanelTypeType> wiringPanelType;

    /**
     * Gets the value of the wiringPanelType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wiringPanelType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWiringPanelType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialWiringPanelTypeType }
     * 
     * 
     */
    public List<CommercialWiringPanelTypeType> getWiringPanelType() {
        if (wiringPanelType == null) {
            wiringPanelType = new ArrayList<CommercialWiringPanelTypeType>();
        }
        return this.wiringPanelType;
    }

}
