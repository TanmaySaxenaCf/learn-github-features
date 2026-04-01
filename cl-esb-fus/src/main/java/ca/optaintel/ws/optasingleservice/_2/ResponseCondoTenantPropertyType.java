
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseCondoTenantPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseCondoTenantPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResidentialLineOfBusiness">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="MultiResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseMultiResidentialBuildingType"/>
 *                   &lt;element name="ResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseResidentialConstructionFeaturesType"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseCondoTenantPropertyType", propOrder = {
    "residentialLineOfBusiness"
})
public class ResponseCondoTenantPropertyType {

    @XmlElement(name = "ResidentialLineOfBusiness", required = true)
    protected ResponseCondoTenantPropertyType.ResidentialLineOfBusiness residentialLineOfBusiness;

    /**
     * Gets the value of the residentialLineOfBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCondoTenantPropertyType.ResidentialLineOfBusiness }
     *     
     */
    public ResponseCondoTenantPropertyType.ResidentialLineOfBusiness getResidentialLineOfBusiness() {
        return residentialLineOfBusiness;
    }

    /**
     * Sets the value of the residentialLineOfBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCondoTenantPropertyType.ResidentialLineOfBusiness }
     *     
     */
    public void setResidentialLineOfBusiness(ResponseCondoTenantPropertyType.ResidentialLineOfBusiness value) {
        this.residentialLineOfBusiness = value;
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
     *         &lt;element name="MultiResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseMultiResidentialBuildingType"/>
     *         &lt;element name="ResidentialBuilding" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseResidentialConstructionFeaturesType"/>
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
        protected ResponseMultiResidentialBuildingType multiResidentialBuilding;
        @XmlElement(name = "ResidentialBuilding")
        protected ResponseResidentialConstructionFeaturesType residentialBuilding;

        /**
         * Gets the value of the multiResidentialBuilding property.
         * 
         * @return
         *     possible object is
         *     {@link ResponseMultiResidentialBuildingType }
         *     
         */
        public ResponseMultiResidentialBuildingType getMultiResidentialBuilding() {
            return multiResidentialBuilding;
        }

        /**
         * Sets the value of the multiResidentialBuilding property.
         * 
         * @param value
         *     allowed object is
         *     {@link ResponseMultiResidentialBuildingType }
         *     
         */
        public void setMultiResidentialBuilding(ResponseMultiResidentialBuildingType value) {
            this.multiResidentialBuilding = value;
        }

        /**
         * Gets the value of the residentialBuilding property.
         * 
         * @return
         *     possible object is
         *     {@link ResponseResidentialConstructionFeaturesType }
         *     
         */
        public ResponseResidentialConstructionFeaturesType getResidentialBuilding() {
            return residentialBuilding;
        }

        /**
         * Sets the value of the residentialBuilding property.
         * 
         * @param value
         *     allowed object is
         *     {@link ResponseResidentialConstructionFeaturesType }
         *     
         */
        public void setResidentialBuilding(ResponseResidentialConstructionFeaturesType value) {
            this.residentialBuilding = value;
        }

    }

}
