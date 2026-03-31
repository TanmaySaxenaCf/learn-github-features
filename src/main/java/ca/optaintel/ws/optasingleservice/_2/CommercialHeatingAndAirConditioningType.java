
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialHeatingAndAirConditioningType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialHeatingAndAirConditioningType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Individual Residential Type Furnaces with AC Units"/>
 *     &lt;enumeration value="Commercial Heat / AC Forced Air System"/>
 *     &lt;enumeration value="Heat Pump - Central Heat/Cool (ducted)"/>
 *     &lt;enumeration value="Heat Pump - Individual Thru-Wall Units"/>
 *     &lt;enumeration value="Individual Res. Type Forced Air Furnaces (heat only)"/>
 *     &lt;enumeration value="Commercial Heat - Forced Air System"/>
 *     &lt;enumeration value="Boiler - Ducted System"/>
 *     &lt;enumeration value="Boiler - Hot Water with Radiators"/>
 *     &lt;enumeration value="Boiler - Steam with Radiators"/>
 *     &lt;enumeration value="Radiant Floor Heating System"/>
 *     &lt;enumeration value="Geothermal - Heating/Cooling System"/>
 *     &lt;enumeration value="Commercial Chilled Water Cooling System"/>
 *     &lt;enumeration value="Commercial Evaporative Cooling System"/>
 *     &lt;enumeration value="Radiant Tube Heaters"/>
 *     &lt;enumeration value="Ceiling Hung Space Heaters"/>
 *     &lt;enumeration value="Wall/Window AC Units"/>
 *     &lt;enumeration value="High Volume Room Cooling Units"/>
 *     &lt;enumeration value="Air Curtain"/>
 *     &lt;enumeration value="Electric Baseboard/Wall Heaters"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialHeatingAndAirConditioningType")
@XmlEnum
public enum CommercialHeatingAndAirConditioningType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Individual Residential Type Furnaces with AC Units")
    INDIVIDUAL_RESIDENTIAL_TYPE_FURNACES_WITH_AC_UNITS("Individual Residential Type Furnaces with AC Units"),
    @XmlEnumValue("Commercial Heat / AC Forced Air System")
    COMMERCIAL_HEAT_AC_FORCED_AIR_SYSTEM("Commercial Heat / AC Forced Air System"),
    @XmlEnumValue("Heat Pump - Central Heat/Cool (ducted)")
    HEAT_PUMP_CENTRAL_HEAT_COOL_DUCTED("Heat Pump - Central Heat/Cool (ducted)"),
    @XmlEnumValue("Heat Pump - Individual Thru-Wall Units")
    HEAT_PUMP_INDIVIDUAL_THRU_WALL_UNITS("Heat Pump - Individual Thru-Wall Units"),
    @XmlEnumValue("Individual Res. Type Forced Air Furnaces (heat only)")
    INDIVIDUAL_RES_TYPE_FORCED_AIR_FURNACES_HEAT_ONLY("Individual Res. Type Forced Air Furnaces (heat only)"),
    @XmlEnumValue("Commercial Heat - Forced Air System")
    COMMERCIAL_HEAT_FORCED_AIR_SYSTEM("Commercial Heat - Forced Air System"),
    @XmlEnumValue("Boiler - Ducted System")
    BOILER_DUCTED_SYSTEM("Boiler - Ducted System"),
    @XmlEnumValue("Boiler - Hot Water with Radiators")
    BOILER_HOT_WATER_WITH_RADIATORS("Boiler - Hot Water with Radiators"),
    @XmlEnumValue("Boiler - Steam with Radiators")
    BOILER_STEAM_WITH_RADIATORS("Boiler - Steam with Radiators"),
    @XmlEnumValue("Radiant Floor Heating System")
    RADIANT_FLOOR_HEATING_SYSTEM("Radiant Floor Heating System"),
    @XmlEnumValue("Geothermal - Heating/Cooling System")
    GEOTHERMAL_HEATING_COOLING_SYSTEM("Geothermal - Heating/Cooling System"),
    @XmlEnumValue("Commercial Chilled Water Cooling System")
    COMMERCIAL_CHILLED_WATER_COOLING_SYSTEM("Commercial Chilled Water Cooling System"),
    @XmlEnumValue("Commercial Evaporative Cooling System")
    COMMERCIAL_EVAPORATIVE_COOLING_SYSTEM("Commercial Evaporative Cooling System"),
    @XmlEnumValue("Radiant Tube Heaters")
    RADIANT_TUBE_HEATERS("Radiant Tube Heaters"),
    @XmlEnumValue("Ceiling Hung Space Heaters")
    CEILING_HUNG_SPACE_HEATERS("Ceiling Hung Space Heaters"),
    @XmlEnumValue("Wall/Window AC Units")
    WALL_WINDOW_AC_UNITS("Wall/Window AC Units"),
    @XmlEnumValue("High Volume Room Cooling Units")
    HIGH_VOLUME_ROOM_COOLING_UNITS("High Volume Room Cooling Units"),
    @XmlEnumValue("Air Curtain")
    AIR_CURTAIN("Air Curtain"),
    @XmlEnumValue("Electric Baseboard/Wall Heaters")
    ELECTRIC_BASEBOARD_WALL_HEATERS("Electric Baseboard/Wall Heaters");
    private final String value;

    CommercialHeatingAndAirConditioningType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialHeatingAndAirConditioningType fromValue(String v) {
        for (CommercialHeatingAndAirConditioningType c: CommercialHeatingAndAirConditioningType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
