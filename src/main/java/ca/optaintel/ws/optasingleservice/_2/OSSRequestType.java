
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OSSRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSSRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestHeader" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestHeaderType"/>
 *         &lt;element name="RequestBody" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestBodyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OSSRequestType", propOrder = {
    "requestHeader",
    "requestBody"
})
public class OSSRequestType {

    @XmlElement(name = "RequestHeader", required = true)
    protected RequestHeaderType requestHeader;
    @XmlElement(name = "RequestBody", required = true)
    protected RequestBodyType requestBody;

    /**
     * Gets the value of the requestHeader property.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeaderType }
     *     
     */
    public RequestHeaderType getRequestHeader() {
        return requestHeader;
    }

    /**
     * Sets the value of the requestHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeaderType }
     *     
     */
    public void setRequestHeader(RequestHeaderType value) {
        this.requestHeader = value;
    }

    /**
     * Gets the value of the requestBody property.
     * 
     * @return
     *     possible object is
     *     {@link RequestBodyType }
     *     
     */
    public RequestBodyType getRequestBody() {
        return requestBody;
    }

    /**
     * Sets the value of the requestBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestBodyType }
     *     
     */
    public void setRequestBody(RequestBodyType value) {
        this.requestBody = value;
    }

}
