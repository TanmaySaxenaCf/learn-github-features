
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CombustibilityClassCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CombustibilityClassCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="L1"/>
 *     &lt;enumeration value="L2"/>
 *     &lt;enumeration value="M3"/>
 *     &lt;enumeration value="M4"/>
 *     &lt;enumeration value="H5"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CombustibilityClassCodeType")
@XmlEnum
public enum CombustibilityClassCodeType {

    @XmlEnumValue("L1")
    L_1("L1"),
    @XmlEnumValue("L2")
    L_2("L2"),
    @XmlEnumValue("M3")
    M_3("M3"),
    @XmlEnumValue("M4")
    M_4("M4"),
    @XmlEnumValue("H5")
    H_5("H5");
    private final String value;

    CombustibilityClassCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CombustibilityClassCodeType fromValue(String v) {
        for (CombustibilityClassCodeType c: CombustibilityClassCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
