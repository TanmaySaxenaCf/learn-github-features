
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuxiliaryHeatingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuxiliaryHeatingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fireplace"/>
 *     &lt;enumeration value="Woodstove"/>
 *     &lt;enumeration value="Wood Furnace"/>
 *     &lt;enumeration value="Pellet Stove"/>
 *     &lt;enumeration value="Electric"/>
 *     &lt;enumeration value="Heat Pump"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuxiliaryHeatingType")
@XmlEnum
public enum AuxiliaryHeatingType {

    @XmlEnumValue("Fireplace")
    FIREPLACE("Fireplace"),
    @XmlEnumValue("Woodstove")
    WOODSTOVE("Woodstove"),
    @XmlEnumValue("Wood Furnace")
    WOOD_FURNACE("Wood Furnace"),
    @XmlEnumValue("Pellet Stove")
    PELLET_STOVE("Pellet Stove"),
    @XmlEnumValue("Electric")
    ELECTRIC("Electric"),
    @XmlEnumValue("Heat Pump")
    HEAT_PUMP("Heat Pump"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    AuxiliaryHeatingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuxiliaryHeatingType fromValue(String v) {
        for (AuxiliaryHeatingType c: AuxiliaryHeatingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
