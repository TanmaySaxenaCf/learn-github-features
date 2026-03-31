
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AdditionalPolicyDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdditionalPolicyDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MultipleMortgages" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CurrentInsuranceDetails" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CurrentInsuranceDetailsType" minOccurs="0"/>
 *         &lt;element name="PropertyClosingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="VacantHome" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CommercialActivity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HistoricalHome" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HomeUnderConstruction" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalPolicyDetailsType", propOrder = {
    "multipleMortgages",
    "currentInsuranceDetails",
    "propertyClosingDate",
    "vacantHome",
    "commercialActivity",
    "historicalHome",
    "homeUnderConstruction"
})
public class AdditionalPolicyDetailsType {

    @XmlElement(name = "MultipleMortgages")
    protected Boolean multipleMortgages;
    @XmlElement(name = "CurrentInsuranceDetails")
    protected CurrentInsuranceDetailsType currentInsuranceDetails;
    @XmlElement(name = "PropertyClosingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar propertyClosingDate;
    @XmlElement(name = "VacantHome")
    protected Boolean vacantHome;
    @XmlElement(name = "CommercialActivity")
    protected Boolean commercialActivity;
    @XmlElement(name = "HistoricalHome")
    protected Boolean historicalHome;
    @XmlElement(name = "HomeUnderConstruction")
    protected Boolean homeUnderConstruction;

    /**
     * Gets the value of the multipleMortgages property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultipleMortgages() {
        return multipleMortgages;
    }

    /**
     * Sets the value of the multipleMortgages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultipleMortgages(Boolean value) {
        this.multipleMortgages = value;
    }

    /**
     * Gets the value of the currentInsuranceDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentInsuranceDetailsType }
     *     
     */
    public CurrentInsuranceDetailsType getCurrentInsuranceDetails() {
        return currentInsuranceDetails;
    }

    /**
     * Sets the value of the currentInsuranceDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentInsuranceDetailsType }
     *     
     */
    public void setCurrentInsuranceDetails(CurrentInsuranceDetailsType value) {
        this.currentInsuranceDetails = value;
    }

    /**
     * Gets the value of the propertyClosingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPropertyClosingDate() {
        return propertyClosingDate;
    }

    /**
     * Sets the value of the propertyClosingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPropertyClosingDate(XMLGregorianCalendar value) {
        this.propertyClosingDate = value;
    }

    /**
     * Gets the value of the vacantHome property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVacantHome() {
        return vacantHome;
    }

    /**
     * Sets the value of the vacantHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVacantHome(Boolean value) {
        this.vacantHome = value;
    }

    /**
     * Gets the value of the commercialActivity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCommercialActivity() {
        return commercialActivity;
    }

    /**
     * Sets the value of the commercialActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCommercialActivity(Boolean value) {
        this.commercialActivity = value;
    }

    /**
     * Gets the value of the historicalHome property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHistoricalHome() {
        return historicalHome;
    }

    /**
     * Sets the value of the historicalHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricalHome(Boolean value) {
        this.historicalHome = value;
    }

    /**
     * Gets the value of the homeUnderConstruction property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHomeUnderConstruction() {
        return homeUnderConstruction;
    }

    /**
     * Sets the value of the homeUnderConstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHomeUnderConstruction(Boolean value) {
        this.homeUnderConstruction = value;
    }

}
