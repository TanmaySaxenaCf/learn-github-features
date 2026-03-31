
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LegalDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegalDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnformattedLegalDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quarter" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LegalDescriptionQuarterType" minOccurs="0"/>
 *         &lt;element name="LegalSubdivision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Township" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Range" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Meridian" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}LegalDescriptionMeridianType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalDescriptionType", propOrder = {
    "unformattedLegalDescription",
    "quarter",
    "legalSubdivision",
    "section",
    "township",
    "range",
    "meridian"
})
public class LegalDescriptionType {

    @XmlElement(name = "UnformattedLegalDescription")
    protected String unformattedLegalDescription;
    @XmlElement(name = "Quarter")
    @XmlSchemaType(name = "string")
    protected LegalDescriptionQuarterType quarter;
    @XmlElement(name = "LegalSubdivision")
    protected String legalSubdivision;
    @XmlElement(name = "Section")
    protected String section;
    @XmlElement(name = "Township")
    protected String township;
    @XmlElement(name = "Range")
    protected String range;
    @XmlElement(name = "Meridian")
    @XmlSchemaType(name = "string")
    protected LegalDescriptionMeridianType meridian;

    /**
     * Gets the value of the unformattedLegalDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnformattedLegalDescription() {
        return unformattedLegalDescription;
    }

    /**
     * Sets the value of the unformattedLegalDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnformattedLegalDescription(String value) {
        this.unformattedLegalDescription = value;
    }

    /**
     * Gets the value of the quarter property.
     * 
     * @return
     *     possible object is
     *     {@link LegalDescriptionQuarterType }
     *     
     */
    public LegalDescriptionQuarterType getQuarter() {
        return quarter;
    }

    /**
     * Sets the value of the quarter property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalDescriptionQuarterType }
     *     
     */
    public void setQuarter(LegalDescriptionQuarterType value) {
        this.quarter = value;
    }

    /**
     * Gets the value of the legalSubdivision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalSubdivision() {
        return legalSubdivision;
    }

    /**
     * Sets the value of the legalSubdivision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalSubdivision(String value) {
        this.legalSubdivision = value;
    }

    /**
     * Gets the value of the section property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets the value of the section property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSection(String value) {
        this.section = value;
    }

    /**
     * Gets the value of the township property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTownship() {
        return township;
    }

    /**
     * Sets the value of the township property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTownship(String value) {
        this.township = value;
    }

    /**
     * Gets the value of the range property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRange() {
        return range;
    }

    /**
     * Sets the value of the range property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRange(String value) {
        this.range = value;
    }

    /**
     * Gets the value of the meridian property.
     * 
     * @return
     *     possible object is
     *     {@link LegalDescriptionMeridianType }
     *     
     */
    public LegalDescriptionMeridianType getMeridian() {
        return meridian;
    }

    /**
     * Sets the value of the meridian property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalDescriptionMeridianType }
     *     
     */
    public void setMeridian(LegalDescriptionMeridianType value) {
        this.meridian = value;
    }

}
