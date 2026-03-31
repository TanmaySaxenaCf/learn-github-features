
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValuationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValuationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReplacementCost" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CostPerSquareFoot" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValuationType", propOrder = {
    "replacementCost",
    "costPerSquareFoot"
})
public class ValuationType {

    @XmlElement(name = "ReplacementCost")
    protected double replacementCost;
    @XmlElement(name = "CostPerSquareFoot")
    protected double costPerSquareFoot;

    /**
     * Gets the value of the replacementCost property.
     * 
     */
    public double getReplacementCost() {
        return replacementCost;
    }

    /**
     * Sets the value of the replacementCost property.
     * 
     */
    public void setReplacementCost(double value) {
        this.replacementCost = value;
    }

    /**
     * Gets the value of the costPerSquareFoot property.
     * 
     */
    public double getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    /**
     * Sets the value of the costPerSquareFoot property.
     * 
     */
    public void setCostPerSquareFoot(double value) {
        this.costPerSquareFoot = value;
    }

}
