
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidentialMarketValuationProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResidentialMarketValuationProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="MarketValuation" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResidentialMarketValuationsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResidentialMarketValuationProductType", propOrder = {
    "marketValuation"
})
public class ResidentialMarketValuationProductType
    extends BaseProductType
{

    @XmlElement(name = "MarketValuation")
    protected List<ResidentialMarketValuationsType> marketValuation;

    /**
     * Gets the value of the marketValuation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the marketValuation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarketValuation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResidentialMarketValuationsType }
     * 
     * 
     */
    public List<ResidentialMarketValuationsType> getMarketValuation() {
        if (marketValuation == null) {
            marketValuation = new ArrayList<ResidentialMarketValuationsType>();
        }
        return this.marketValuation;
    }

}
