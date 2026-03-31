
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceModeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ComparativeRater"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ServiceModeType")
@XmlEnum
public enum ServiceModeType {

    @XmlEnumValue("ComparativeRater")
    COMPARATIVE_RATER("ComparativeRater");
    private final String value;

    ServiceModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceModeType fromValue(String v) {
        for (ServiceModeType c: ServiceModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
