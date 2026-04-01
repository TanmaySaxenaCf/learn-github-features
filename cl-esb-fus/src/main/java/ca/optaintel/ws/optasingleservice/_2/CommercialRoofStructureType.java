
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialRoofStructureType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialRoofStructureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Open (no roof)"/>
 *     &lt;enumeration value="Wood Frame"/>
 *     &lt;enumeration value="Light Gauge Steel Frame"/>
 *     &lt;enumeration value="Steel Joists"/>
 *     &lt;enumeration value="Pre-engineered Metal Building"/>
 *     &lt;enumeration value="Suspended Concrete"/>
 *     &lt;enumeration value="Wood Frame"/>
 *     &lt;enumeration value="Exposed Wood Beam"/>
 *     &lt;enumeration value="Wood Pole Frame"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialRoofStructureType")
@XmlEnum
public enum CommercialRoofStructureType {

    @XmlEnumValue("Open (no roof)")
    OPEN_NO_ROOF("Open (no roof)"),
    @XmlEnumValue("Wood Frame")
    WOOD_FRAME("Wood Frame"),
    @XmlEnumValue("Light Gauge Steel Frame")
    LIGHT_GAUGE_STEEL_FRAME("Light Gauge Steel Frame"),
    @XmlEnumValue("Steel Joists")
    STEEL_JOISTS("Steel Joists"),
    @XmlEnumValue("Pre-engineered Metal Building")
    PRE_ENGINEERED_METAL_BUILDING("Pre-engineered Metal Building"),
    @XmlEnumValue("Suspended Concrete")
    SUSPENDED_CONCRETE("Suspended Concrete"),
    @XmlEnumValue("Exposed Wood Beam")
    EXPOSED_WOOD_BEAM("Exposed Wood Beam"),
    @XmlEnumValue("Wood Pole Frame")
    WOOD_POLE_FRAME("Wood Pole Frame");
    private final String value;

    CommercialRoofStructureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialRoofStructureType fromValue(String v) {
        for (CommercialRoofStructureType c: CommercialRoofStructureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
