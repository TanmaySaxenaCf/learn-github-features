
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerilScorePerilsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerilScorePerilsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Peril" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PerilScorePerilType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerilScorePerilsType", propOrder = {
    "peril"
})
public class PerilScorePerilsType {

    @XmlElement(name = "Peril")
    protected List<PerilScorePerilType> peril;

    /**
     * Gets the value of the peril property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the peril property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeril().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerilScorePerilType }
     * 
     * 
     */
    public List<PerilScorePerilType> getPeril() {
        if (peril == null) {
            peril = new ArrayList<PerilScorePerilType>();
        }
        return this.peril;
    }

}
