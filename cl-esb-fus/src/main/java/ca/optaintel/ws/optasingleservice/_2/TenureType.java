
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TenureType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TenureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Freehold"/>
 *     &lt;enumeration value="Leasehold"/>
 *     &lt;enumeration value="Fee Simple"/>
 *     &lt;enumeration value="Easement"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TenureType")
@XmlEnum
public enum TenureType {

    @XmlEnumValue("Freehold")
    FREEHOLD("Freehold"),
    @XmlEnumValue("Leasehold")
    LEASEHOLD("Leasehold"),
    @XmlEnumValue("Fee Simple")
    FEE_SIMPLE("Fee Simple"),
    @XmlEnumValue("Easement")
    EASEMENT("Easement"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    TenureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TenureType fromValue(String v) {
        for (TenureType c: TenureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
