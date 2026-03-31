
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RequestInspectionOrderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestInspectionOrderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeOfInspection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ActivationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="NotificationEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AbeyanceDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="SpecialHandlingInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnderwritingConcerns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InspectionConcerns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportOutputLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InspectionContact" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestContactInformationType" minOccurs="0"/>
 *         &lt;element name="CommercialInsuredType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialInsuredTypeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestInspectionOrderType", propOrder = {
    "typeOfInspection",
    "activationDate",
    "notificationEmail",
    "abeyanceDate",
    "specialHandlingInstructions",
    "underwritingConcerns",
    "inspectionConcerns",
    "reportOutputLanguage",
    "inspectionContact",
    "commercialInsuredType"
})
public class RequestInspectionOrderType {

    @XmlElement(name = "TypeOfInspection", required = true)
    protected String typeOfInspection;
    @XmlElement(name = "ActivationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar activationDate;
    @XmlElement(name = "NotificationEmail")
    protected String notificationEmail;
    @XmlElement(name = "AbeyanceDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar abeyanceDate;
    @XmlElement(name = "SpecialHandlingInstructions")
    protected String specialHandlingInstructions;
    @XmlElement(name = "UnderwritingConcerns")
    protected String underwritingConcerns;
    @XmlElement(name = "InspectionConcerns")
    protected String inspectionConcerns;
    @XmlElement(name = "ReportOutputLanguage")
    protected String reportOutputLanguage;
    @XmlElement(name = "InspectionContact")
    protected RequestContactInformationType inspectionContact;
    @XmlElement(name = "CommercialInsuredType")
    @XmlSchemaType(name = "string")
    protected CommercialInsuredTypeType commercialInsuredType;

    /**
     * Gets the value of the typeOfInspection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfInspection() {
        return typeOfInspection;
    }

    /**
     * Sets the value of the typeOfInspection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfInspection(String value) {
        this.typeOfInspection = value;
    }

    /**
     * Gets the value of the activationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActivationDate() {
        return activationDate;
    }

    /**
     * Sets the value of the activationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActivationDate(XMLGregorianCalendar value) {
        this.activationDate = value;
    }

    /**
     * Gets the value of the notificationEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationEmail() {
        return notificationEmail;
    }

    /**
     * Sets the value of the notificationEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationEmail(String value) {
        this.notificationEmail = value;
    }

    /**
     * Gets the value of the abeyanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAbeyanceDate() {
        return abeyanceDate;
    }

    /**
     * Sets the value of the abeyanceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAbeyanceDate(XMLGregorianCalendar value) {
        this.abeyanceDate = value;
    }

    /**
     * Gets the value of the specialHandlingInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialHandlingInstructions() {
        return specialHandlingInstructions;
    }

    /**
     * Sets the value of the specialHandlingInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialHandlingInstructions(String value) {
        this.specialHandlingInstructions = value;
    }

    /**
     * Gets the value of the underwritingConcerns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderwritingConcerns() {
        return underwritingConcerns;
    }

    /**
     * Sets the value of the underwritingConcerns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderwritingConcerns(String value) {
        this.underwritingConcerns = value;
    }

    /**
     * Gets the value of the inspectionConcerns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionConcerns() {
        return inspectionConcerns;
    }

    /**
     * Sets the value of the inspectionConcerns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionConcerns(String value) {
        this.inspectionConcerns = value;
    }

    /**
     * Gets the value of the reportOutputLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportOutputLanguage() {
        return reportOutputLanguage;
    }

    /**
     * Sets the value of the reportOutputLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportOutputLanguage(String value) {
        this.reportOutputLanguage = value;
    }

    /**
     * Gets the value of the inspectionContact property.
     * 
     * @return
     *     possible object is
     *     {@link RequestContactInformationType }
     *     
     */
    public RequestContactInformationType getInspectionContact() {
        return inspectionContact;
    }

    /**
     * Sets the value of the inspectionContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestContactInformationType }
     *     
     */
    public void setInspectionContact(RequestContactInformationType value) {
        this.inspectionContact = value;
    }

    /**
     * Gets the value of the commercialInsuredType property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialInsuredTypeType }
     *     
     */
    public CommercialInsuredTypeType getCommercialInsuredType() {
        return commercialInsuredType;
    }

    /**
     * Sets the value of the commercialInsuredType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialInsuredTypeType }
     *     
     */
    public void setCommercialInsuredType(CommercialInsuredTypeType value) {
        this.commercialInsuredType = value;
    }

}
