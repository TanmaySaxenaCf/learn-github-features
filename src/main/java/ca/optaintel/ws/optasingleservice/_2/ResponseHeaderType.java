
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ResponseHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestReceivedTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ResponseSentTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ElapsedMilliseconds" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ServiceVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Request" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AnyType" minOccurs="0"/>
 *         &lt;element name="MachineName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Session" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Debug" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AnyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseHeaderType", propOrder = {
    "requestID",
    "requestReceivedTimestamp",
    "responseSentTimestamp",
    "elapsedMilliseconds",
    "serviceVersion",
    "request",
    "machineName",
    "session",
    "nodeName",
    "debug"
})
public class ResponseHeaderType {

    @XmlElement(name = "RequestID", required = true)
    protected String requestID;
    @XmlElement(name = "RequestReceivedTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requestReceivedTimestamp;
    @XmlElement(name = "ResponseSentTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar responseSentTimestamp;
    @XmlElement(name = "ElapsedMilliseconds", required = true)
    protected BigInteger elapsedMilliseconds;
    @XmlElement(name = "ServiceVersion", required = true)
    protected String serviceVersion;
    @XmlElement(name = "Request")
    protected AnyType request;
    @XmlElement(name = "MachineName", required = true)
    protected String machineName;
    @XmlElement(name = "Session", required = true)
    protected String session;
    @XmlElement(name = "NodeName")
    protected String nodeName;
    @XmlElement(name = "Debug")
    protected AnyType debug;

    /**
     * Gets the value of the requestID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * Sets the value of the requestID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestID(String value) {
        this.requestID = value;
    }

    /**
     * Gets the value of the requestReceivedTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestReceivedTimestamp() {
        return requestReceivedTimestamp;
    }

    /**
     * Sets the value of the requestReceivedTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestReceivedTimestamp(XMLGregorianCalendar value) {
        this.requestReceivedTimestamp = value;
    }

    /**
     * Gets the value of the responseSentTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResponseSentTimestamp() {
        return responseSentTimestamp;
    }

    /**
     * Sets the value of the responseSentTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResponseSentTimestamp(XMLGregorianCalendar value) {
        this.responseSentTimestamp = value;
    }

    /**
     * Gets the value of the elapsedMilliseconds property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getElapsedMilliseconds() {
        return elapsedMilliseconds;
    }

    /**
     * Sets the value of the elapsedMilliseconds property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setElapsedMilliseconds(BigInteger value) {
        this.elapsedMilliseconds = value;
    }

    /**
     * Gets the value of the serviceVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceVersion() {
        return serviceVersion;
    }

    /**
     * Sets the value of the serviceVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceVersion(String value) {
        this.serviceVersion = value;
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link AnyType }
     *     
     */
    public AnyType getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyType }
     *     
     */
    public void setRequest(AnyType value) {
        this.request = value;
    }

    /**
     * Gets the value of the machineName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachineName() {
        return machineName;
    }

    /**
     * Sets the value of the machineName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachineName(String value) {
        this.machineName = value;
    }

    /**
     * Gets the value of the session property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSession() {
        return session;
    }

    /**
     * Sets the value of the session property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSession(String value) {
        this.session = value;
    }

    /**
     * Gets the value of the nodeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * Sets the value of the nodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeName(String value) {
        this.nodeName = value;
    }

    /**
     * Gets the value of the debug property.
     * 
     * @return
     *     possible object is
     *     {@link AnyType }
     *     
     */
    public AnyType getDebug() {
        return debug;
    }

    /**
     * Sets the value of the debug property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyType }
     *     
     */
    public void setDebug(AnyType value) {
        this.debug = value;
    }

}
