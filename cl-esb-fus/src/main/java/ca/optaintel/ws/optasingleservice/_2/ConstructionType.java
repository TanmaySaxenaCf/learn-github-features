
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConstructionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConstructionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fire Resistive - Class 1"/>
 *     &lt;enumeration value="Masonry Non-Combustible - Class 2"/>
 *     &lt;enumeration value="Non-Combustible - Class 3"/>
 *     &lt;enumeration value="Ordinary Construction - Class 4"/>
 *     &lt;enumeration value="Brick Veneer - Class 5"/>
 *     &lt;enumeration value="Frame - Class 6"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConstructionType")
@XmlEnum
public enum ConstructionType {

    @XmlEnumValue("Fire Resistive - Class 1")
    FIRE_RESISTIVE_CLASS_1("Fire Resistive - Class 1"),
    @XmlEnumValue("Masonry Non-Combustible - Class 2")
    MASONRY_NON_COMBUSTIBLE_CLASS_2("Masonry Non-Combustible - Class 2"),
    @XmlEnumValue("Non-Combustible - Class 3")
    NON_COMBUSTIBLE_CLASS_3("Non-Combustible - Class 3"),
    @XmlEnumValue("Ordinary Construction - Class 4")
    ORDINARY_CONSTRUCTION_CLASS_4("Ordinary Construction - Class 4"),
    @XmlEnumValue("Brick Veneer - Class 5")
    BRICK_VENEER_CLASS_5("Brick Veneer - Class 5"),
    @XmlEnumValue("Frame - Class 6")
    FRAME_CLASS_6("Frame - Class 6");
    private final String value;

    ConstructionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConstructionType fromValue(String v) {
        for (ConstructionType c: ConstructionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
