
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GarageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GarageType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Attached Garage"/>
 *     &lt;enumeration value="Built-in Garage"/>
 *     &lt;enumeration value="Basement Garage"/>
 *     &lt;enumeration value="Detached Garage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GarageType")
@XmlEnum
public enum GarageType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Attached Garage")
    ATTACHED_GARAGE("Attached Garage"),
    @XmlEnumValue("Built-in Garage")
    BUILT_IN_GARAGE("Built-in Garage"),
    @XmlEnumValue("Basement Garage")
    BASEMENT_GARAGE("Basement Garage"),
    @XmlEnumValue("Detached Garage")
    DETACHED_GARAGE("Detached Garage");
    private final String value;

    GarageType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GarageType fromValue(String v) {
        for (GarageType c: GarageType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
