
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PermitStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PermitStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Closed"/>
 *     &lt;enumeration value="Completed"/>
 *     &lt;enumeration value="Denied"/>
 *     &lt;enumeration value="Expired"/>
 *     &lt;enumeration value="In progress"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PermitStatusType")
@XmlEnum
public enum PermitStatusType {

    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Closed")
    CLOSED("Closed"),
    @XmlEnumValue("Completed")
    COMPLETED("Completed"),
    @XmlEnumValue("Denied")
    DENIED("Denied"),
    @XmlEnumValue("Expired")
    EXPIRED("Expired"),
    @XmlEnumValue("In progress")
    IN_PROGRESS("In progress"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    PermitStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PermitStatusType fromValue(String v) {
        for (PermitStatusType c: PermitStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
