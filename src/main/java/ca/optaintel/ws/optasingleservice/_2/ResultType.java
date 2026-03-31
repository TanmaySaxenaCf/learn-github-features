
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActivityID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseAddressType" minOccurs="0"/>
 *         &lt;element name="ProductResults" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProductResultsType" minOccurs="0"/>
 *         &lt;element name="StatusCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProductResponseStatusType" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MessageType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultType", propOrder = {
    "activityID",
    "address",
    "productResults",
    "statusCode",
    "message"
})
public class ResultType {

    @XmlElement(name = "ActivityID")
    protected String activityID;
    @XmlElement(name = "Address")
    protected ResponseAddressType address;
    @XmlElement(name = "ProductResults")
    protected ProductResultsType productResults;
    @XmlElement(name = "StatusCode")
    @XmlSchemaType(name = "string")
    protected ProductResponseStatusType statusCode;
    @XmlElement(name = "Message")
    protected List<String> message;

    /**
     * Gets the value of the activityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityID() {
        return activityID;
    }

    /**
     * Sets the value of the activityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityID(String value) {
        this.activityID = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseAddressType }
     *     
     */
    public ResponseAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseAddressType }
     *     
     */
    public void setAddress(ResponseAddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the productResults property.
     * 
     * @return
     *     possible object is
     *     {@link ProductResultsType }
     *     
     */
    public ProductResultsType getProductResults() {
        return productResults;
    }

    /**
     * Sets the value of the productResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductResultsType }
     *     
     */
    public void setProductResults(ProductResultsType value) {
        this.productResults = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link ProductResponseStatusType }
     *     
     */
    public ProductResponseStatusType getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductResponseStatusType }
     *     
     */
    public void setStatusCode(ProductResponseStatusType value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the message property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMessage() {
        if (message == null) {
            message = new ArrayList<String>();
        }
        return this.message;
    }

}
