
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DwellingProtectedGradeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DwellingProtectedGradeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Grade" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WaterSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DwellingProtectedGradeType", propOrder = {
    "grade",
    "waterSystem"
})
public class DwellingProtectedGradeType {

    @XmlElement(name = "Grade", required = true)
    protected String grade;
    @XmlElement(name = "WaterSystem")
    protected String waterSystem;

    /**
     * Gets the value of the grade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrade(String value) {
        this.grade = value;
    }

    /**
     * Gets the value of the waterSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaterSystem() {
        return waterSystem;
    }

    /**
     * Sets the value of the waterSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaterSystem(String value) {
        this.waterSystem = value;
    }

}
