
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialInsuredTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialInsuredTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Building Owner"/>
 *     &lt;enumeration value="Tenant"/>
 *     &lt;enumeration value="Owner Occupied"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialInsuredTypeType")
@XmlEnum
public enum CommercialInsuredTypeType {

    @XmlEnumValue("Building Owner")
    BUILDING_OWNER("Building Owner"),
    @XmlEnumValue("Tenant")
    TENANT("Tenant"),
    @XmlEnumValue("Owner Occupied")
    OWNER_OCCUPIED("Owner Occupied"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    CommercialInsuredTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialInsuredTypeType fromValue(String v) {
        for (CommercialInsuredTypeType c: CommercialInsuredTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
