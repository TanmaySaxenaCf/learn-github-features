
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyAgeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PropertyAgeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="YearBuilt" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="YearBuiltType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EffectiveYear" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="AdditionYears" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RenovationYears" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyAgeType", propOrder = {
    "yearBuilt",
    "yearBuiltType",
    "effectiveYear",
    "additionYears",
    "renovationYears"
})
public class PropertyAgeType {

    @XmlElement(name = "YearBuilt", required = true)
    protected BigInteger yearBuilt;
    @XmlElement(name = "YearBuiltType", required = true)
    protected String yearBuiltType;
    @XmlElement(name = "EffectiveYear")
    protected BigInteger effectiveYear;
    @XmlElement(name = "AdditionYears", required = true)
    protected String additionYears;
    @XmlElement(name = "RenovationYears")
    protected String renovationYears;

    /**
     * Gets the value of the yearBuilt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearBuilt() {
        return yearBuilt;
    }

    /**
     * Sets the value of the yearBuilt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearBuilt(BigInteger value) {
        this.yearBuilt = value;
    }

    /**
     * Gets the value of the yearBuiltType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYearBuiltType() {
        return yearBuiltType;
    }

    /**
     * Sets the value of the yearBuiltType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYearBuiltType(String value) {
        this.yearBuiltType = value;
    }

    /**
     * Gets the value of the effectiveYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEffectiveYear() {
        return effectiveYear;
    }

    /**
     * Sets the value of the effectiveYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEffectiveYear(BigInteger value) {
        this.effectiveYear = value;
    }

    /**
     * Gets the value of the additionYears property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionYears() {
        return additionYears;
    }

    /**
     * Sets the value of the additionYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionYears(String value) {
        this.additionYears = value;
    }

    /**
     * Gets the value of the renovationYears property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenovationYears() {
        return renovationYears;
    }

    /**
     * Sets the value of the renovationYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenovationYears(String value) {
        this.renovationYears = value;
    }

}
