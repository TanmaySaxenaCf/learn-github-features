
package ca.optaintel.ws.optasingleservice._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DwellingGradesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DwellingGradesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HydrantProtectedGrade" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}DwellingProtectedGradeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FirehallProtectedGrade" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}DwellingProtectedGradeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AllOtherAreasGrade" type="{http://www.optaintel.ca/ws/OptaSingleService/1.0}DwellingProtectedGradeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DwellingGradesType", propOrder = {
    "hydrantProtectedGrade",
    "firehallProtectedGrade",
    "allOtherAreasGrade"
})
public class DwellingGradesType {

    @XmlElement(name = "HydrantProtectedGrade")
    protected List<DwellingProtectedGradeType> hydrantProtectedGrade;
    @XmlElement(name = "FirehallProtectedGrade")
    protected List<DwellingProtectedGradeType> firehallProtectedGrade;
    @XmlElement(name = "AllOtherAreasGrade")
    protected DwellingProtectedGradeType allOtherAreasGrade;

    /**
     * Gets the value of the hydrantProtectedGrade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hydrantProtectedGrade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHydrantProtectedGrade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DwellingProtectedGradeType }
     * 
     * 
     */
    public List<DwellingProtectedGradeType> getHydrantProtectedGrade() {
        if (hydrantProtectedGrade == null) {
            hydrantProtectedGrade = new ArrayList<DwellingProtectedGradeType>();
        }
        return this.hydrantProtectedGrade;
    }

    /**
     * Gets the value of the firehallProtectedGrade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the firehallProtectedGrade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFirehallProtectedGrade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DwellingProtectedGradeType }
     * 
     * 
     */
    public List<DwellingProtectedGradeType> getFirehallProtectedGrade() {
        if (firehallProtectedGrade == null) {
            firehallProtectedGrade = new ArrayList<DwellingProtectedGradeType>();
        }
        return this.firehallProtectedGrade;
    }

    /**
     * Gets the value of the allOtherAreasGrade property.
     * 
     * @return
     *     possible object is
     *     {@link DwellingProtectedGradeType }
     *     
     */
    public DwellingProtectedGradeType getAllOtherAreasGrade() {
        return allOtherAreasGrade;
    }

    /**
     * Sets the value of the allOtherAreasGrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link DwellingProtectedGradeType }
     *     
     */
    public void setAllOtherAreasGrade(DwellingProtectedGradeType value) {
        this.allOtherAreasGrade = value;
    }

}
