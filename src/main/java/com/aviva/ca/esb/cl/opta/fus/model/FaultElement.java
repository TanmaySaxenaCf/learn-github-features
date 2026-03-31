package com.aviva.ca.esb.cl.opta.fus.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.zookeeper.proto.ErrorResponse;

import com.aviva.ca.esb.cl.opta.fus.json.model.ErrorDetails;
import com.aviva.ca.esb.cl.opta.fus.json.model.ResponseError;


/**
 * <p>Java class for FaultElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultElement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://api.esb.ca.aviva.com/schema/v1.0/}errorResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultElement", propOrder = {
    "errorResponse"
})
@XmlRootElement(name = "faultElement", namespace = "http://api.esb.ca.aviva.com/v1.0/")
public class FaultElement {

    @XmlElement(required = true)
    protected ErrorDetails errorResponse;

    /**
     * Gets the value of the errorResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorResponse }
     *     
     */
    public ErrorDetails getErrorResponse() {
        return errorResponse;
    }

    /**
     * Sets the value of the errorResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorResponse }
     *     
     */
    public void setErrorResponse(ErrorDetails value) {
        this.errorResponse = value;
    }

}
