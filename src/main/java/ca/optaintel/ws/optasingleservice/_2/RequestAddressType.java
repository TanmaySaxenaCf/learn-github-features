
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestAddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OptaAddressKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="StreetAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;sequence>
 *             &lt;element name="StreetNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="StreetName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="StreetType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *             &lt;element name="StreetDirection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *             &lt;element name="UnitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="LegalDescription" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LegalDescriptionType" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="Municipality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Geocode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GeocodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestAddressType", propOrder = {
    "addressID",
    "optaAddressKey",
    "streetAddress",
    "streetNumber",
    "streetName",
    "streetType",
    "streetDirection",
    "unitNumber",
    "legalDescription",
    "municipality",
    "province",
    "postalCode",
    "geocode"
})
public class RequestAddressType {

    @XmlElement(name = "AddressID")
    protected String addressID;
    @XmlElement(name = "OptaAddressKey")
    protected String optaAddressKey;
    @XmlElement(name = "StreetAddress")
    protected String streetAddress;
    @XmlElement(name = "StreetNumber")
    protected String streetNumber;
    @XmlElement(name = "StreetName")
    protected String streetName;
    @XmlElement(name = "StreetType")
    protected String streetType;
    @XmlElement(name = "StreetDirection")
    protected String streetDirection;
    @XmlElement(name = "UnitNumber")
    protected String unitNumber;
    @XmlElement(name = "LegalDescription")
    protected LegalDescriptionType legalDescription;
    @XmlElement(name = "Municipality")
    protected String municipality;
    @XmlElement(name = "Province")
    protected String province;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "Geocode")
    protected GeocodeType geocode;

    /**
     * Gets the value of the addressID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressID() {
        return addressID;
    }

    /**
     * Sets the value of the addressID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressID(String value) {
        this.addressID = value;
    }

    /**
     * Gets the value of the optaAddressKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptaAddressKey() {
        return optaAddressKey;
    }

    /**
     * Sets the value of the optaAddressKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptaAddressKey(String value) {
        this.optaAddressKey = value;
    }

    /**
     * Gets the value of the streetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets the value of the streetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetAddress(String value) {
        this.streetAddress = value;
    }

    /**
     * Gets the value of the streetNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets the value of the streetNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumber(String value) {
        this.streetNumber = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the streetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetType() {
        return streetType;
    }

    /**
     * Sets the value of the streetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetType(String value) {
        this.streetType = value;
    }

    /**
     * Gets the value of the streetDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetDirection() {
        return streetDirection;
    }

    /**
     * Sets the value of the streetDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetDirection(String value) {
        this.streetDirection = value;
    }

    /**
     * Gets the value of the unitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * Sets the value of the unitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitNumber(String value) {
        this.unitNumber = value;
    }

    /**
     * Gets the value of the legalDescription property.
     * 
     * @return
     *     possible object is
     *     {@link LegalDescriptionType }
     *     
     */
    public LegalDescriptionType getLegalDescription() {
        return legalDescription;
    }

    /**
     * Sets the value of the legalDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalDescriptionType }
     *     
     */
    public void setLegalDescription(LegalDescriptionType value) {
        this.legalDescription = value;
    }

    /**
     * Gets the value of the municipality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipality() {
        return municipality;
    }

    /**
     * Sets the value of the municipality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipality(String value) {
        this.municipality = value;
    }

    /**
     * Gets the value of the province property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvince(String value) {
        this.province = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the geocode property.
     * 
     * @return
     *     possible object is
     *     {@link GeocodeType }
     *     
     */
    public GeocodeType getGeocode() {
        return geocode;
    }

    /**
     * Sets the value of the geocode property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeocodeType }
     *     
     */
    public void setGeocode(GeocodeType value) {
        this.geocode = value;
    }

}
