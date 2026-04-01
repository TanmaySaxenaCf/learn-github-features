
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for FirehallType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FirehallType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoadDistanceKilometres" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="InitialResponseTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GoverningAgency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProtectionGradeTerritories" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Commercial" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProtectionGradeTerritoryType"/>
 *                   &lt;element name="Dwelling" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProtectionGradeTerritoryType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FirefightersPerFireStation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FullTime" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Volunteer" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TankerCapacityImperialGallons" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="PumperFlowImperialGallonsPerMinute" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="SuperiorTankerServiceAccreditationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="GradingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Recognized" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FirehallType", propOrder = {
    "name",
    "address",
    "roadDistanceKilometres",
    "initialResponseTime",
    "governingAgency",
    "protectionGradeTerritories",
    "firefightersPerFireStation",
    "tankerCapacityImperialGallons",
    "pumperFlowImperialGallonsPerMinute",
    "superiorTankerServiceAccreditationDate",
    "gradingDate",
    "recognized"
})
public class FirehallType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "RoadDistanceKilometres")
    protected Float roadDistanceKilometres;
    @XmlElement(name = "InitialResponseTime")
    protected String initialResponseTime;
    @XmlElement(name = "GoverningAgency", required = true)
    protected String governingAgency;
    @XmlElement(name = "ProtectionGradeTerritories")
    protected FirehallType.ProtectionGradeTerritories protectionGradeTerritories;
    @XmlElement(name = "FirefightersPerFireStation")
    protected FirehallType.FirefightersPerFireStation firefightersPerFireStation;
    @XmlElement(name = "TankerCapacityImperialGallons")
    protected BigInteger tankerCapacityImperialGallons;
    @XmlElement(name = "PumperFlowImperialGallonsPerMinute")
    protected BigInteger pumperFlowImperialGallonsPerMinute;
    @XmlElement(name = "SuperiorTankerServiceAccreditationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar superiorTankerServiceAccreditationDate;
    @XmlElement(name = "GradingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar gradingDate;
    @XmlElement(name = "Recognized")
    protected String recognized;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the roadDistanceKilometres property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRoadDistanceKilometres() {
        return roadDistanceKilometres;
    }

    /**
     * Sets the value of the roadDistanceKilometres property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRoadDistanceKilometres(Float value) {
        this.roadDistanceKilometres = value;
    }

    /**
     * Gets the value of the initialResponseTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialResponseTime() {
        return initialResponseTime;
    }

    /**
     * Sets the value of the initialResponseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialResponseTime(String value) {
        this.initialResponseTime = value;
    }

    /**
     * Gets the value of the governingAgency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoverningAgency() {
        return governingAgency;
    }

    /**
     * Sets the value of the governingAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoverningAgency(String value) {
        this.governingAgency = value;
    }

    /**
     * Gets the value of the protectionGradeTerritories property.
     * 
     * @return
     *     possible object is
     *     {@link FirehallType.ProtectionGradeTerritories }
     *     
     */
    public FirehallType.ProtectionGradeTerritories getProtectionGradeTerritories() {
        return protectionGradeTerritories;
    }

    /**
     * Sets the value of the protectionGradeTerritories property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirehallType.ProtectionGradeTerritories }
     *     
     */
    public void setProtectionGradeTerritories(FirehallType.ProtectionGradeTerritories value) {
        this.protectionGradeTerritories = value;
    }

    /**
     * Gets the value of the firefightersPerFireStation property.
     * 
     * @return
     *     possible object is
     *     {@link FirehallType.FirefightersPerFireStation }
     *     
     */
    public FirehallType.FirefightersPerFireStation getFirefightersPerFireStation() {
        return firefightersPerFireStation;
    }

    /**
     * Sets the value of the firefightersPerFireStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirehallType.FirefightersPerFireStation }
     *     
     */
    public void setFirefightersPerFireStation(FirehallType.FirefightersPerFireStation value) {
        this.firefightersPerFireStation = value;
    }

    /**
     * Gets the value of the tankerCapacityImperialGallons property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTankerCapacityImperialGallons() {
        return tankerCapacityImperialGallons;
    }

    /**
     * Sets the value of the tankerCapacityImperialGallons property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTankerCapacityImperialGallons(BigInteger value) {
        this.tankerCapacityImperialGallons = value;
    }

    /**
     * Gets the value of the pumperFlowImperialGallonsPerMinute property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPumperFlowImperialGallonsPerMinute() {
        return pumperFlowImperialGallonsPerMinute;
    }

    /**
     * Sets the value of the pumperFlowImperialGallonsPerMinute property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPumperFlowImperialGallonsPerMinute(BigInteger value) {
        this.pumperFlowImperialGallonsPerMinute = value;
    }

    /**
     * Gets the value of the superiorTankerServiceAccreditationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSuperiorTankerServiceAccreditationDate() {
        return superiorTankerServiceAccreditationDate;
    }

    /**
     * Sets the value of the superiorTankerServiceAccreditationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSuperiorTankerServiceAccreditationDate(XMLGregorianCalendar value) {
        this.superiorTankerServiceAccreditationDate = value;
    }

    /**
     * Gets the value of the gradingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGradingDate() {
        return gradingDate;
    }

    /**
     * Sets the value of the gradingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGradingDate(XMLGregorianCalendar value) {
        this.gradingDate = value;
    }

    /**
     * Gets the value of the recognized property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecognized() {
        return recognized;
    }

    /**
     * Sets the value of the recognized property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecognized(String value) {
        this.recognized = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="FullTime" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Volunteer" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fullTime",
        "volunteer"
    })
    public static class FirefightersPerFireStation {

        @XmlElement(name = "FullTime")
        protected float fullTime;
        @XmlElement(name = "Volunteer")
        protected float volunteer;

        /**
         * Gets the value of the fullTime property.
         * 
         */
        public float getFullTime() {
            return fullTime;
        }

        /**
         * Sets the value of the fullTime property.
         * 
         */
        public void setFullTime(float value) {
            this.fullTime = value;
        }

        /**
         * Gets the value of the volunteer property.
         * 
         */
        public float getVolunteer() {
            return volunteer;
        }

        /**
         * Sets the value of the volunteer property.
         * 
         */
        public void setVolunteer(float value) {
            this.volunteer = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Commercial" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProtectionGradeTerritoryType"/>
     *         &lt;element name="Dwelling" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProtectionGradeTerritoryType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "commercial",
        "dwelling"
    })
    public static class ProtectionGradeTerritories {

        @XmlElement(name = "Commercial", required = true)
        protected String commercial;
        @XmlElement(name = "Dwelling", required = true)
        protected String dwelling;

        /**
         * Gets the value of the commercial property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCommercial() {
            return commercial;
        }

        /**
         * Sets the value of the commercial property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCommercial(String value) {
            this.commercial = value;
        }

        /**
         * Gets the value of the dwelling property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDwelling() {
            return dwelling;
        }

        /**
         * Sets the value of the dwelling property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDwelling(String value) {
            this.dwelling = value;
        }

    }

}
