
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseBusinessType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseBusinessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrimaryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OptaPlaceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseBusinessType", propOrder = {
    "primaryName",
    "optaPlaceID"
})
public class ResponseBusinessType {

    @XmlElement(name = "PrimaryName", required = true)
    protected String primaryName;
    @XmlElement(name = "OptaPlaceID", required = true)
    protected String optaPlaceID;

    /**
     * Gets the value of the primaryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryName() {
        return primaryName;
    }

    /**
     * Sets the value of the primaryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryName(String value) {
        this.primaryName = value;
    }

    /**
     * Gets the value of the optaPlaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptaPlaceID() {
        return optaPlaceID;
    }

    /**
     * Sets the value of the optaPlaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptaPlaceID(String value) {
        this.optaPlaceID = value;
    }

}
