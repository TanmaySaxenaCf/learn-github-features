
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseCondoTenantPerilScoresType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseCondoTenantPerilScoresType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PerilScore" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseCondoPerilScoresType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseCondoTenantPerilScoresType", propOrder = {
    "perilScore"
})
public class ResponseCondoTenantPerilScoresType {

    @XmlElement(name = "PerilScore")
    protected List<ResponseCondoPerilScoresType> perilScore;

    /**
     * Gets the value of the perilScore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the perilScore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerilScore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseCondoPerilScoresType }
     * 
     * 
     */
    public List<ResponseCondoPerilScoresType> getPerilScore() {
        if (perilScore == null) {
            perilScore = new ArrayList<ResponseCondoPerilScoresType>();
        }
        return this.perilScore;
    }

}
