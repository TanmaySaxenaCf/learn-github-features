
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseAddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegalDescription" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LegalDescriptionType" minOccurs="0"/>
 *         &lt;element name="AddressID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PropertyIdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OptaAddressKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetNumber" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetNumberType" minOccurs="0"/>
 *         &lt;element name="StreetName" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetNameType" minOccurs="0"/>
 *         &lt;element name="StreetType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetTypeType" minOccurs="0"/>
 *         &lt;element name="StreetDirection" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetDirectionType" minOccurs="0"/>
 *         &lt;element name="UnitNumber" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitNumberType" minOccurs="0"/>
 *         &lt;element name="Municipality" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MunicipalityType"/>
 *         &lt;element name="Province" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProvinceType"/>
 *         &lt;element name="PostalCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PostalCodeType" minOccurs="0"/>
 *         &lt;element name="Geocode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GeocodeType" minOccurs="0"/>
 *         &lt;element name="GeographicalClassification" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}GeographicalClassificationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseAddressType", propOrder = {
    "legalDescription",
    "addressID",
    "propertyIdentificationNumber",
    "optaAddressKey",
    "streetAddress",
    "streetNumber",
    "streetName",
    "streetType",
    "streetDirection",
    "unitNumber",
    "municipality",
    "province",
    "postalCode",
    "geocode",
    "geographicalClassification"
})
public class ResponseAddressType {

    @XmlElement(name = "LegalDescription")
    protected LegalDescriptionType legalDescription;
    @XmlElement(name = "AddressID")
    protected String addressID;
    @XmlElement(name = "PropertyIdentificationNumber")
    protected String propertyIdentificationNumber;
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
    @XmlElement(name = "Municipality", required = true)
    protected String municipality;
    @XmlElement(name = "Province", required = true)
    @XmlSchemaType(name = "string")
    protected ProvinceType province;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "Geocode")
    protected GeocodeType geocode;
    @XmlElement(name = "GeographicalClassification")
    protected List<GeographicalClassificationType> geographicalClassification;

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
     * Gets the value of the propertyIdentificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyIdentificationNumber() {
        return propertyIdentificationNumber;
    }

    /**
     * Sets the value of the propertyIdentificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyIdentificationNumber(String value) {
        this.propertyIdentificationNumber = value;
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
     *     {@link ProvinceType }
     *     
     */
    public ProvinceType getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProvinceType }
     *     
     */
    public void setProvince(ProvinceType value) {
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

    /**
     * Gets the value of the geographicalClassification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geographicalClassification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeographicalClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeographicalClassificationType }
     * 
     * 
     */
    public List<GeographicalClassificationType> getGeographicalClassification() {
        if (geographicalClassification == null) {
            geographicalClassification = new ArrayList<GeographicalClassificationType>();
        }
        return this.geographicalClassification;
    }

}
