
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialWiringPanelTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialWiringPanelTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Circuit Breakers"/>
 *     &lt;enumeration value="Fuses"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialWiringPanelTypeType")
@XmlEnum
public enum CommercialWiringPanelTypeType {

    @XmlEnumValue("Circuit Breakers")
    CIRCUIT_BREAKERS("Circuit Breakers"),
    @XmlEnumValue("Fuses")
    FUSES("Fuses");
    private final String value;

    CommercialWiringPanelTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialWiringPanelTypeType fromValue(String v) {
        for (CommercialWiringPanelTypeType c: CommercialWiringPanelTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
