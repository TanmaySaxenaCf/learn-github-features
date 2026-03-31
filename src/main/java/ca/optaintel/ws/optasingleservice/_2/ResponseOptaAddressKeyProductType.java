
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseOptaAddressKeyProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseOptaAddressKeyProductType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OptaAddressKey" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OptaAddressKeyType" minOccurs="0"/>
 *         &lt;element name="StreetNumber" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetNumberType"/>
 *         &lt;element name="StreetName" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetNameType"/>
 *         &lt;element name="StreetType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetTypeType" minOccurs="0"/>
 *         &lt;element name="StreetDirection" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetDirectionType" minOccurs="0"/>
 *         &lt;element name="UnitNumber" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitNumberType" minOccurs="0"/>
 *         &lt;element name="Municipality" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MunicipalityType"/>
 *         &lt;element name="Province" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProvinceType"/>
 *         &lt;element name="PostalCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PostalCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseOptaAddressKeyProductType", propOrder = {
    "addressID",
    "optaAddressKey",
    "streetNumber",
    "streetName",
    "streetType",
    "streetDirection",
    "unitNumber",
    "municipality",
    "province",
    "postalCode"
})
public class ResponseOptaAddressKeyProductType {

    @XmlElement(name = "AddressID")
    protected String addressID;
    @XmlElement(name = "OptaAddressKey")
    protected String optaAddressKey;
    @XmlElement(name = "StreetNumber", required = true)
    protected String streetNumber;
    @XmlElement(name = "StreetName", required = true)
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
    protected ProvinceType province;
    @XmlElement(name = "PostalCode")
    protected String postalCode;

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

}
