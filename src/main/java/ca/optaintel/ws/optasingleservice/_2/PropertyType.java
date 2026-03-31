
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PropertyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PropertyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Apartment"/>
 *     &lt;enumeration value="Condominium"/>
 *     &lt;enumeration value="Commercial"/>
 *     &lt;enumeration value="Residential"/>
 *     &lt;enumeration value="Industrial"/>
 *     &lt;enumeration value="Institutional"/>
 *     &lt;enumeration value="Special Purpose"/>
 *     &lt;enumeration value="Agricultural"/>
 *     &lt;enumeration value="Construction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PropertyType")
@XmlEnum
public enum PropertyType {

    @XmlEnumValue("Apartment")
    APARTMENT("Apartment"),
    @XmlEnumValue("Condominium")
    CONDOMINIUM("Condominium"),
    @XmlEnumValue("Commercial")
    COMMERCIAL("Commercial"),
    @XmlEnumValue("Residential")
    RESIDENTIAL("Residential"),
    @XmlEnumValue("Industrial")
    INDUSTRIAL("Industrial"),
    @XmlEnumValue("Institutional")
    INSTITUTIONAL("Institutional"),
    @XmlEnumValue("Special Purpose")
    SPECIAL_PURPOSE("Special Purpose"),
    @XmlEnumValue("Agricultural")
    AGRICULTURAL("Agricultural"),
    @XmlEnumValue("Construction")
    CONSTRUCTION("Construction");
    private final String value;

    PropertyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PropertyType fromValue(String v) {
        for (PropertyType c: PropertyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
