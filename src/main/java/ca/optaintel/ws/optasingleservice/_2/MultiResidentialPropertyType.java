
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultiResidentialPropertyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MultiResidentialPropertyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Apartment"/>
 *     &lt;enumeration value="Condominium"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MultiResidentialPropertyType")
@XmlEnum
public enum MultiResidentialPropertyType {

    @XmlEnumValue("Apartment")
    APARTMENT("Apartment"),
    @XmlEnumValue("Condominium")
    CONDOMINIUM("Condominium");
    private final String value;

    MultiResidentialPropertyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MultiResidentialPropertyType fromValue(String v) {
        for (MultiResidentialPropertyType c: MultiResidentialPropertyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
