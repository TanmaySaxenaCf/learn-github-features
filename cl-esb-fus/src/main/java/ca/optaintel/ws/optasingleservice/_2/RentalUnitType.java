
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RentalUnitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RentalUnitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Residential"/>
 *     &lt;enumeration value="Condo"/>
 *     &lt;enumeration value="Basement"/>
 *     &lt;enumeration value="Duplex"/>
 *     &lt;enumeration value="Triplex/Fourplex"/>
 *     &lt;enumeration value="Complete Property"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RentalUnitType")
@XmlEnum
public enum RentalUnitType {

    @XmlEnumValue("Residential")
    RESIDENTIAL("Residential"),
    @XmlEnumValue("Condo")
    CONDO("Condo"),
    @XmlEnumValue("Basement")
    BASEMENT("Basement"),
    @XmlEnumValue("Duplex")
    DUPLEX("Duplex"),
    @XmlEnumValue("Triplex/Fourplex")
    TRIPLEX_FOURPLEX("Triplex/Fourplex"),
    @XmlEnumValue("Complete Property")
    COMPLETE_PROPERTY("Complete Property");
    private final String value;

    RentalUnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RentalUnitType fromValue(String v) {
        for (RentalUnitType c: RentalUnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
