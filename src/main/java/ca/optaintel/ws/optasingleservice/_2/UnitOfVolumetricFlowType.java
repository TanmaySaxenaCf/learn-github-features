
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfVolumetricFlowType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfVolumetricFlowType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ImperialGallonsPerMinute"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfVolumetricFlowType")
@XmlEnum
public enum UnitOfVolumetricFlowType {

    @XmlEnumValue("ImperialGallonsPerMinute")
    IMPERIAL_GALLONS_PER_MINUTE("ImperialGallonsPerMinute");
    private final String value;

    UnitOfVolumetricFlowType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfVolumetricFlowType fromValue(String v) {
        for (UnitOfVolumetricFlowType c: UnitOfVolumetricFlowType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
