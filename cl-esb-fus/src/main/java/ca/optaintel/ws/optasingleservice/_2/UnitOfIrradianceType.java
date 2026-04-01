
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfIrradianceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfIrradianceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WattsPerSquareMetre"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfIrradianceType")
@XmlEnum
public enum UnitOfIrradianceType {

    @XmlEnumValue("WattsPerSquareMetre")
    WATTS_PER_SQUARE_METRE("WattsPerSquareMetre");
    private final String value;

    UnitOfIrradianceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfIrradianceType fromValue(String v) {
        for (UnitOfIrradianceType c: UnitOfIrradianceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
