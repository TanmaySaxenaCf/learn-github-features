
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LegalDescriptionQuarterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LegalDescriptionQuarterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NW 1/4"/>
 *     &lt;enumeration value="NE 1/4"/>
 *     &lt;enumeration value="SW 1/4"/>
 *     &lt;enumeration value="SE 1/4"/>
 *     &lt;enumeration value="N 1/2"/>
 *     &lt;enumeration value="S 1/2"/>
 *     &lt;enumeration value="E 1/2"/>
 *     &lt;enumeration value="W 1/2"/>
 *     &lt;enumeration value="NW"/>
 *     &lt;enumeration value="NE"/>
 *     &lt;enumeration value="SW"/>
 *     &lt;enumeration value="SE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LegalDescriptionQuarterType")
@XmlEnum
public enum LegalDescriptionQuarterType {

    @XmlEnumValue("NW 1/4")
    NW_1_4("NW 1/4"),
    @XmlEnumValue("NE 1/4")
    NE_1_4("NE 1/4"),
    @XmlEnumValue("SW 1/4")
    SW_1_4("SW 1/4"),
    @XmlEnumValue("SE 1/4")
    SE_1_4("SE 1/4"),
    @XmlEnumValue("N 1/2")
    N_1_2("N 1/2"),
    @XmlEnumValue("S 1/2")
    S_1_2("S 1/2"),
    @XmlEnumValue("E 1/2")
    E_1_2("E 1/2"),
    @XmlEnumValue("W 1/2")
    W_1_2("W 1/2"),
    NW("NW"),
    NE("NE"),
    SW("SW"),
    SE("SE");
    private final String value;

    LegalDescriptionQuarterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LegalDescriptionQuarterType fromValue(String v) {
        for (LegalDescriptionQuarterType c: LegalDescriptionQuarterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
