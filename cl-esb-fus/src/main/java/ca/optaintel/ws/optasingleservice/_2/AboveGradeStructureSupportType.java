
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AboveGradeStructureSupportType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AboveGradeStructureSupportType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Conventional Wood"/>
 *     &lt;enumeration value="Light Gauge Steel"/>
 *     &lt;enumeration value="Pole and Post"/>
 *     &lt;enumeration value="Structural Insulated Panels (SIPs)"/>
 *     &lt;enumeration value="Masonry - Concrete Block (CMU)"/>
 *     &lt;enumeration value="Masonry - Structural (Giant) Brick"/>
 *     &lt;enumeration value="Masonry - Decorative Block"/>
 *     &lt;enumeration value="Masonry - Double Wythe Solid Brick"/>
 *     &lt;enumeration value="Masonry - Triple Wythe Solid Brick"/>
 *     &lt;enumeration value="Steel Column and Beam with No Wall System"/>
 *     &lt;enumeration value="Steel Column and Beam with Metal Studs or Wood Frame"/>
 *     &lt;enumeration value="Steel Column and Beam with Masonry Block (CMU)"/>
 *     &lt;enumeration value="Steel Column and Beam with Decorative Block"/>
 *     &lt;enumeration value="Steel Column and Beam with Structural (Giant) Brick"/>
 *     &lt;enumeration value="Steel Column and Beam with Glass Curtain Walls"/>
 *     &lt;enumeration value="Steel Column and Beam with Insulated Metal Panels"/>
 *     &lt;enumeration value="Steel Column and Beam with Concrete Panels on Metal Studs"/>
 *     &lt;enumeration value="Concrete Post and Beam with No Wall System"/>
 *     &lt;enumeration value="Concrete Post and Beam with Metal or Wood Studs"/>
 *     &lt;enumeration value="Concrete Post and Beam with Masonry Block (CMU)"/>
 *     &lt;enumeration value="Concrete Post and Beam with Decorative Block"/>
 *     &lt;enumeration value="Concrete Post and Beam with Structural (Giant) Brick"/>
 *     &lt;enumeration value="Concrete Post and Beam with Glass In-Fill Panels"/>
 *     &lt;enumeration value="Concrete Post and Beam with Insulated Metal Panels"/>
 *     &lt;enumeration value="Concrete Post and Beam with Concrete Panels on Metal Studs"/>
 *     &lt;enumeration value="Pre-engineered Metal"/>
 *     &lt;enumeration value="Concrete Tilt-wall"/>
 *     &lt;enumeration value="Concrete - Poured Wall"/>
 *     &lt;enumeration value="Wood Framed - Solid Logs"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AboveGradeStructureSupportType")
@XmlEnum
public enum AboveGradeStructureSupportType {

