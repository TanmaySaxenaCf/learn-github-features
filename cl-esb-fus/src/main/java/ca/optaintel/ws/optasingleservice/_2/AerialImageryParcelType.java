
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryParcelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AerialImageryParcelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Synthetic" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TreeCoveragePercentage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AerialImageryParcelType", propOrder = {
    "synthetic",
    "treeCoveragePercentage"
})
public class AerialImageryParcelType {

    @XmlElement(name = "Synthetic")
    protected Boolean synthetic;
    @XmlElement(name = "TreeCoveragePercentage")
    protected Double treeCoveragePercentage;

    /**
     * Gets the value of the synthetic property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSynthetic() {
        return synthetic;
    }

    /**
     * Sets the value of the synthetic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSynthetic(Boolean value) {
        this.synthetic = value;
    }

    /**
     * Gets the value of the treeCoveragePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTreeCoveragePercentage() {
        return treeCoveragePercentage;
    }

    /**
     * Sets the value of the treeCoveragePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTreeCoveragePercentage(Double value) {
        this.treeCoveragePercentage = value;
    }

}
