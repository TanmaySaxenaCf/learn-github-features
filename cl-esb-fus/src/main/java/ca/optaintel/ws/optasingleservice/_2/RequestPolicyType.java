
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestPolicyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Insured" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestInsuredInformationType" minOccurs="0"/>
 *         &lt;element name="PackageType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PackageType" minOccurs="0"/>
 *         &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PolicyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalInsuredValue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CoverageAmounts" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CoverageAmountType" minOccurs="0"/>
 *         &lt;element name="Limit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Deductible" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="OccupancyType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OccupancyType" minOccurs="0"/>
 *         &lt;element name="OwnershipType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}OwnershipType" minOccurs="0"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrokerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailingAddress" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestAddressType" minOccurs="0"/>
 *         &lt;element name="ContactInformation" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestContactInformationType" minOccurs="0"/>
 *         &lt;element name="AdditionalPolicyDetails" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AdditionalPolicyDetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestPolicyType", propOrder = {
    "insured",
    "packageType",
    "policyNumber",
    "policyType",
    "totalInsuredValue",
    "coverageAmounts",
    "limit",
    "deductible",
    "occupancyType",
    "ownershipType",
    "effectiveDate",
    "brokerName",
    "mailingAddress",
    "contactInformation",
    "additionalPolicyDetails"
})
public class RequestPolicyType {

    @XmlElement(name = "Insured")
    protected RequestInsuredInformationType insured;
    @XmlElement(name = "PackageType")
    @XmlSchemaType(name = "string")
    protected PackageType packageType;
    @XmlElement(name = "PolicyNumber")
    protected String policyNumber;
    @XmlElement(name = "PolicyType")
    protected String policyType;
    @XmlElement(name = "TotalInsuredValue")
    protected Double totalInsuredValue;
    @XmlElement(name = "CoverageAmounts")
    protected CoverageAmountType coverageAmounts;
    @XmlElement(name = "Limit")
    protected Double limit;
    @XmlElement(name = "Deductible")
    protected Double deductible;
    @XmlElement(name = "OccupancyType")
    @XmlSchemaType(name = "string")
    protected OccupancyType occupancyType;
    @XmlElement(name = "OwnershipType")
    @XmlSchemaType(name = "string")
    protected OwnershipType ownershipType;
    @XmlElement(name = "EffectiveDate")
    protected String effectiveDate;
    @XmlElement(name = "BrokerName")
    protected String brokerName;
    @XmlElement(name = "MailingAddress")
    protected RequestAddressType mailingAddress;
    @XmlElement(name = "ContactInformation")
    protected RequestContactInformationType contactInformation;
    @XmlElement(name = "AdditionalPolicyDetails")
    protected AdditionalPolicyDetailsType additionalPolicyDetails;

    /**
     * Gets the value of the insured property.
     * 
     * @return
     *     possible object is
     *     {@link RequestInsuredInformationType }
     *     
     */
    public RequestInsuredInformationType getInsured() {
        return insured;
    }

    /**
     * Sets the value of the insured property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestInsuredInformationType }
     *     
     */
    public void setInsured(RequestInsuredInformationType value) {
        this.insured = value;
    }

    /**
     * Gets the value of the packageType property.
     * 
     * @return
     *     possible object is
     *     {@link PackageType }
     *     
     */
    public PackageType getPackageType() {
        return packageType;
    }

    /**
     * Sets the value of the packageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageType }
     *     
     */
    public void setPackageType(PackageType value) {
        this.packageType = value;
    }

    /**
     * Gets the value of the policyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the value of the policyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyNumber(String value) {
        this.policyNumber = value;
    }

    /**
     * Gets the value of the policyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyType() {
        return policyType;
    }

    /**
     * Sets the value of the policyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyType(String value) {
        this.policyType = value;
    }

    /**
     * Gets the value of the totalInsuredValue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalInsuredValue() {
        return totalInsuredValue;
    }

    /**
     * Sets the value of the totalInsuredValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalInsuredValue(Double value) {
        this.totalInsuredValue = value;
    }

    /**
     * Gets the value of the coverageAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link CoverageAmountType }
     *     
     */
    public CoverageAmountType getCoverageAmounts() {
        return coverageAmounts;
    }

    /**
     * Sets the value of the coverageAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverageAmountType }
     *     
     */
    public void setCoverageAmounts(CoverageAmountType value) {
        this.coverageAmounts = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLimit(Double value) {
        this.limit = value;
    }

    /**
     * Gets the value of the deductible property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDeductible() {
        return deductible;
    }

    /**
     * Sets the value of the deductible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDeductible(Double value) {
        this.deductible = value;
    }

    /**
     * Gets the value of the occupancyType property.
     * 
     * @return
     *     possible object is
     *     {@link OccupancyType }
     *     
     */
    public OccupancyType getOccupancyType() {
        return occupancyType;
    }

    /**
     * Sets the value of the occupancyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OccupancyType }
     *     
     */
    public void setOccupancyType(OccupancyType value) {
        this.occupancyType = value;
    }

    /**
     * Gets the value of the ownershipType property.
     * 
     * @return
     *     possible object is
     *     {@link OwnershipType }
     *     
     */
    public OwnershipType getOwnershipType() {
        return ownershipType;
    }

    /**
     * Sets the value of the ownershipType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OwnershipType }
     *     
     */
    public void setOwnershipType(OwnershipType value) {
        this.ownershipType = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the brokerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrokerName() {
        return brokerName;
    }

    /**
     * Sets the value of the brokerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrokerName(String value) {
        this.brokerName = value;
    }

    /**
     * Gets the value of the mailingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link RequestAddressType }
     *     
     */
    public RequestAddressType getMailingAddress() {
        return mailingAddress;
    }

    /**
     * Sets the value of the mailingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestAddressType }
     *     
     */
    public void setMailingAddress(RequestAddressType value) {
        this.mailingAddress = value;
    }

    /**
     * Gets the value of the contactInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RequestContactInformationType }
     *     
     */
    public RequestContactInformationType getContactInformation() {
        return contactInformation;
    }

    /**
     * Sets the value of the contactInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestContactInformationType }
     *     
     */
    public void setContactInformation(RequestContactInformationType value) {
        this.contactInformation = value;
    }

    /**
     * Gets the value of the additionalPolicyDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalPolicyDetailsType }
     *     
     */
    public AdditionalPolicyDetailsType getAdditionalPolicyDetails() {
        return additionalPolicyDetails;
    }

    /**
     * Sets the value of the additionalPolicyDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalPolicyDetailsType }
     *     
     */
    public void setAdditionalPolicyDetails(AdditionalPolicyDetailsType value) {
        this.additionalPolicyDetails = value;
    }

}
