
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AerialImageryProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="CaptureDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Parcel" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryParcelType" minOccurs="0"/>
 *         &lt;element name="PropertyFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryPropertyFeaturesType" minOccurs="0"/>
 *         &lt;element name="Structures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryStructuresType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryProductType", propOrder = {
    "captureDate",
    "parcel",
    "propertyFeatures",
    "structures"
})
public class AerialImageryProductType
    extends BaseProductType
{

    @XmlElement(name = "CaptureDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar captureDate;
    @XmlElement(name = "Parcel")
    protected AerialImageryParcelType parcel;
    @XmlElement(name = "PropertyFeatures")
    protected AerialImageryPropertyFeaturesType propertyFeatures;
    @XmlElement(name = "Structures")
    protected AerialImageryStructuresType structures;

    /**
     * Gets the value of the captureDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCaptureDate() {
        return captureDate;
    }

    /**
     * Sets the value of the captureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCaptureDate(XMLGregorianCalendar value) {
        this.captureDate = value;
    }

    /**
     * Gets the value of the parcel property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryParcelType }
     *     
     */
    public AerialImageryParcelType getParcel() {
        return parcel;
    }

    /**
     * Sets the value of the parcel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryParcelType }
     *     
     */
    public void setParcel(AerialImageryParcelType value) {
        this.parcel = value;
    }

    /**
     * Gets the value of the propertyFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryPropertyFeaturesType }
     *     
     */
    public AerialImageryPropertyFeaturesType getPropertyFeatures() {
        return propertyFeatures;
    }

    /**
     * Sets the value of the propertyFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryPropertyFeaturesType }
     *     
     */
    public void setPropertyFeatures(AerialImageryPropertyFeaturesType value) {
        this.propertyFeatures = value;
    }

    /**
     * Gets the value of the structures property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryStructuresType }
     *     
     */
    public AerialImageryStructuresType getStructures() {
        return structures;
    }

    /**
     * Sets the value of the structures property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryStructuresType }
     *     
     */
    public void setStructures(AerialImageryStructuresType value) {
        this.structures = value;
    }

}
