
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InspectionRecommendationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InspectionRecommendationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CentralHeating"/>
 *     &lt;enumeration value="Chimney"/>
 *     &lt;enumeration value="Electrical"/>
 *     &lt;enumeration value="ExternalWaterDegradation"/>
 *     &lt;enumeration value="FuelTank"/>
 *     &lt;enumeration value="FloorPad"/>
 *     &lt;enumeration value="InternalFireDamage"/>
 *     &lt;enumeration value="InternalWaterDamage"/>
 *     &lt;enumeration value="Liability"/>
 *     &lt;enumeration value="Plumbing"/>
 *     &lt;enumeration value="Plumbing"/>
 *     &lt;enumeration value="Roof"/>
 *     &lt;enumeration value="SewerBackup"/>
 *     &lt;enumeration value="Stove"/>
 *     &lt;enumeration value="SumpPump"/>
 *     &lt;enumeration value="SumpSewer"/>
 *     &lt;enumeration value="WashingMachine"/>
 *     &lt;enumeration value="WaterHeater"/>
 *     &lt;enumeration value="WaterTank"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InspectionRecommendationType")
@XmlEnum
public enum InspectionRecommendationType {

    @XmlEnumValue("CentralHeating")
    CENTRAL_HEATING("CentralHeating"),
    @XmlEnumValue("Chimney")
    CHIMNEY("Chimney"),
    @XmlEnumValue("Electrical")
    ELECTRICAL("Electrical"),
    @XmlEnumValue("ExternalWaterDegradation")
    EXTERNAL_WATER_DEGRADATION("ExternalWaterDegradation"),
    @XmlEnumValue("FuelTank")
    FUEL_TANK("FuelTank"),
    @XmlEnumValue("FloorPad")
    FLOOR_PAD("FloorPad"),
    @XmlEnumValue("InternalFireDamage")
    INTERNAL_FIRE_DAMAGE("InternalFireDamage"),
    @XmlEnumValue("InternalWaterDamage")
    INTERNAL_WATER_DAMAGE("InternalWaterDamage"),
    @XmlEnumValue("Liability")
    LIABILITY("Liability"),
    @XmlEnumValue("Plumbing")
    PLUMBING("Plumbing"),
    @XmlEnumValue("Roof")
    ROOF("Roof"),
    @XmlEnumValue("SewerBackup")
    SEWER_BACKUP("SewerBackup"),
    @XmlEnumValue("Stove")
    STOVE("Stove"),
    @XmlEnumValue("SumpPump")
    SUMP_PUMP("SumpPump"),
    @XmlEnumValue("SumpSewer")
    SUMP_SEWER("SumpSewer"),
    @XmlEnumValue("WashingMachine")
    WASHING_MACHINE("WashingMachine"),
    @XmlEnumValue("WaterHeater")
    WATER_HEATER("WaterHeater"),
    @XmlEnumValue("WaterTank")
    WATER_TANK("WaterTank");
    private final String value;

    InspectionRecommendationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InspectionRecommendationType fromValue(String v) {
        for (InspectionRecommendationType c: InspectionRecommendationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
