
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialHeatingTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialHeatingTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACORN Stove / Box / Franklin / Pot Belly Stove"/>
 *     &lt;enumeration value="Baseboard Heater"/>
 *     &lt;enumeration value="Bi-Energy Combination"/>
 *     &lt;enumeration value="Combined"/>
 *     &lt;enumeration value="Electric Furnace"/>
 *     &lt;enumeration value="Fireplace"/>
 *     &lt;enumeration value="Floor Furnace"/>
 *     &lt;enumeration value="Furnace (Central)"/>
 *     &lt;enumeration value="Furnace (Central) with Add-On Woodburning Unit"/>
 *     &lt;enumeration value="Geothermal"/>
 *     &lt;enumeration value="Hot Water / Steam / Boiler Unit"/>
 *     &lt;enumeration value="Pellet Stove"/>
 *     &lt;enumeration value="Radiant Ceiling"/>
 *     &lt;enumeration value="Radiant Floor"/>
 *     &lt;enumeration value="Slow Wood Burning / Air Tight Stove"/>
 *     &lt;enumeration value="Solar Panels"/>
 *     &lt;enumeration value="Solid Fuel Heating Unit"/>
 *     &lt;enumeration value="Space Heater"/>
 *     &lt;enumeration value="Wall Furnace"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Partially Unheated"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialHeatingTypeType")
@XmlEnum
public enum CommercialHeatingTypeType {

    @XmlEnumValue("ACORN Stove / Box / Franklin / Pot Belly Stove")
    ACORN_STOVE_BOX_FRANKLIN_POT_BELLY_STOVE("ACORN Stove / Box / Franklin / Pot Belly Stove"),
    @XmlEnumValue("Baseboard Heater")
    BASEBOARD_HEATER("Baseboard Heater"),
    @XmlEnumValue("Bi-Energy Combination")
    BI_ENERGY_COMBINATION("Bi-Energy Combination"),
    @XmlEnumValue("Combined")
    COMBINED("Combined"),
    @XmlEnumValue("Electric Furnace")
    ELECTRIC_FURNACE("Electric Furnace"),
    @XmlEnumValue("Fireplace")
    FIREPLACE("Fireplace"),
    @XmlEnumValue("Floor Furnace")
    FLOOR_FURNACE("Floor Furnace"),
    @XmlEnumValue("Furnace (Central)")
    FURNACE_CENTRAL("Furnace (Central)"),
    @XmlEnumValue("Furnace (Central) with Add-On Woodburning Unit")
    FURNACE_CENTRAL_WITH_ADD_ON_WOODBURNING_UNIT("Furnace (Central) with Add-On Woodburning Unit"),
    @XmlEnumValue("Geothermal")
    GEOTHERMAL("Geothermal"),
    @XmlEnumValue("Hot Water / Steam / Boiler Unit")
    HOT_WATER_STEAM_BOILER_UNIT("Hot Water / Steam / Boiler Unit"),
    @XmlEnumValue("Pellet Stove")
    PELLET_STOVE("Pellet Stove"),
    @XmlEnumValue("Radiant Ceiling")
    RADIANT_CEILING("Radiant Ceiling"),
    @XmlEnumValue("Radiant Floor")
    RADIANT_FLOOR("Radiant Floor"),
    @XmlEnumValue("Slow Wood Burning / Air Tight Stove")
    SLOW_WOOD_BURNING_AIR_TIGHT_STOVE("Slow Wood Burning / Air Tight Stove"),
    @XmlEnumValue("Solar Panels")
    SOLAR_PANELS("Solar Panels"),
    @XmlEnumValue("Solid Fuel Heating Unit")
    SOLID_FUEL_HEATING_UNIT("Solid Fuel Heating Unit"),
    @XmlEnumValue("Space Heater")
    SPACE_HEATER("Space Heater"),
    @XmlEnumValue("Wall Furnace")
    WALL_FURNACE("Wall Furnace"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Partially Unheated")
    PARTIALLY_UNHEATED("Partially Unheated"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    CommercialHeatingTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialHeatingTypeType fromValue(String v) {
        for (CommercialHeatingTypeType c: CommercialHeatingTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
