
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScoreTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScoreTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HeatSeverity"/>
 *     &lt;enumeration value="DrynessSeverity"/>
 *     &lt;enumeration value="WUIZone"/>
 *     &lt;enumeration value="AreaSeverity"/>
 *     &lt;enumeration value="AreaFrequency"/>
 *     &lt;enumeration value="Fire Density (#of Fires>50ha per 1000sq.km per year for HFR Zone 1990-2020)"/>
 *     &lt;enumeration value="HomogeneousFireRegime"/>
 *     &lt;enumeration value="HazardMapZone"/>
 *     &lt;enumeration value="RelativeHumidityIndex"/>
 *     &lt;enumeration value="VegetationAdjusted"/>
 *     &lt;enumeration value="WindIndex"/>
 *     &lt;enumeration value="RiskAdjusted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScoreTypeType")
@XmlEnum
public enum ScoreTypeType {

    @XmlEnumValue("HeatSeverity")
    HEAT_SEVERITY("HeatSeverity"),
    @XmlEnumValue("DrynessSeverity")
    DRYNESS_SEVERITY("DrynessSeverity"),
    @XmlEnumValue("WUIZone")
    WUI_ZONE("WUIZone"),
    @XmlEnumValue("AreaSeverity")
    AREA_SEVERITY("AreaSeverity"),
    @XmlEnumValue("AreaFrequency")
    AREA_FREQUENCY("AreaFrequency"),
    @XmlEnumValue("Fire Density (#of Fires>50ha per 1000sq.km per year for HFR Zone 1990-2020)")
    FIRE_DENSITY_OF_FIRES_50_HA_PER_1000_SQ_KM_PER_YEAR_FOR_HFR_ZONE_1990_2020("Fire Density (#of Fires>50ha per 1000sq.km per year for HFR Zone 1990-2020)"),
    @XmlEnumValue("HomogeneousFireRegime")
    HOMOGENEOUS_FIRE_REGIME("HomogeneousFireRegime"),
    @XmlEnumValue("HazardMapZone")
    HAZARD_MAP_ZONE("HazardMapZone"),
    @XmlEnumValue("RelativeHumidityIndex")
    RELATIVE_HUMIDITY_INDEX("RelativeHumidityIndex"),
    @XmlEnumValue("VegetationAdjusted")
    VEGETATION_ADJUSTED("VegetationAdjusted"),
    @XmlEnumValue("WindIndex")
    WIND_INDEX("WindIndex"),
    @XmlEnumValue("RiskAdjusted")
    RISK_ADJUSTED("RiskAdjusted");
    private final String value;

    ScoreTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScoreTypeType fromValue(String v) {
        for (ScoreTypeType c: ScoreTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
