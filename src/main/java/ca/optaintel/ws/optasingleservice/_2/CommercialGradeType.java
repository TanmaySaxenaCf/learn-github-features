
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialGradeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialGradeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PublicFireProtectionClassification" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="RiskSCORDetail" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}RiskSCORDetailType" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="WaterSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialGradeType", propOrder = {
    "publicFireProtectionClassification",
    "riskSCORDetail",
    "waterSystem"
})
public class CommercialGradeType {

    @XmlElement(name = "PublicFireProtectionClassification", required = true)
    protected BigInteger publicFireProtectionClassification;
    @XmlElement(name = "RiskSCORDetail")
    protected List<RiskSCORDetailType> riskSCORDetail;
    @XmlElement(name = "WaterSystem")
    protected String waterSystem;

    /**
     * Gets the value of the publicFireProtectionClassification property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPublicFireProtectionClassification() {
        return publicFireProtectionClassification;
    }

    /**
     * Sets the value of the publicFireProtectionClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPublicFireProtectionClassification(BigInteger value) {
        this.publicFireProtectionClassification = value;
    }

    /**
     * Gets the value of the riskSCORDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the riskSCORDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRiskSCORDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RiskSCORDetailType }
     * 
     * 
     */
    public List<RiskSCORDetailType> getRiskSCORDetail() {
        if (riskSCORDetail == null) {
            riskSCORDetail = new ArrayList<RiskSCORDetailType>();
        }
        return this.riskSCORDetail;
    }

    /**
     * Gets the value of the waterSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaterSystem() {
        return waterSystem;
    }

    /**
     * Sets the value of the waterSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaterSystem(String value) {
        this.waterSystem = value;
    }

}
