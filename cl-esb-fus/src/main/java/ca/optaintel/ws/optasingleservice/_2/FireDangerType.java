
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FireDangerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FireDangerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rating" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FireDangerRatingType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FireDangerType", propOrder = {
    "rating"
})
public class FireDangerType {

    @XmlElement(name = "Rating", required = true)
    @XmlSchemaType(name = "string")
    protected List<FireDangerRatingType> rating;

    /**
     * Gets the value of the rating property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rating property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRating().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FireDangerRatingType }
     * 
     * 
     */
    public List<FireDangerRatingType> getRating() {
        if (rating == null) {
            rating = new ArrayList<FireDangerRatingType>();
        }
        return this.rating;
    }

}
