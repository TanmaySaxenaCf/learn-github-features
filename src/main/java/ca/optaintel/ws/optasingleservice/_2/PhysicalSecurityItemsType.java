
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhysicalSecurityItemsType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PhysicalSecurityItemsType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bars on Windows"/>
 *     &lt;enumeration value="CCTV"/>
 *     &lt;enumeration value="Deadbolt Locks"/>
 *     &lt;enumeration value="Exterior Lighting"/>
 *     &lt;enumeration value="Fencing"/>
 *     &lt;enumeration value="Intercom"/>
 *     &lt;enumeration value="Interior Lighting"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Roof Accessibility"/>
 *     &lt;enumeration value="Watchman"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhysicalSecurityItemsType")
@XmlEnum
public enum PhysicalSecurityItemsType {

    @XmlEnumValue("Bars on Windows")
    BARS_ON_WINDOWS("Bars on Windows"),
    CCTV("CCTV"),
    @XmlEnumValue("Deadbolt Locks")
    DEADBOLT_LOCKS("Deadbolt Locks"),
    @XmlEnumValue("Exterior Lighting")
    EXTERIOR_LIGHTING("Exterior Lighting"),
    @XmlEnumValue("Fencing")
    FENCING("Fencing"),
    @XmlEnumValue("Intercom")
    INTERCOM("Intercom"),
    @XmlEnumValue("Interior Lighting")
    INTERIOR_LIGHTING("Interior Lighting"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Roof Accessibility")
    ROOF_ACCESSIBILITY("Roof Accessibility"),
    @XmlEnumValue("Watchman")
    WATCHMAN("Watchman");
    private final String value;

    PhysicalSecurityItemsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PhysicalSecurityItemsType fromValue(String v) {
        for (PhysicalSecurityItemsType c: PhysicalSecurityItemsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
