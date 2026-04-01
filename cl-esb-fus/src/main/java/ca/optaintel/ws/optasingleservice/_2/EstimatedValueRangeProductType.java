
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstimatedValueRangeProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstimatedValueRangeProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="EstimatedValueRange" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}EstimatedValueRangesType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstimatedValueRangeProductType", propOrder = {
    "estimatedValueRange"
})
public class EstimatedValueRangeProductType
    extends BaseProductType
{

    @XmlElement(name = "EstimatedValueRange")
    protected List<EstimatedValueRangesType> estimatedValueRange;

    /**
     * Gets the value of the estimatedValueRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the estimatedValueRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEstimatedValueRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EstimatedValueRangesType }
     * 
     * 
     */
    public List<EstimatedValueRangesType> getEstimatedValueRange() {
        if (estimatedValueRange == null) {
            estimatedValueRange = new ArrayList<EstimatedValueRangesType>();
        }
        return this.estimatedValueRange;
    }

}
