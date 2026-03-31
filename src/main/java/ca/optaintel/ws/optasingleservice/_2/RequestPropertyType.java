
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RequestPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestAddressType" minOccurs="0"/>
 *         &lt;element name="Business" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestBusinessType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Policy" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestPolicyType" minOccurs="0"/>
 *         &lt;element name="PropertyType" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyType" minOccurs="0"/>
 *         &lt;element name="RentalInformation" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RentalInformationType" minOccurs="0"/>
 *         &lt;element name="PropertyStats" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}PropertyStatsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="ResidentialLineOfBusiness" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="MultiResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestMultiResidentialBuildingType"/>
 *                     &lt;element name="ResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestResidentialConstructionFeaturesType"/>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="CommercialLineOfBusiness" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="CommercialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestCommercialConstructionFeaturesType"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="InspectionOrder" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestInspectionOrderType" minOccurs="0"/>
 *         &lt;element name="AdditionalPropertyDetails" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AdditionalDetailsType" minOccurs="0"/>
 *         &lt;element name="HistoricalDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestPropertyType", propOrder = {
    "address",
    "business",
    "policy",
    "propertyType",
    "rentalInformation",
    "propertyStats",
    "residentialLineOfBusiness",
    "commercialLineOfBusiness",
    "inspectionOrder",
    "additionalPropertyDetails",
    "historicalDate"
})
public class RequestPropertyType {

