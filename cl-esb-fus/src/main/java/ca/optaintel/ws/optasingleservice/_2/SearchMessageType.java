
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchMessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchMessageType", propOrder = {
    "searchMessage"
})
public class SearchMessageType {

    @XmlElement(name = "SearchMessage")
    protected String searchMessage;

    /**
     * Gets the value of the searchMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchMessage() {
        return searchMessage;
    }

    /**
     * Sets the value of the searchMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchMessage(String value) {
        this.searchMessage = value;
    }

}
