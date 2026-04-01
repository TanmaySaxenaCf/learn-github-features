
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialRoofSurfaceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialRoofSurfaceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Aluminum"/>
 *     &lt;enumeration value="Asphalt Roll"/>
 *     &lt;enumeration value="Asphalt Shingles"/>
 *     &lt;enumeration value="Clay Tile"/>
 *     &lt;enumeration value="Concrete Tile"/>
 *     &lt;enumeration value="Corrugated Steel"/>
 *     &lt;enumeration value="Green Roof"/>
 *     &lt;enumeration value="Laminated Shingles"/>
 *     &lt;enumeration value="Metal Tile"/>
 *     &lt;enumeration value="Mineral Fiber Shakes"/>
 *     &lt;enumeration value="Plastic"/>
 *     &lt;enumeration value="Rubber Membrane"/>
 *     &lt;enumeration value="Slate Tile"/>
 *     &lt;enumeration value="Tar and Gravel"/>
 *     &lt;enumeration value="Wood Shingles"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialRoofSurfaceType")
@XmlEnum
public enum CommercialRoofSurfaceType {

    @XmlEnumValue("Aluminum")
    ALUMINUM("Aluminum"),
    @XmlEnumValue("Asphalt Roll")
    ASPHALT_ROLL("Asphalt Roll"),
    @XmlEnumValue("Asphalt Shingles")
    ASPHALT_SHINGLES("Asphalt Shingles"),
    @XmlEnumValue("Clay Tile")
    CLAY_TILE("Clay Tile"),
    @XmlEnumValue("Concrete Tile")
    CONCRETE_TILE("Concrete Tile"),
    @XmlEnumValue("Corrugated Steel")
    CORRUGATED_STEEL("Corrugated Steel"),
    @XmlEnumValue("Green Roof")
    GREEN_ROOF("Green Roof"),
    @XmlEnumValue("Laminated Shingles")
    LAMINATED_SHINGLES("Laminated Shingles"),
    @XmlEnumValue("Metal Tile")
    METAL_TILE("Metal Tile"),
    @XmlEnumValue("Mineral Fiber Shakes")
    MINERAL_FIBER_SHAKES("Mineral Fiber Shakes"),
    @XmlEnumValue("Plastic")
    PLASTIC("Plastic"),
    @XmlEnumValue("Rubber Membrane")
    RUBBER_MEMBRANE("Rubber Membrane"),
    @XmlEnumValue("Slate Tile")
    SLATE_TILE("Slate Tile"),
    @XmlEnumValue("Tar and Gravel")
    TAR_AND_GRAVEL("Tar and Gravel"),
    @XmlEnumValue("Wood Shingles")
    WOOD_SHINGLES("Wood Shingles"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    CommercialRoofSurfaceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialRoofSurfaceType fromValue(String v) {
        for (CommercialRoofSurfaceType c: CommercialRoofSurfaceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
