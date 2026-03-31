
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfTemperatureType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfTemperatureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Celsius"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfTemperatureType")
@XmlEnum
public enum UnitOfTemperatureType {

    @XmlEnumValue("Celsius")
    CELSIUS("Celsius");
    private final String value;

    UnitOfTemperatureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfTemperatureType fromValue(String v) {
        for (UnitOfTemperatureType c: UnitOfTemperatureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
