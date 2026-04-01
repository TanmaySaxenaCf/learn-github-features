
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConsentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConsentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Credit"/>
 *     &lt;enumeration value="Insurance"/>
 *     &lt;enumeration value="Privacy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ConsentType")
@XmlEnum
public enum ConsentType {

    @XmlEnumValue("Credit")
    CREDIT("Credit"),
    @XmlEnumValue("Insurance")
    INSURANCE("Insurance"),
    @XmlEnumValue("Privacy")
    PRIVACY("Privacy");
    private final String value;

    ConsentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConsentType fromValue(String v) {
        for (ConsentType c: ConsentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
