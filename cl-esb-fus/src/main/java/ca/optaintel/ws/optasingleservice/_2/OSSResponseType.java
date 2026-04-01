
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OSSResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSSResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseHeader" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseHeaderType"/>
 *         &lt;element name="ResponseBody" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseBodyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OSSResponseType", propOrder = {
    "responseHeader",
    "responseBody"
})
public class OSSResponseType {

    @XmlElement(name = "ResponseHeader", required = true)
    protected ResponseHeaderType responseHeader;
    @XmlElement(name = "ResponseBody", required = true)
    protected ResponseBodyType responseBody;

    /**
     * Gets the value of the responseHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeaderType }
     *     
     */
    public ResponseHeaderType getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the value of the responseHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeaderType }
     *     
     */
    public void setResponseHeader(ResponseHeaderType value) {
        this.responseHeader = value;
    }

    /**
     * Gets the value of the responseBody property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseBodyType }
     *     
     */
    public ResponseBodyType getResponseBody() {
        return responseBody;
    }

    /**
     * Sets the value of the responseBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseBodyType }
     *     
     */
    public void setResponseBody(ResponseBodyType value) {
        this.responseBody = value;
    }

}
