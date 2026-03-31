
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActualCashValueBuildingsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActualCashValueBuildingsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Building" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ActualCashValueValuationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActualCashValueBuildingsType", propOrder = {
    "building"
})
public class ActualCashValueBuildingsType {

    @XmlElement(name = "Building")
    protected List<ActualCashValueValuationType> building;

    /**
     * Gets the value of the building property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the building property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuilding().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActualCashValueValuationType }
     * 
     * 
     */
    public List<ActualCashValueValuationType> getBuilding() {
        if (building == null) {
            building = new ArrayList<ActualCashValueValuationType>();
        }
        return this.building;
    }

}
