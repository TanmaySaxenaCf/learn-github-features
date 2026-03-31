
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for iClarifyResidentialProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iClarifyResidentialProductType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.optaintel.ca/ws/OptaSingleService/1.0}BaseProductType">
 *       &lt;sequence>
 *         &lt;element name="ConstructionFeatures" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ResponseResidentialConstructionFeaturesType"/>
 *         &lt;element name="Valuation" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ValuationType"/>
 *         &lt;element name="Images" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}ImagesType" minOccurs="0"/>
 *         &lt;element name="Quicklink" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}QuicklinkType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iClarifyResidentialProductType", propOrder = {
    "constructionFeatures",
    "valuation",
    "images",
    "quicklink"
})
public class IClarifyResidentialProductType
    extends BaseProductType
{

    @XmlElement(name = "ConstructionFeatures", required = true)
    protected ResponseResidentialConstructionFeaturesType constructionFeatures;
    @XmlElement(name = "Valuation", required = true)
    protected ValuationType valuation;
    @XmlElement(name = "Images")
    protected ImagesType images;
    @XmlElement(name = "Quicklink")
    protected QuicklinkType quicklink;

    /**
     * Gets the value of the constructionFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseResidentialConstructionFeaturesType }
     *     
     */
    public ResponseResidentialConstructionFeaturesType getConstructionFeatures() {
        return constructionFeatures;
    }

    /**
     * Sets the value of the constructionFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseResidentialConstructionFeaturesType }
     *     
     */
    public void setConstructionFeatures(ResponseResidentialConstructionFeaturesType value) {
        this.constructionFeatures = value;
    }

    /**
     * Gets the value of the valuation property.
     * 
     * @return
     *     possible object is
     *     {@link ValuationType }
     *     
     */
    public ValuationType getValuation() {
        return valuation;
    }

    /**
     * Sets the value of the valuation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValuationType }
     *     
     */
    public void setValuation(ValuationType value) {
        this.valuation = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ImagesType }
     *     
     */
    public ImagesType getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImagesType }
     *     
     */
    public void setImages(ImagesType value) {
        this.images = value;
    }

    /**
     * Gets the value of the quicklink property.
     * 
     * @return
     *     possible object is
     *     {@link QuicklinkType }
     *     
     */
    public QuicklinkType getQuicklink() {
        return quicklink;
    }

    /**
     * Sets the value of the quicklink property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuicklinkType }
     *     
     */
    public void setQuicklink(QuicklinkType value) {
        this.quicklink = value;
    }

}
