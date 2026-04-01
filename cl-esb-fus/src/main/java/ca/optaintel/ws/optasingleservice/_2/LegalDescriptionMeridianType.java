
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LegalDescriptionMeridianType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LegalDescriptionMeridianType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="W1"/>
 *     &lt;enumeration value="W2"/>
 *     &lt;enumeration value="W3"/>
 *     &lt;enumeration value="W4"/>
 *     &lt;enumeration value="W5"/>
 *     &lt;enumeration value="W6"/>
 *     &lt;enumeration value="W7"/>
 *     &lt;enumeration value="E1"/>
 *     &lt;enumeration value="E2"/>
 *     &lt;enumeration value="Coast"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LegalDescriptionMeridianType")
@XmlEnum
public enum LegalDescriptionMeridianType {

    @XmlEnumValue("W1")
    W_1("W1"),
    @XmlEnumValue("W2")
    W_2("W2"),
    @XmlEnumValue("W3")
    W_3("W3"),
    @XmlEnumValue("W4")
    W_4("W4"),
    @XmlEnumValue("W5")
    W_5("W5"),
    @XmlEnumValue("W6")
    W_6("W6"),
    @XmlEnumValue("W7")
    W_7("W7"),
    @XmlEnumValue("E1")
    E_1("E1"),
    @XmlEnumValue("E2")
    E_2("E2"),
    @XmlEnumValue("Coast")
    COAST("Coast");
    private final String value;

    LegalDescriptionMeridianType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LegalDescriptionMeridianType fromValue(String v) {
        for (LegalDescriptionMeridianType c: LegalDescriptionMeridianType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
