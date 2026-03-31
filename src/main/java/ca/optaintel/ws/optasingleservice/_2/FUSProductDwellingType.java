
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FUSProductDwellingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FUSProductDwellingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RespondingFirehall" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FirehallType"/>
 *         &lt;element name="DwellingGrades" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}DwellingGradesType"/>
 *         &lt;element name="SearchMessage" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}SearchMessageType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FUSProductDwellingType", propOrder = {
    "respondingFirehall",
    "dwellingGrades",
    "searchMessage"
})
public class FUSProductDwellingType {

    @XmlElement(name = "RespondingFirehall", required = true)
    protected FirehallType respondingFirehall;
    @XmlElement(name = "DwellingGrades", required = true)
    protected DwellingGradesType dwellingGrades;
    @XmlElement(name = "SearchMessage")
    protected SearchMessageType searchMessage;

    /**
     * Gets the value of the respondingFirehall property.
     * 
     * @return
     *     possible object is
     *     {@link FirehallType }
     *     
     */
    public FirehallType getRespondingFirehall() {
        return respondingFirehall;
    }

    /**
     * Sets the value of the respondingFirehall property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirehallType }
     *     
     */
    public void setRespondingFirehall(FirehallType value) {
        this.respondingFirehall = value;
    }

    /**
     * Gets the value of the dwellingGrades property.
     * 
     * @return
     *     possible object is
     *     {@link DwellingGradesType }
     *     
     */
    public DwellingGradesType getDwellingGrades() {
        return dwellingGrades;
    }

    /**
     * Sets the value of the dwellingGrades property.
     * 
     * @param value
     *     allowed object is
     *     {@link DwellingGradesType }
     *     
     */
    public void setDwellingGrades(DwellingGradesType value) {
        this.dwellingGrades = value;
    }

    /**
     * Gets the value of the searchMessage property.
     * 
     * @return
     *     possible object is
     *     {@link SearchMessageType }
     *     
     */
    public SearchMessageType getSearchMessage() {
        return searchMessage;
    }

    /**
     * Sets the value of the searchMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchMessageType }
     *     
     */
    public void setSearchMessage(SearchMessageType value) {
        this.searchMessage = value;
    }

}