    @XmlEnumValue("Conventional Wood")
    CONVENTIONAL_WOOD("Conventional Wood"),
    @XmlEnumValue("Light Gauge Steel")
    LIGHT_GAUGE_STEEL("Light Gauge Steel"),
    @XmlEnumValue("Pole and Post")
    POLE_AND_POST("Pole and Post"),
    @XmlEnumValue("Structural Insulated Panels (SIPs)")
    STRUCTURAL_INSULATED_PANELS_SI_PS("Structural Insulated Panels (SIPs)"),
    @XmlEnumValue("Masonry - Concrete Block (CMU)")
    MASONRY_CONCRETE_BLOCK_CMU("Masonry - Concrete Block (CMU)"),
    @XmlEnumValue("Masonry - Structural (Giant) Brick")
    MASONRY_STRUCTURAL_GIANT_BRICK("Masonry - Structural (Giant) Brick"),
    @XmlEnumValue("Masonry - Decorative Block")
    MASONRY_DECORATIVE_BLOCK("Masonry - Decorative Block"),
    @XmlEnumValue("Masonry - Double Wythe Solid Brick")
    MASONRY_DOUBLE_WYTHE_SOLID_BRICK("Masonry - Double Wythe Solid Brick"),
    @XmlEnumValue("Masonry - Triple Wythe Solid Brick")
    MASONRY_TRIPLE_WYTHE_SOLID_BRICK("Masonry - Triple Wythe Solid Brick"),
    @XmlEnumValue("Steel Column and Beam with No Wall System")
    STEEL_COLUMN_AND_BEAM_WITH_NO_WALL_SYSTEM("Steel Column and Beam with No Wall System"),
    @XmlEnumValue("Steel Column and Beam with Metal Studs or Wood Frame")
    STEEL_COLUMN_AND_BEAM_WITH_METAL_STUDS_OR_WOOD_FRAME("Steel Column and Beam with Metal Studs or Wood Frame"),
    @XmlEnumValue("Steel Column and Beam with Masonry Block (CMU)")
    STEEL_COLUMN_AND_BEAM_WITH_MASONRY_BLOCK_CMU("Steel Column and Beam with Masonry Block (CMU)"),
    @XmlEnumValue("Steel Column and Beam with Decorative Block")
    STEEL_COLUMN_AND_BEAM_WITH_DECORATIVE_BLOCK("Steel Column and Beam with Decorative Block"),
    @XmlEnumValue("Steel Column and Beam with Structural (Giant) Brick")
    STEEL_COLUMN_AND_BEAM_WITH_STRUCTURAL_GIANT_BRICK("Steel Column and Beam with Structural (Giant) Brick"),
    @XmlEnumValue("Steel Column and Beam with Glass Curtain Walls")
    STEEL_COLUMN_AND_BEAM_WITH_GLASS_CURTAIN_WALLS("Steel Column and Beam with Glass Curtain Walls"),
    @XmlEnumValue("Steel Column and Beam with Insulated Metal Panels")
    STEEL_COLUMN_AND_BEAM_WITH_INSULATED_METAL_PANELS("Steel Column and Beam with Insulated Metal Panels"),
    @XmlEnumValue("Steel Column and Beam with Concrete Panels on Metal Studs")
    STEEL_COLUMN_AND_BEAM_WITH_CONCRETE_PANELS_ON_METAL_STUDS("Steel Column and Beam with Concrete Panels on Metal Studs"),
    @XmlEnumValue("Concrete Post and Beam with No Wall System")
    CONCRETE_POST_AND_BEAM_WITH_NO_WALL_SYSTEM("Concrete Post and Beam with No Wall System"),
    @XmlEnumValue("Concrete Post and Beam with Metal or Wood Studs")
    CONCRETE_POST_AND_BEAM_WITH_METAL_OR_WOOD_STUDS("Concrete Post and Beam with Metal or Wood Studs"),
    @XmlEnumValue("Concrete Post and Beam with Masonry Block (CMU)")
    CONCRETE_POST_AND_BEAM_WITH_MASONRY_BLOCK_CMU("Concrete Post and Beam with Masonry Block (CMU)"),
    @XmlEnumValue("Concrete Post and Beam with Decorative Block")
    CONCRETE_POST_AND_BEAM_WITH_DECORATIVE_BLOCK("Concrete Post and Beam with Decorative Block"),
    @XmlEnumValue("Concrete Post and Beam with Structural (Giant) Brick")
    CONCRETE_POST_AND_BEAM_WITH_STRUCTURAL_GIANT_BRICK("Concrete Post and Beam with Structural (Giant) Brick"),
    @XmlEnumValue("Concrete Post and Beam with Glass In-Fill Panels")
    CONCRETE_POST_AND_BEAM_WITH_GLASS_IN_FILL_PANELS("Concrete Post and Beam with Glass In-Fill Panels"),
    @XmlEnumValue("Concrete Post and Beam with Insulated Metal Panels")
    CONCRETE_POST_AND_BEAM_WITH_INSULATED_METAL_PANELS("Concrete Post and Beam with Insulated Metal Panels"),
    @XmlEnumValue("Concrete Post and Beam with Concrete Panels on Metal Studs")
    CONCRETE_POST_AND_BEAM_WITH_CONCRETE_PANELS_ON_METAL_STUDS("Concrete Post and Beam with Concrete Panels on Metal Studs"),
    @XmlEnumValue("Pre-engineered Metal")
    PRE_ENGINEERED_METAL("Pre-engineered Metal"),
    @XmlEnumValue("Concrete Tilt-wall")
    CONCRETE_TILT_WALL("Concrete Tilt-wall"),
    @XmlEnumValue("Concrete - Poured Wall")
    CONCRETE_POURED_WALL("Concrete - Poured Wall"),
    @XmlEnumValue("Wood Framed - Solid Logs")
    WOOD_FRAMED_SOLID_LOGS("Wood Framed - Solid Logs");
    private final String value;

    AboveGradeStructureSupportType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AboveGradeStructureSupportType fromValue(String v) {
        for (AboveGradeStructureSupportType c: AboveGradeStructureSupportType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
