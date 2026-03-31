
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialWaterHeaterTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialWaterHeaterTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Combination Space-Water"/>
 *     &lt;enumeration value="Heat Pump"/>
 *     &lt;enumeration value="Solar"/>
 *     &lt;enumeration value="Storage Tank"/>
 *     &lt;enumeration value="Tankless (On-Demand)"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialWaterHeaterTypeType")
@XmlEnum
public enum CommercialWaterHeaterTypeType {

    @XmlEnumValue("Combination Space-Water")
    COMBINATION_SPACE_WATER("Combination Space-Water"),
    @XmlEnumValue("Heat Pump")
    HEAT_PUMP("Heat Pump"),
    @XmlEnumValue("Solar")
    SOLAR("Solar"),
    @XmlEnumValue("Storage Tank")
    STORAGE_TANK("Storage Tank"),
    @XmlEnumValue("Tankless (On-Demand)")
    TANKLESS_ON_DEMAND("Tankless (On-Demand)");
    private final String value;

    CommercialWaterHeaterTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialWaterHeaterTypeType fromValue(String v) {
        for (CommercialWaterHeaterTypeType c: CommercialWaterHeaterTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
