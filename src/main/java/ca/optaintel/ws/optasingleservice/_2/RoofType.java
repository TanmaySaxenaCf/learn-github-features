
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoofType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoofType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Asphalt"/>
 *     &lt;enumeration value="Clay Tile"/>
 *     &lt;enumeration value="Concrete"/>
 *     &lt;enumeration value="Copper"/>
 *     &lt;enumeration value="Rubber"/>
 *     &lt;enumeration value="Slate Tile"/>
 *     &lt;enumeration value="Steel"/>
 *     &lt;enumeration value="Tar and Gravel"/>
 *     &lt;enumeration value="Tin"/>
 *     &lt;enumeration value="Wood Shingles"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoofType")
@XmlEnum
public enum RoofType {

    @XmlEnumValue("Asphalt")
    ASPHALT("Asphalt"),
    @XmlEnumValue("Clay Tile")
    CLAY_TILE("Clay Tile"),
    @XmlEnumValue("Concrete")
    CONCRETE("Concrete"),
    @XmlEnumValue("Copper")
    COPPER("Copper"),
    @XmlEnumValue("Rubber")
    RUBBER("Rubber"),
    @XmlEnumValue("Slate Tile")
    SLATE_TILE("Slate Tile"),
    @XmlEnumValue("Steel")
    STEEL("Steel"),
    @XmlEnumValue("Tar and Gravel")
    TAR_AND_GRAVEL("Tar and Gravel"),
    @XmlEnumValue("Tin")
    TIN("Tin"),
    @XmlEnumValue("Wood Shingles")
    WOOD_SHINGLES("Wood Shingles");
    private final String value;

    RoofType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoofType fromValue(String v) {
        for (RoofType c: RoofType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
