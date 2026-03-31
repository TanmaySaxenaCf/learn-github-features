
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialOccupancyFirmographicsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialOccupancyFirmographicsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="YearEstablished" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="NumberOfEmployees" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="NumberOfEmployeesBinCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}NumberOfEmployeesBinType" minOccurs="0"/>
 *         &lt;element name="TotalSales" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CurrencyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialOccupancyFirmographicsType", propOrder = {
    "yearEstablished",
    "numberOfEmployees",
    "numberOfEmployeesBinCode",
    "totalSales",
    "currencyCode"
})
public class CommercialOccupancyFirmographicsType {

    @XmlElement(name = "YearEstablished")
    protected BigInteger yearEstablished;
    @XmlElement(name = "NumberOfEmployees")
    protected BigInteger numberOfEmployees;
    @XmlElement(name = "NumberOfEmployeesBinCode")
    protected String numberOfEmployeesBinCode;
    @XmlElement(name = "TotalSales")
    protected Double totalSales;
    @XmlElement(name = "CurrencyCode")
    @XmlSchemaType(name = "string")
    protected CurrencyType currencyCode;

    /**
     * Gets the value of the yearEstablished property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getYearEstablished() {
        return yearEstablished;
    }

    /**
     * Sets the value of the yearEstablished property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setYearEstablished(BigInteger value) {
        this.yearEstablished = value;
    }

    /**
     * Gets the value of the numberOfEmployees property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Sets the value of the numberOfEmployees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfEmployees(BigInteger value) {
        this.numberOfEmployees = value;
    }

    /**
     * Gets the value of the numberOfEmployeesBinCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfEmployeesBinCode() {
        return numberOfEmployeesBinCode;
    }

    /**
     * Sets the value of the numberOfEmployeesBinCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfEmployeesBinCode(String value) {
        this.numberOfEmployeesBinCode = value;
    }

    /**
     * Gets the value of the totalSales property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalSales() {
        return totalSales;
    }

    /**
     * Sets the value of the totalSales property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalSales(Double value) {
        this.totalSales = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyType }
     *     
     */
    public CurrencyType getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyType }
     *     
     */
    public void setCurrencyCode(CurrencyType value) {
        this.currencyCode = value;
    }

}
