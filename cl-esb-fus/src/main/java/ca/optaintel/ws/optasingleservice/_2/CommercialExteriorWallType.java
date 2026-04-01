
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialExteriorWallType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialExteriorWallType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Aggregate"/>
 *     &lt;enumeration value="Aluminum"/>
 *     &lt;enumeration value="Aluminum Siding"/>
 *     &lt;enumeration value="Brick"/>
 *     &lt;enumeration value="Brick / Masonry Veneer"/>
 *     &lt;enumeration value="Ceramic"/>
 *     &lt;enumeration value="Concrete"/>
 *     &lt;enumeration value="Concrete Block"/>
 *     &lt;enumeration value="Glass"/>
 *     &lt;enumeration value="Metal"/>
 *     &lt;enumeration value="Metal Siding"/>
 *     &lt;enumeration value="Steel"/>
 *     &lt;enumeration value="Stone"/>
 *     &lt;enumeration value="Stucco"/>
 *     &lt;enumeration value="Vinyl Siding"/>
 *     &lt;enumeration value="Wood"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialExteriorWallType")
@XmlEnum
public enum CommercialExteriorWallType {

    @XmlEnumValue("Aggregate")
    AGGREGATE("Aggregate"),
    @XmlEnumValue("Aluminum")
    ALUMINUM("Aluminum"),
    @XmlEnumValue("Aluminum Siding")
    ALUMINUM_SIDING("Aluminum Siding"),
    @XmlEnumValue("Brick")
    BRICK("Brick"),
    @XmlEnumValue("Brick / Masonry Veneer")
    BRICK_MASONRY_VENEER("Brick / Masonry Veneer"),
    @XmlEnumValue("Ceramic")
    CERAMIC("Ceramic"),
    @XmlEnumValue("Concrete")
    CONCRETE("Concrete"),
    @XmlEnumValue("Concrete Block")
    CONCRETE_BLOCK("Concrete Block"),
    @XmlEnumValue("Glass")
    GLASS("Glass"),
    @XmlEnumValue("Metal")
    METAL("Metal"),
    @XmlEnumValue("Metal Siding")
    METAL_SIDING("Metal Siding"),
    @XmlEnumValue("Steel")
    STEEL("Steel"),
    @XmlEnumValue("Stone")
    STONE("Stone"),
    @XmlEnumValue("Stucco")
    STUCCO("Stucco"),
    @XmlEnumValue("Vinyl Siding")
    VINYL_SIDING("Vinyl Siding"),
    @XmlEnumValue("Wood")
    WOOD("Wood"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    CommercialExteriorWallType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialExteriorWallType fromValue(String v) {
        for (CommercialExteriorWallType c: CommercialExteriorWallType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
