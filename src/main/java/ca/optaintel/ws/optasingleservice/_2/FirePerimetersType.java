
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FirePerimetersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FirePerimetersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FirePerimeter" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FirePerimeterType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FirePerimetersType", propOrder = {
    "firePerimeter"
})
public class FirePerimetersType {

    @XmlElement(name = "FirePerimeter", required = true)
    protected List<FirePerimeterType> firePerimeter;

    /**
     * Gets the value of the firePerimeter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the firePerimeter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFirePerimeter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FirePerimeterType }
     * 
     * 
     */
    public List<FirePerimeterType> getFirePerimeter() {
        if (firePerimeter == null) {
            firePerimeter = new ArrayList<FirePerimeterType>();
        }
        return this.firePerimeter;
    }

}
