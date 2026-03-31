
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlumbingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlumbingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Copper"/>
 *     &lt;enumeration value="Galvanized"/>
 *     &lt;enumeration value="Iron"/>
 *     &lt;enumeration value="PVC"/>
 *     &lt;enumeration value="ABS"/>
 *     &lt;enumeration value="Pex"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlumbingType")
@XmlEnum
public enum PlumbingType {

    @XmlEnumValue("Copper")
    COPPER("Copper"),
    @XmlEnumValue("Galvanized")
    GALVANIZED("Galvanized"),
    @XmlEnumValue("Iron")
    IRON("Iron"),
    PVC("PVC"),
    ABS("ABS"),
    @XmlEnumValue("Pex")
    PEX("Pex"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    PlumbingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PlumbingType fromValue(String v) {
        for (PlumbingType c: PlumbingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
