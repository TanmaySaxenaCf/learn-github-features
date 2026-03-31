
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialExteriorWallFinishType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialExteriorWallFinishType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Painted Ribbed Metal"/>
 *     &lt;enumeration value="Corrugated Galvanized Metal"/>
 *     &lt;enumeration value="Painted Ribbed Metal (Pre-Eng-Mtl)"/>
 *     &lt;enumeration value="Corrugated Galvanized Metal (Pre-Eng-Mtl)"/>
 *     &lt;enumeration value="Bare Concrete Block Walls Only"/>
 *     &lt;enumeration value="Bare Structural (Giant) Brick Walls Only"/>
 *     &lt;enumeration value="Bare Decorative Block Walls Only"/>
 *     &lt;enumeration value="No Finish - Bare Supporting Walls"/>
 *     &lt;enumeration value="Brick Veneer"/>
 *     &lt;enumeration value="Stucco - Synthetic (EIFS)"/>
 *     &lt;enumeration value="Stucco - Traditional Hard Coat"/>
 *     &lt;enumeration value="Stone Veneer (Natural)"/>
 *     &lt;enumeration value="Stone Veneer (Manufactured)"/>
 *     &lt;enumeration value="Painted Masonry"/>
 *     &lt;enumeration value="Siding - Vinyl"/>
 *     &lt;enumeration value="Siding - Aluminum or Metal"/>
 *     &lt;enumeration value="Siding - Fiber-Cement"/>
 *     &lt;enumeration value="Siding - Pine"/>
 *     &lt;enumeration value="Siding - Cedar"/>
 *     &lt;enumeration value="Siding - Redwood"/>
 *     &lt;enumeration value="Siding - Plywood"/>
 *     &lt;enumeration value="Siding - Log"/>
 *     &lt;enumeration value="Wood Shingle/Shake"/>
 *     &lt;enumeration value="Hardboard/Masonite/Asbestos"/>
 *     &lt;enumeration value="Bare Solid Logs"/>
 *     &lt;enumeration value="Stained and Sealed Solid Logs"/>
 *     &lt;enumeration value="Glass"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialExteriorWallFinishType")
@XmlEnum
public enum CommercialExteriorWallFinishType {

    @XmlEnumValue("Painted Ribbed Metal")
    PAINTED_RIBBED_METAL("Painted Ribbed Metal"),
    @XmlEnumValue("Corrugated Galvanized Metal")
    CORRUGATED_GALVANIZED_METAL("Corrugated Galvanized Metal"),
    @XmlEnumValue("Painted Ribbed Metal (Pre-Eng-Mtl)")
    PAINTED_RIBBED_METAL_PRE_ENG_MTL("Painted Ribbed Metal (Pre-Eng-Mtl)"),
    @XmlEnumValue("Corrugated Galvanized Metal (Pre-Eng-Mtl)")
    CORRUGATED_GALVANIZED_METAL_PRE_ENG_MTL("Corrugated Galvanized Metal (Pre-Eng-Mtl)"),
    @XmlEnumValue("Bare Concrete Block Walls Only")
    BARE_CONCRETE_BLOCK_WALLS_ONLY("Bare Concrete Block Walls Only"),
    @XmlEnumValue("Bare Structural (Giant) Brick Walls Only")
    BARE_STRUCTURAL_GIANT_BRICK_WALLS_ONLY("Bare Structural (Giant) Brick Walls Only"),
    @XmlEnumValue("Bare Decorative Block Walls Only")
    BARE_DECORATIVE_BLOCK_WALLS_ONLY("Bare Decorative Block Walls Only"),
    @XmlEnumValue("No Finish - Bare Supporting Walls")
    NO_FINISH_BARE_SUPPORTING_WALLS("No Finish - Bare Supporting Walls"),
    @XmlEnumValue("Brick Veneer")
    BRICK_VENEER("Brick Veneer"),
    @XmlEnumValue("Stucco - Synthetic (EIFS)")
    STUCCO_SYNTHETIC_EIFS("Stucco - Synthetic (EIFS)"),
    @XmlEnumValue("Stucco - Traditional Hard Coat")
    STUCCO_TRADITIONAL_HARD_COAT("Stucco - Traditional Hard Coat"),
    @XmlEnumValue("Stone Veneer (Natural)")
    STONE_VENEER_NATURAL("Stone Veneer (Natural)"),
    @XmlEnumValue("Stone Veneer (Manufactured)")
    STONE_VENEER_MANUFACTURED("Stone Veneer (Manufactured)"),
    @XmlEnumValue("Painted Masonry")
    PAINTED_MASONRY("Painted Masonry"),
    @XmlEnumValue("Siding - Vinyl")
    SIDING_VINYL("Siding - Vinyl"),
    @XmlEnumValue("Siding - Aluminum or Metal")
    SIDING_ALUMINUM_OR_METAL("Siding - Aluminum or Metal"),
    @XmlEnumValue("Siding - Fiber-Cement")
    SIDING_FIBER_CEMENT("Siding - Fiber-Cement"),
    @XmlEnumValue("Siding - Pine")
    SIDING_PINE("Siding - Pine"),
    @XmlEnumValue("Siding - Cedar")
    SIDING_CEDAR("Siding - Cedar"),
    @XmlEnumValue("Siding - Redwood")
    SIDING_REDWOOD("Siding - Redwood"),
    @XmlEnumValue("Siding - Plywood")
    SIDING_PLYWOOD("Siding - Plywood"),
    @XmlEnumValue("Siding - Log")
    SIDING_LOG("Siding - Log"),
    @XmlEnumValue("Wood Shingle/Shake")
    WOOD_SHINGLE_SHAKE("Wood Shingle/Shake"),
    @XmlEnumValue("Hardboard/Masonite/Asbestos")
    HARDBOARD_MASONITE_ASBESTOS("Hardboard/Masonite/Asbestos"),
    @XmlEnumValue("Bare Solid Logs")
    BARE_SOLID_LOGS("Bare Solid Logs"),
    @XmlEnumValue("Stained and Sealed Solid Logs")
    STAINED_AND_SEALED_SOLID_LOGS("Stained and Sealed Solid Logs"),
    @XmlEnumValue("Glass")
    GLASS("Glass");
    private final String value;

    CommercialExteriorWallFinishType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialExteriorWallFinishType fromValue(String v) {
        for (CommercialExteriorWallFinishType c: CommercialExteriorWallFinishType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
