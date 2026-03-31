
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryRoofClassType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AerialImageryRoofClassType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Shingle"/>
 *     &lt;enumeration value="Tile"/>
 *     &lt;enumeration value="Metal"/>
 *     &lt;enumeration value="Shake"/>
 *     &lt;enumeration value="Gravel"/>
 *     &lt;enumeration value="Membrane"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AerialImageryRoofClassType")
@XmlEnum
public enum AerialImageryRoofClassType {

    @XmlEnumValue("Shingle")
    SHINGLE("Shingle"),
    @XmlEnumValue("Tile")
    TILE("Tile"),
    @XmlEnumValue("Metal")
    METAL("Metal"),
    @XmlEnumValue("Shake")
    SHAKE("Shake"),
    @XmlEnumValue("Gravel")
    GRAVEL("Gravel"),
    @XmlEnumValue("Membrane")
    MEMBRANE("Membrane");
    private final String value;

    AerialImageryRoofClassType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AerialImageryRoofClassType fromValue(String v) {
        for (AerialImageryRoofClassType c: AerialImageryRoofClassType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