    @XmlElement(name = "Address")
    protected RequestAddressType address;
    @XmlElement(name = "Business")
    protected List<RequestBusinessType> business;
    @XmlElement(name = "Policy")
    protected RequestPolicyType policy;
    @XmlElement(name = "PropertyType")
    @XmlSchemaType(name = "string")
    protected PropertyType propertyType;
    @XmlElement(name = "RentalInformation")
    protected RentalInformationType rentalInformation;
    @XmlElement(name = "PropertyStats")
    protected List<PropertyStatsType> propertyStats;
    @XmlElement(name = "ResidentialLineOfBusiness")
    protected RequestPropertyType.ResidentialLineOfBusiness residentialLineOfBusiness;
    @XmlElement(name = "CommercialLineOfBusiness")
    protected RequestPropertyType.CommercialLineOfBusiness commercialLineOfBusiness;
    @XmlElement(name = "InspectionOrder")
    protected RequestInspectionOrderType inspectionOrder;
    @XmlElement(name = "AdditionalPropertyDetails")
    protected AdditionalDetailsType additionalPropertyDetails;
    @XmlElement(name = "HistoricalDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar historicalDate;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link RequestAddressType }
     *     
     */
    public RequestAddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestAddressType }
     *     
     */
    public void setAddress(RequestAddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the business property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the business property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusiness().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestBusinessType }
     * 
     * 
     */
    public List<RequestBusinessType> getBusiness() {
        if (business == null) {
            business = new ArrayList<RequestBusinessType>();
        }
        return this.business;
    }

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link RequestPolicyType }
     *     
     */
    public RequestPolicyType getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestPolicyType }
     *     
     */
    public void setPolicy(RequestPolicyType value) {
        this.policy = value;
    }

    /**
     * Gets the value of the propertyType property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyType }
     *     
     */
    public PropertyType getPropertyType() {
        return propertyType;
    }

    /**
     * Sets the value of the propertyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyType }
     *     
     */
    public void setPropertyType(PropertyType value) {
        this.propertyType = value;
    }

    /**
     * Gets the value of the rentalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RentalInformationType }
     *     
     */
    public RentalInformationType getRentalInformation() {
        return rentalInformation;
    }

    /**
     * Sets the value of the rentalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RentalInformationType }
     *     
     */
    public void setRentalInformation(RentalInformationType value) {
        this.rentalInformation = value;
    }

    /**
     * Gets the value of the propertyStats property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyStats property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyStats().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyStatsType }
     * 
     * 
     */
    public List<PropertyStatsType> getPropertyStats() {
        if (propertyStats == null) {
            propertyStats = new ArrayList<PropertyStatsType>();
        }
        return this.propertyStats;
    }

    /**
     * Gets the value of the residentialLineOfBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link RequestPropertyType.ResidentialLineOfBusiness }
     *     
     */
    public RequestPropertyType.ResidentialLineOfBusiness getResidentialLineOfBusiness() {
        return residentialLineOfBusiness;
    }

    /**
     * Sets the value of the residentialLineOfBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestPropertyType.ResidentialLineOfBusiness }
     *     
     */
    public void setResidentialLineOfBusiness(RequestPropertyType.ResidentialLineOfBusiness value) {
        this.residentialLineOfBusiness = value;
    }

    /**
     * Gets the value of the commercialLineOfBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link RequestPropertyType.CommercialLineOfBusiness }
     *     
     */
    public RequestPropertyType.CommercialLineOfBusiness getCommercialLineOfBusiness() {
        return commercialLineOfBusiness;
    }

    /**
     * Sets the value of the commercialLineOfBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestPropertyType.CommercialLineOfBusiness }
     *     
     */
    public void setCommercialLineOfBusiness(RequestPropertyType.CommercialLineOfBusiness value) {
        this.commercialLineOfBusiness = value;
    }

    /**
     * Gets the value of the inspectionOrder property.
     * 
     * @return
     *     possible object is
     *     {@link RequestInspectionOrderType }
     *     
     */
    public RequestInspectionOrderType getInspectionOrder() {
        return inspectionOrder;
    }

    /**
     * Sets the value of the inspectionOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestInspectionOrderType }
     *     
     */
    public void setInspectionOrder(RequestInspectionOrderType value) {
        this.inspectionOrder = value;
    }

    /**
     * Gets the value of the additionalPropertyDetails property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalDetailsType }
     *     
     */
    public AdditionalDetailsType getAdditionalPropertyDetails() {
        return additionalPropertyDetails;
    }

    /**
     * Sets the value of the additionalPropertyDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalDetailsType }
     *     
     */
    public void setAdditionalPropertyDetails(AdditionalDetailsType value) {
        this.additionalPropertyDetails = value;
    }

    /**
     * Gets the value of the historicalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHistoricalDate() {
        return historicalDate;
    }

    /**
     * Sets the value of the historicalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHistoricalDate(XMLGregorianCalendar value) {
        this.historicalDate = value;
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
     *         &lt;element name="CommercialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestCommercialConstructionFeaturesType"/>
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
        "commercialBuilding"
    })
    public static class CommercialLineOfBusiness {

        @XmlElement(name = "CommercialBuilding", required = true)
        protected RequestCommercialConstructionFeaturesType commercialBuilding;

        /**
         * Gets the value of the commercialBuilding property.
         * 
         * @return
         *     possible object is
         *     {@link RequestCommercialConstructionFeaturesType }
         *     
         */
        public RequestCommercialConstructionFeaturesType getCommercialBuilding() {
            return commercialBuilding;
        }

        /**
         * Sets the value of the commercialBuilding property.
         * 
         * @param value
         *     allowed object is
         *     {@link RequestCommercialConstructionFeaturesType }
         *     
         */
        public void setCommercialBuilding(RequestCommercialConstructionFeaturesType value) {
            this.commercialBuilding = value;
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
     *       &lt;choice>
     *         &lt;element name="MultiResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestMultiResidentialBuildingType"/>
     *         &lt;element name="ResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RequestResidentialConstructionFeaturesType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "multiResidentialBuilding",
        "residentialBuilding"
    })
    public static class ResidentialLineOfBusiness {

        @XmlElement(name = "MultiResidentialBuilding")
        protected RequestMultiResidentialBuildingType multiResidentialBuilding;
        @XmlElement(name = "ResidentialBuilding")
        protected RequestResidentialConstructionFeaturesType residentialBuilding;

        /**
         * Gets the value of the multiResidentialBuilding property.
         * 
         * @return
         *     possible object is
         *     {@link RequestMultiResidentialBuildingType }
         *     
         */
        public RequestMultiResidentialBuildingType getMultiResidentialBuilding() {
            return multiResidentialBuilding;
        }

        /**
         * Sets the value of the multiResidentialBuilding property.
         * 
         * @param value
         *     allowed object is
         *     {@link RequestMultiResidentialBuildingType }
         *     
         */
        public void setMultiResidentialBuilding(RequestMultiResidentialBuildingType value) {
            this.multiResidentialBuilding = value;
        }

        /**
         * Gets the value of the residentialBuilding property.
         * 
         * @return
         *     possible object is
         *     {@link RequestResidentialConstructionFeaturesType }
         *     
         */
        public RequestResidentialConstructionFeaturesType getResidentialBuilding() {
            return residentialBuilding;
        }

        /**
         * Sets the value of the residentialBuilding property.
         * 
         * @param value
         *     allowed object is
         *     {@link RequestResidentialConstructionFeaturesType }
         *     
         */
        public void setResidentialBuilding(RequestResidentialConstructionFeaturesType value) {
            this.residentialBuilding = value;
        }

    }

}
