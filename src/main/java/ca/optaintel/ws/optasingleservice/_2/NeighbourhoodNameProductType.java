
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NeighbourhoodNameProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NeighbourhoodNameProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="NeighbourhoodName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NeighbourhoodNameProductType", propOrder = {
    "neighbourhoodName"
})
public class NeighbourhoodNameProductType
    extends BaseProductType
{

    @XmlElement(name = "NeighbourhoodName")
    protected String neighbourhoodName;

    /**
     * Gets the value of the neighbourhoodName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeighbourhoodName() {
        return neighbourhoodName;
    }

    /**
     * Sets the value of the neighbourhoodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeighbourhoodName(String value) {
        this.neighbourhoodName = value;
    }

}
