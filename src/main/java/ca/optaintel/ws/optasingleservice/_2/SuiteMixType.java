
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SuiteMixType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SuiteMixType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SuiteType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SuiteTypeCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuiteMixType", propOrder = {
    "suiteType",
    "suiteTypeCount"
})
public class SuiteMixType {

    @XmlElement(name = "SuiteType")
    protected String suiteType;
    @XmlElement(name = "SuiteTypeCount")
    protected String suiteTypeCount;

    /**
     * Gets the value of the suiteType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuiteType() {
        return suiteType;
    }

    /**
     * Sets the value of the suiteType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuiteType(String value) {
        this.suiteType = value;
    }

    /**
     * Gets the value of the suiteTypeCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuiteTypeCount() {
        return suiteTypeCount;
    }

    /**
     * Sets the value of the suiteTypeCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuiteTypeCount(String value) {
        this.suiteTypeCount = value;
    }

}
