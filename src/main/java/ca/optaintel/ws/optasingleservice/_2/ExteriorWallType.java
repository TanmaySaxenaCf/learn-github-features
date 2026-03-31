
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExteriorWallType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExteriorWallType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Brick"/>
 *     &lt;enumeration value="Brick Veneer"/>
 *     &lt;enumeration value="Concrete"/>
 *     &lt;enumeration value="Fibreboard"/>
 *     &lt;enumeration value="Logs"/>
 *     &lt;enumeration value="Stone"/>
 *     &lt;enumeration value="Stone Veneer"/>
 *     &lt;enumeration value="Stucco"/>
 *     &lt;enumeration value="Vinyl Siding"/>
 *     &lt;enumeration value="Wood Siding"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExteriorWallType")
@XmlEnum
public enum ExteriorWallType {

    @XmlEnumValue("Brick")
    BRICK("Brick"),
    @XmlEnumValue("Brick Veneer")
    BRICK_VENEER("Brick Veneer"),
    @XmlEnumValue("Concrete")
    CONCRETE("Concrete"),
    @XmlEnumValue("Fibreboard")
    FIBREBOARD("Fibreboard"),
    @XmlEnumValue("Logs")
    LOGS("Logs"),
    @XmlEnumValue("Stone")
    STONE("Stone"),
    @XmlEnumValue("Stone Veneer")
    STONE_VENEER("Stone Veneer"),
    @XmlEnumValue("Stucco")
    STUCCO("Stucco"),
    @XmlEnumValue("Vinyl Siding")
    VINYL_SIDING("Vinyl Siding"),
    @XmlEnumValue("Wood Siding")
    WOOD_SIDING("Wood Siding");
    private final String value;

    ExteriorWallType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExteriorWallType fromValue(String v) {
        for (ExteriorWallType c: ExteriorWallType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
