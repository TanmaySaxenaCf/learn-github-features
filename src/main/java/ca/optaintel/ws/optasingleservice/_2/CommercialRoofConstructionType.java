
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialRoofConstructionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialRoofConstructionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Concrete"/>
 *     &lt;enumeration value="Steel Deck"/>
 *     &lt;enumeration value="Wood Joist"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialRoofConstructionType")
@XmlEnum
public enum CommercialRoofConstructionType {

    @XmlEnumValue("Concrete")
    CONCRETE("Concrete"),
    @XmlEnumValue("Steel Deck")
    STEEL_DECK("Steel Deck"),
    @XmlEnumValue("Wood Joist")
    WOOD_JOIST("Wood Joist"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    CommercialRoofConstructionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialRoofConstructionType fromValue(String v) {
        for (CommercialRoofConstructionType c: CommercialRoofConstructionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
