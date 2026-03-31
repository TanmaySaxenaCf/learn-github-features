
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryDefensibleSpaceReportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryDefensibleSpaceReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DSB100" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DSB200" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DSB30" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DSB5" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DST100" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DST200" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DST30" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DST5" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Polygon100WKT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Polygon200WKT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Polygon30WKT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Polygon5WKT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryDefensibleSpaceReportType", propOrder = {
    "dsb100",
    "dsb200",
    "dsb30",
    "dsb5",
    "dst100",
    "dst200",
    "dst30",
    "dst5",
    "polygon100WKT",
    "polygon200WKT",
    "polygon30WKT",
    "polygon5WKT"
})
public class AerialImageryDefensibleSpaceReportType {

    @XmlElement(name = "DSB100")
    protected Double dsb100;
    @XmlElement(name = "DSB200")
    protected Double dsb200;
    @XmlElement(name = "DSB30")
    protected Double dsb30;
    @XmlElement(name = "DSB5")
    protected Double dsb5;
    @XmlElement(name = "DST100")
    protected Double dst100;
    @XmlElement(name = "DST200")
    protected Double dst200;
    @XmlElement(name = "DST30")
    protected Double dst30;
    @XmlElement(name = "DST5")
    protected Double dst5;
    @XmlElement(name = "Polygon100WKT")
    protected String polygon100WKT;
    @XmlElement(name = "Polygon200WKT")
    protected String polygon200WKT;
    @XmlElement(name = "Polygon30WKT")
    protected String polygon30WKT;
    @XmlElement(name = "Polygon5WKT")
    protected String polygon5WKT;

    /**
     * Gets the value of the dsb100 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDSB100() {
        return dsb100;
    }

    /**
     * Sets the value of the dsb100 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDSB100(Double value) {
        this.dsb100 = value;
    }

    /**
     * Gets the value of the dsb200 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDSB200() {
        return dsb200;
    }

    /**
     * Sets the value of the dsb200 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDSB200(Double value) {
        this.dsb200 = value;
    }

    /**
     * Gets the value of the dsb30 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDSB30() {
        return dsb30;
    }

    /**
     * Sets the value of the dsb30 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDSB30(Double value) {
        this.dsb30 = value;
    }

    /**
     * Gets the value of the dsb5 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDSB5() {
        return dsb5;
    }

    /**
     * Sets the value of the dsb5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDSB5(Double value) {
        this.dsb5 = value;
    }

    /**
     * Gets the value of the dst100 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDST100() {
        return dst100;
    }

    /**
     * Sets the value of the dst100 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDST100(Double value) {
        this.dst100 = value;
    }

    /**
     * Gets the value of the dst200 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDST200() {
        return dst200;
    }

    /**
     * Sets the value of the dst200 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDST200(Double value) {
        this.dst200 = value;
    }

    /**
     * Gets the value of the dst30 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDST30() {
        return dst30;
    }

    /**
     * Sets the value of the dst30 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDST30(Double value) {
        this.dst30 = value;
    }

    /**
     * Gets the value of the dst5 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDST5() {
        return dst5;
    }

    /**
     * Sets the value of the dst5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDST5(Double value) {
        this.dst5 = value;
    }

    /**
     * Gets the value of the polygon100WKT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolygon100WKT() {
        return polygon100WKT;
    }

    /**
     * Sets the value of the polygon100WKT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolygon100WKT(String value) {
        this.polygon100WKT = value;
    }

    /**
     * Gets the value of the polygon200WKT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolygon200WKT() {
        return polygon200WKT;
    }

    /**
     * Sets the value of the polygon200WKT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolygon200WKT(String value) {
        this.polygon200WKT = value;
    }

    /**
     * Gets the value of the polygon30WKT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolygon30WKT() {
        return polygon30WKT;
    }

    /**
     * Sets the value of the polygon30WKT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolygon30WKT(String value) {
        this.polygon30WKT = value;
    }

    /**
     * Gets the value of the polygon5WKT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolygon5WKT() {
        return polygon5WKT;
    }

    /**
     * Sets the value of the polygon5WKT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolygon5WKT(String value) {
        this.polygon5WKT = value;
    }

}
