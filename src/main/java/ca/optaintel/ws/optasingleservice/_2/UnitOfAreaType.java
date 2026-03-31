
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfAreaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfAreaType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SquareFeet"/>
 *     &lt;enumeration value="SquareMetres"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfAreaType")
@XmlEnum
public enum UnitOfAreaType {

    @XmlEnumValue("SquareFeet")
    SQUARE_FEET("SquareFeet"),
    @XmlEnumValue("SquareMetres")
    SQUARE_METRES("SquareMetres");
    private final String value;

    UnitOfAreaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfAreaType fromValue(String v) {
        for (UnitOfAreaType c: UnitOfAreaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
