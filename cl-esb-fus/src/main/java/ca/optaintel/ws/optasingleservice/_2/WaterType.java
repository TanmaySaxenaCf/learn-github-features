
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WaterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WaterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Municipal"/>
 *     &lt;enumeration value="Private"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WaterType")
@XmlEnum
public enum WaterType {

    @XmlEnumValue("Municipal")
    MUNICIPAL("Municipal"),
    @XmlEnumValue("Private")
    PRIVATE("Private"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    WaterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WaterType fromValue(String v) {
        for (WaterType c: WaterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
