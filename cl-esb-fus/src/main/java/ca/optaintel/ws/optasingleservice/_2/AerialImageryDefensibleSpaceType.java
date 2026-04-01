
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryDefensibleSpaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryDefensibleSpaceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Image" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryDefensibleSpaceImageType" minOccurs="0"/>
 *         &lt;element name="Report" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryDefensibleSpaceReportType" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryDefensibleSpaceType", propOrder = {
    "image",
    "report",
    "status",
    "statusMessage"
})
public class AerialImageryDefensibleSpaceType {

    @XmlElement(name = "Image")
    protected AerialImageryDefensibleSpaceImageType image;
    @XmlElement(name = "Report")
    protected AerialImageryDefensibleSpaceReportType report;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "StatusMessage")
    protected String statusMessage;

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryDefensibleSpaceImageType }
     *     
     */
    public AerialImageryDefensibleSpaceImageType getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryDefensibleSpaceImageType }
     *     
     */
    public void setImage(AerialImageryDefensibleSpaceImageType value) {
        this.image = value;
    }

    /**
     * Gets the value of the report property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryDefensibleSpaceReportType }
     *     
     */
    public AerialImageryDefensibleSpaceReportType getReport() {
        return report;
    }

    /**
     * Sets the value of the report property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryDefensibleSpaceReportType }
     *     
     */
    public void setReport(AerialImageryDefensibleSpaceReportType value) {
        this.report = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets the value of the statusMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMessage(String value) {
        this.statusMessage = value;
    }

}
