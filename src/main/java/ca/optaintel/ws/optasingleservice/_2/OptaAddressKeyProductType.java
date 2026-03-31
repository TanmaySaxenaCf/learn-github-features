
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptaAddressKeyProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptaAddressKeyProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="OptaAddressKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StreetNumber" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetNumberType"/>
 *         &lt;element name="StreetName" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetNameType"/>
 *         &lt;element name="StreetType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetTypeType"/>
 *         &lt;element name="StreetDirection" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}StreetDirectionType"/>
 *         &lt;element name="UnitNumber" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}UnitNumberType"/>
 *         &lt;element name="Municipality" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}MunicipalityType"/>
 *         &lt;element name="Province" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ProvinceType"/>
 *         &lt;element name="PostalCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PostalCodeType"/>
 *         &lt;element name="AddressProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfidenceScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetNumberSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StreetNumberInRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptaAddressKeyProductType", propOrder = {
    "optaAddressKey",
    "streetNumber",
    "streetName",
    "streetType",
    "streetDirection",
    "unitNumber",
    "municipality",
    "province",
    "postalCode",
    "addressProvider",
    "addressType",
    "confidenceScore",
    "streetID",
    "streetNumberSuffix",
    "streetNumberInRange"
})
public class OptaAddressKeyProductType
    extends BaseProductType
{

    @XmlElement(name = "OptaAddressKey", required = true)
    protected String optaAddressKey;
    @XmlElement(name = "StreetNumber", required = true)
    protected String streetNumber;
    @XmlElement(name = "StreetName", required = true)
    protected String streetName;
    @XmlElement(name = "StreetType", required = true)
    protected String streetType;
    @XmlElement(name = "StreetDirection", required = true)
    protected String streetDirection;
    @XmlElement(name = "UnitNumber", required = true)
    protected String unitNumber;
    @XmlElement(name = "Municipality", required = true)
    protected String municipality;
    @XmlElement(name = "Province", required = true)
    @XmlSchemaType(name = "string")
    protected ProvinceType province;
    @XmlElement(name = "PostalCode", required = true)
    protected String postalCode;
    @XmlElement(name = "AddressProvider")
    protected String addressProvider;
    @XmlElement(name = "AddressType")
    protected String addressType;
    @XmlElement(name = "ConfidenceScore")
    protected String confidenceScore;
    @XmlElement(name = "StreetID")
    protected String streetID;
    @XmlElement(name = "StreetNumberSuffix")
    protected String streetNumberSuffix;
    @XmlElement(name = "StreetNumberInRange")
    protected String streetNumberInRange;

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

    /**
     * Gets the value of the addressProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressProvider() {
        return addressProvider;
    }

    /**
     * Sets the value of the addressProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressProvider(String value) {
        this.addressProvider = value;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressType(String value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the confidenceScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfidenceScore() {
        return confidenceScore;
    }

    /**
     * Sets the value of the confidenceScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfidenceScore(String value) {
        this.confidenceScore = value;
    }

    /**
     * Gets the value of the streetID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetID() {
        return streetID;
    }

    /**
     * Sets the value of the streetID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetID(String value) {
        this.streetID = value;
    }

    /**
     * Gets the value of the streetNumberSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumberSuffix() {
        return streetNumberSuffix;
    }

    /**
     * Sets the value of the streetNumberSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumberSuffix(String value) {
        this.streetNumberSuffix = value;
    }

    /**
     * Gets the value of the streetNumberInRange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumberInRange() {
        return streetNumberInRange;
    }

    /**
     * Sets the value of the streetNumberInRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumberInRange(String value) {
        this.streetNumberInRange = value;
    }

}
