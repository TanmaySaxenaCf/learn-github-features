
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfLengthType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfLengthType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Centimetres"/>
 *     &lt;enumeration value="Metres"/>
 *     &lt;enumeration value="Kilometres"/>
 *     &lt;enumeration value="Feet"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfLengthType")
@XmlEnum
public enum UnitOfLengthType {

    @XmlEnumValue("Centimetres")
    CENTIMETRES("Centimetres"),
    @XmlEnumValue("Metres")
    METRES("Metres"),
    @XmlEnumValue("Kilometres")
    KILOMETRES("Kilometres"),
    @XmlEnumValue("Feet")
    FEET("Feet");
    private final String value;

    UnitOfLengthType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfLengthType fromValue(String v) {
        for (UnitOfLengthType c: UnitOfLengthType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
