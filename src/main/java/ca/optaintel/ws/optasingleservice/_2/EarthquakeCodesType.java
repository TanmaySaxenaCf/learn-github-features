
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EarthquakeCodesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EarthquakeCodesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EarthquakeCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}EarthquakeCodeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EarthquakeCodesType", propOrder = {
    "earthquakeCode"
})
public class EarthquakeCodesType {

    @XmlElement(name = "EarthquakeCode")
    protected List<EarthquakeCodeType> earthquakeCode;

    /**
     * Gets the value of the earthquakeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the earthquakeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEarthquakeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EarthquakeCodeType }
     * 
     * 
     */
    public List<EarthquakeCodeType> getEarthquakeCode() {
        if (earthquakeCode == null) {
            earthquakeCode = new ArrayList<EarthquakeCodeType>();
        }
        return this.earthquakeCode;
    }

}
