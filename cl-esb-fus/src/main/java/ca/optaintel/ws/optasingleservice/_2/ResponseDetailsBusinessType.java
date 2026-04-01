
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseDetailsBusinessType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseDetailsBusinessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Building" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponsePropertyBuildingAddressType" minOccurs="0"/>
 *         &lt;element name="MapsURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PhotosURLs" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponsePhotoURLs" maxOccurs="unbounded"/>
 *         &lt;element name="Reviews" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseReviews" maxOccurs="unbounded"/>
 *         &lt;element name="PlaceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseDetailsBusinessType", propOrder = {
    "building",
    "mapsURL",
    "photosURLs",
    "reviews",
    "placeID",
    "primaryName",
    "primaryPhone",
    "websiteURL"
})
public class ResponseDetailsBusinessType {

    @XmlElement(name = "Building")
    protected ResponsePropertyBuildingAddressType building;
    @XmlElement(name = "MapsURL", required = true)
    protected String mapsURL;
    @XmlElement(name = "PhotosURLs", required = true)
    protected List<ResponsePhotoURLs> photosURLs;
    @XmlElement(name = "Reviews", required = true)
    protected List<ResponseReviews> reviews;
    @XmlElement(name = "PlaceID")
    protected String placeID;
    @XmlElement(name = "PrimaryName")
    protected String primaryName;
    @XmlElement(name = "PrimaryPhone")
    protected String primaryPhone;
    @XmlElement(name = "WebsiteURL")
    protected String websiteURL;

    /**
     * Gets the value of the building property.
     * 
     * @return
     *     possible object is
     *     {@link ResponsePropertyBuildingAddressType }
     *     
     */
    public ResponsePropertyBuildingAddressType getBuilding() {
        return building;
    }

    /**
     * Sets the value of the building property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsePropertyBuildingAddressType }
     *     
     */
    public void setBuilding(ResponsePropertyBuildingAddressType value) {
        this.building = value;
    }

    /**
     * Gets the value of the mapsURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapsURL() {
        return mapsURL;
    }

    /**
     * Sets the value of the mapsURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapsURL(String value) {
        this.mapsURL = value;
    }

    /**
     * Gets the value of the photosURLs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the photosURLs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhotosURLs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponsePhotoURLs }
     * 
     * 
     */
    public List<ResponsePhotoURLs> getPhotosURLs() {
        if (photosURLs == null) {
            photosURLs = new ArrayList<ResponsePhotoURLs>();
        }
        return this.photosURLs;
    }

    /**
     * Gets the value of the reviews property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reviews property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReviews().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseReviews }
     * 
     * 
     */
    public List<ResponseReviews> getReviews() {
        if (reviews == null) {
            reviews = new ArrayList<ResponseReviews>();
        }
        return this.reviews;
    }

    /**
     * Gets the value of the placeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceID() {
        return placeID;
    }

    /**
     * Sets the value of the placeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceID(String value) {
        this.placeID = value;
    }

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
     * Gets the value of the primaryPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    /**
     * Sets the value of the primaryPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryPhone(String value) {
        this.primaryPhone = value;
    }

    /**
     * Gets the value of the websiteURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebsiteURL() {
        return websiteURL;
    }

    /**
     * Sets the value of the websiteURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebsiteURL(String value) {
        this.websiteURL = value;
    }

}
