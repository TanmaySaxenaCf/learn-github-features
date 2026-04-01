
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryMetadataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryMetadataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CameraTechnology" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GSD" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ImageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LayerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreviewImageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EastImageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NorthImageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SouthImageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WestImageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryMetadataType", propOrder = {
    "cameraTechnology",
    "gsd",
    "imageID",
    "layerName",
    "previewImageURL",
    "version",
    "eastImageURL",
    "northImageURL",
    "southImageURL",
    "westImageURL"
})
public class AerialImageryMetadataType {

    @XmlElement(name = "CameraTechnology")
    protected String cameraTechnology;
    @XmlElement(name = "GSD")
    protected Double gsd;
    @XmlElement(name = "ImageID")
    protected String imageID;
    @XmlElement(name = "LayerName")
    protected String layerName;
    @XmlElement(name = "PreviewImageURL")
    protected String previewImageURL;
    @XmlElement(name = "Version")
    protected String version;
    @XmlElement(name = "EastImageURL")
    protected String eastImageURL;
    @XmlElement(name = "NorthImageURL")
    protected String northImageURL;
    @XmlElement(name = "SouthImageURL")
    protected String southImageURL;
    @XmlElement(name = "WestImageURL")
    protected String westImageURL;

    /**
     * Gets the value of the cameraTechnology property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCameraTechnology() {
        return cameraTechnology;
    }

    /**
     * Sets the value of the cameraTechnology property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCameraTechnology(String value) {
        this.cameraTechnology = value;
    }

    /**
     * Gets the value of the gsd property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGSD() {
        return gsd;
    }

    /**
     * Sets the value of the gsd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGSD(Double value) {
        this.gsd = value;
    }

    /**
     * Gets the value of the imageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageID() {
        return imageID;
    }

    /**
     * Sets the value of the imageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageID(String value) {
        this.imageID = value;
    }

    /**
     * Gets the value of the layerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLayerName() {
        return layerName;
    }

    /**
     * Sets the value of the layerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLayerName(String value) {
        this.layerName = value;
    }

    /**
     * Gets the value of the previewImageURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviewImageURL() {
        return previewImageURL;
    }

    /**
     * Sets the value of the previewImageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviewImageURL(String value) {
        this.previewImageURL = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the eastImageURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEastImageURL() {
        return eastImageURL;
    }

    /**
     * Sets the value of the eastImageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEastImageURL(String value) {
        this.eastImageURL = value;
    }

    /**
     * Gets the value of the northImageURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNorthImageURL() {
        return northImageURL;
    }

    /**
     * Sets the value of the northImageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNorthImageURL(String value) {
        this.northImageURL = value;
    }

    /**
     * Gets the value of the southImageURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSouthImageURL() {
        return southImageURL;
    }

    /**
     * Sets the value of the southImageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSouthImageURL(String value) {
        this.southImageURL = value;
    }

    /**
     * Gets the value of the westImageURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWestImageURL() {
        return westImageURL;
    }

    /**
     * Sets the value of the westImageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWestImageURL(String value) {
        this.westImageURL = value;
    }

}
