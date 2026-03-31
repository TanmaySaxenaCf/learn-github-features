
package ca.optaintel.ws.optasingleservice._2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AerialImageryStructureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryStructureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CaptureDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DefensibleSpace" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryDefensibleSpaceType" minOccurs="0"/>
 *         &lt;element name="Metadata" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryMetadataType" minOccurs="0"/>
 *         &lt;element name="PrimaryStructure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RoofCondition" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="RoofConditionReport" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofConditionReportType" minOccurs="0"/>
 *         &lt;element name="RoofElements" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofElementsType" minOccurs="0"/>
 *         &lt;element name="RoofMaterial" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofMaterialType" minOccurs="0"/>
 *         &lt;element name="RoofShape" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofShapeType" minOccurs="0"/>
 *         &lt;element name="RoofSolar" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}AerialImageryRoofSolarType" minOccurs="0"/>
 *         &lt;element name="RoofTopLocationWKT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TreeCoverPercentage" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryStructureType", propOrder = {
    "captureDate",
    "defensibleSpace",
    "metadata",
    "primaryStructure",
    "roofCondition",
    "roofConditionReport",
    "roofElements",
    "roofMaterial",
    "roofShape",
    "roofSolar",
    "roofTopLocationWKT",
    "treeCoverPercentage"
})
public class AerialImageryStructureType {

    @XmlElement(name = "CaptureDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar captureDate;
    @XmlElement(name = "DefensibleSpace")
    protected AerialImageryDefensibleSpaceType defensibleSpace;
    @XmlElement(name = "Metadata")
    protected AerialImageryMetadataType metadata;
    @XmlElement(name = "PrimaryStructure")
    protected Boolean primaryStructure;
    @XmlElement(name = "RoofCondition")
    protected BigInteger roofCondition;
    @XmlElement(name = "RoofConditionReport")
    protected AerialImageryRoofConditionReportType roofConditionReport;
    @XmlElement(name = "RoofElements")
    protected AerialImageryRoofElementsType roofElements;
    @XmlElement(name = "RoofMaterial")
    protected AerialImageryRoofMaterialType roofMaterial;
    @XmlElement(name = "RoofShape")
    protected AerialImageryRoofShapeType roofShape;
    @XmlElement(name = "RoofSolar")
    protected AerialImageryRoofSolarType roofSolar;
    @XmlElement(name = "RoofTopLocationWKT")
    protected String roofTopLocationWKT;
    @XmlElement(name = "TreeCoverPercentage")
    protected BigInteger treeCoverPercentage;

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
     * Gets the value of the defensibleSpace property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryDefensibleSpaceType }
     *     
     */
    public AerialImageryDefensibleSpaceType getDefensibleSpace() {
        return defensibleSpace;
    }

    /**
     * Sets the value of the defensibleSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryDefensibleSpaceType }
     *     
     */
    public void setDefensibleSpace(AerialImageryDefensibleSpaceType value) {
        this.defensibleSpace = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryMetadataType }
     *     
     */
    public AerialImageryMetadataType getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryMetadataType }
     *     
     */
    public void setMetadata(AerialImageryMetadataType value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the primaryStructure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrimaryStructure() {
        return primaryStructure;
    }

    /**
     * Sets the value of the primaryStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrimaryStructure(Boolean value) {
        this.primaryStructure = value;
    }

    /**
     * Gets the value of the roofCondition property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRoofCondition() {
        return roofCondition;
    }

    /**
     * Sets the value of the roofCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRoofCondition(BigInteger value) {
        this.roofCondition = value;
    }

    /**
     * Gets the value of the roofConditionReport property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofConditionReportType }
     *     
     */
    public AerialImageryRoofConditionReportType getRoofConditionReport() {
        return roofConditionReport;
    }

    /**
     * Sets the value of the roofConditionReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofConditionReportType }
     *     
     */
    public void setRoofConditionReport(AerialImageryRoofConditionReportType value) {
        this.roofConditionReport = value;
    }

    /**
     * Gets the value of the roofElements property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofElementsType }
     *     
     */
    public AerialImageryRoofElementsType getRoofElements() {
        return roofElements;
    }

    /**
     * Sets the value of the roofElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofElementsType }
     *     
     */
    public void setRoofElements(AerialImageryRoofElementsType value) {
        this.roofElements = value;
    }

    /**
     * Gets the value of the roofMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofMaterialType }
     *     
     */
    public AerialImageryRoofMaterialType getRoofMaterial() {
        return roofMaterial;
    }

    /**
     * Sets the value of the roofMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofMaterialType }
     *     
     */
    public void setRoofMaterial(AerialImageryRoofMaterialType value) {
        this.roofMaterial = value;
    }

    /**
     * Gets the value of the roofShape property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofShapeType }
     *     
     */
    public AerialImageryRoofShapeType getRoofShape() {
        return roofShape;
    }

    /**
     * Sets the value of the roofShape property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofShapeType }
     *     
     */
    public void setRoofShape(AerialImageryRoofShapeType value) {
        this.roofShape = value;
    }

    /**
     * Gets the value of the roofSolar property.
     * 
     * @return
     *     possible object is
     *     {@link AerialImageryRoofSolarType }
     *     
     */
    public AerialImageryRoofSolarType getRoofSolar() {
        return roofSolar;
    }

    /**
     * Sets the value of the roofSolar property.
     * 
     * @param value
     *     allowed object is
     *     {@link AerialImageryRoofSolarType }
     *     
     */
    public void setRoofSolar(AerialImageryRoofSolarType value) {
        this.roofSolar = value;
    }

    /**
     * Gets the value of the roofTopLocationWKT property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoofTopLocationWKT() {
        return roofTopLocationWKT;
    }

    /**
     * Sets the value of the roofTopLocationWKT property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoofTopLocationWKT(String value) {
        this.roofTopLocationWKT = value;
    }

    /**
     * Gets the value of the treeCoverPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTreeCoverPercentage() {
        return treeCoverPercentage;
    }

    /**
     * Sets the value of the treeCoverPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTreeCoverPercentage(BigInteger value) {
        this.treeCoverPercentage = value;
    }

}
