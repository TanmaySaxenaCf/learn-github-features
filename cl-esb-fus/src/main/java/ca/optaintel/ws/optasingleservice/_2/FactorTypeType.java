
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FactorTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FactorTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Slope"/>
 *     &lt;enumeration value="Lightning"/>
 *     &lt;enumeration value="WildfireNumber"/>
 *     &lt;enumeration value="WildfireAreaBurned"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FactorTypeType")
@XmlEnum
public enum FactorTypeType {

    @XmlEnumValue("Slope")
    SLOPE("Slope"),
    @XmlEnumValue("Lightning")
    LIGHTNING("Lightning"),
    @XmlEnumValue("WildfireNumber")
    WILDFIRE_NUMBER("WildfireNumber"),
    @XmlEnumValue("WildfireAreaBurned")
    WILDFIRE_AREA_BURNED("WildfireAreaBurned");
    private final String value;

    FactorTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FactorTypeType fromValue(String v) {
        for (FactorTypeType c: FactorTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
