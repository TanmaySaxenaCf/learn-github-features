
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestBodyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestBodyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Property" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestPropertyType" maxOccurs="10"/>
 *         &lt;element name="RequestedProducts" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestedProductsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestBodyType", propOrder = {
    "property",
    "requestedProducts"
})
public class RequestBodyType {

    @XmlElement(name = "Property", required = true)
    protected List<RequestPropertyType> property;
    @XmlElement(name = "RequestedProducts", required = true)
    protected RequestedProductsType requestedProducts;

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestPropertyType }
     * 
     * 
     */
    public List<RequestPropertyType> getProperty() {
        if (property == null) {
            property = new ArrayList<RequestPropertyType>();
        }
        return this.property;
    }

    /**
     * Gets the value of the requestedProducts property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedProductsType }
     *     
     */
    public RequestedProductsType getRequestedProducts() {
        return requestedProducts;
    }

    /**
     * Sets the value of the requestedProducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedProductsType }
     *     
     */
    public void setRequestedProducts(RequestedProductsType value) {
        this.requestedProducts = value;
    }

}
