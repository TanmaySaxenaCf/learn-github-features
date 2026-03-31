
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialRoofMaterialType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialRoofMaterialType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Painted Ribbed Metal"/>
 *     &lt;enumeration value="Corrugated Galvanized Metal"/>
 *     &lt;enumeration value="Painted Ribbed Metal (Pre-Eng-Mtl)"/>
 *     &lt;enumeration value="Corrugated Galvanized Metal (Pre-Eng-Mtl)"/>
 *     &lt;enumeration value="Open (no roof)"/>
 *     &lt;enumeration value="Composition - 3 Tab"/>
 *     &lt;enumeration value="Composition - Architectural"/>
 *     &lt;enumeration value="Composition - Impact Resistant"/>
 *     &lt;enumeration value="Composition - Roll Roofing"/>
 *     &lt;enumeration value="Built-up (hot mopped) with Gravel"/>
 *     &lt;enumeration value="Metal - Standing Seam"/>
 *     &lt;enumeration value="Metal - Copper"/>
 *     &lt;enumeration value="Metal - Corrugated"/>
 *     &lt;enumeration value="Metal - Tile/Shake"/>
 *     &lt;enumeration value="Tile - Clay"/>
 *     &lt;enumeration value="Tile - Concrete"/>
 *     &lt;enumeration value="Membrane - EPDM or PVC"/>
 *     &lt;enumeration value="Wood Shingles or Shakes"/>
 *     &lt;enumeration value="Slate"/>
 *     &lt;enumeration value="Sprayed Polyurethane Foam (SPF)"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialRoofMaterialType")
@XmlEnum
public enum CommercialRoofMaterialType {

    @XmlEnumValue("Painted Ribbed Metal")
    PAINTED_RIBBED_METAL("Painted Ribbed Metal"),
    @XmlEnumValue("Corrugated Galvanized Metal")
    CORRUGATED_GALVANIZED_METAL("Corrugated Galvanized Metal"),
    @XmlEnumValue("Painted Ribbed Metal (Pre-Eng-Mtl)")
    PAINTED_RIBBED_METAL_PRE_ENG_MTL("Painted Ribbed Metal (Pre-Eng-Mtl)"),
    @XmlEnumValue("Corrugated Galvanized Metal (Pre-Eng-Mtl)")
    CORRUGATED_GALVANIZED_METAL_PRE_ENG_MTL("Corrugated Galvanized Metal (Pre-Eng-Mtl)"),
    @XmlEnumValue("Open (no roof)")
    OPEN_NO_ROOF("Open (no roof)"),
    @XmlEnumValue("Composition - 3 Tab")
    COMPOSITION_3_TAB("Composition - 3 Tab"),
    @XmlEnumValue("Composition - Architectural")
    COMPOSITION_ARCHITECTURAL("Composition - Architectural"),
    @XmlEnumValue("Composition - Impact Resistant")
    COMPOSITION_IMPACT_RESISTANT("Composition - Impact Resistant"),
    @XmlEnumValue("Composition - Roll Roofing")
    COMPOSITION_ROLL_ROOFING("Composition - Roll Roofing"),
    @XmlEnumValue("Built-up (hot mopped) with Gravel")
    BUILT_UP_HOT_MOPPED_WITH_GRAVEL("Built-up (hot mopped) with Gravel"),
    @XmlEnumValue("Metal - Standing Seam")
    METAL_STANDING_SEAM("Metal - Standing Seam"),
    @XmlEnumValue("Metal - Copper")
    METAL_COPPER("Metal - Copper"),
    @XmlEnumValue("Metal - Corrugated")
    METAL_CORRUGATED("Metal - Corrugated"),
    @XmlEnumValue("Metal - Tile/Shake")
    METAL_TILE_SHAKE("Metal - Tile/Shake"),
    @XmlEnumValue("Tile - Clay")
    TILE_CLAY("Tile - Clay"),
    @XmlEnumValue("Tile - Concrete")
    TILE_CONCRETE("Tile - Concrete"),
    @XmlEnumValue("Membrane - EPDM or PVC")
    MEMBRANE_EPDM_OR_PVC("Membrane - EPDM or PVC"),
    @XmlEnumValue("Wood Shingles or Shakes")
    WOOD_SHINGLES_OR_SHAKES("Wood Shingles or Shakes"),
    @XmlEnumValue("Slate")
    SLATE("Slate"),
    @XmlEnumValue("Sprayed Polyurethane Foam (SPF)")
    SPRAYED_POLYURETHANE_FOAM_SPF("Sprayed Polyurethane Foam (SPF)");
    private final String value;

    CommercialRoofMaterialType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialRoofMaterialType fromValue(String v) {
        for (CommercialRoofMaterialType c: CommercialRoofMaterialType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
