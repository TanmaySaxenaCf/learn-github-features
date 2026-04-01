
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FUSProductCommercialType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FUSProductCommercialType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RespondingFirehall" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}FirehallType"/>
 *         &lt;element name="CommercialGrade" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}CommercialGradeType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "FUSProductCommercialType", propOrder = {
    "respondingFirehall",
    "commercialGrade",
    "searchMessage"
})
public class FUSProductCommercialType {

    @XmlElement(name = "RespondingFirehall", required = true)
    protected FirehallType respondingFirehall;
    @XmlElement(name = "CommercialGrade")
    protected List<CommercialGradeType> commercialGrade;
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
     * Gets the value of the commercialGrade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commercialGrade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommercialGrade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommercialGradeType }
     * 
     * 
     */
    public List<CommercialGradeType> getCommercialGrade() {
        if (commercialGrade == null) {
            commercialGrade = new ArrayList<CommercialGradeType>();
        }
        return this.commercialGrade;
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
