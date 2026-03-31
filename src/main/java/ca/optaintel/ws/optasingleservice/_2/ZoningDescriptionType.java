
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZoningDescriptionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ZoningDescriptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Agricultural"/>
 *     &lt;enumeration value="Commercial"/>
 *     &lt;enumeration value="Industrial"/>
 *     &lt;enumeration value="Mixed Use"/>
 *     &lt;enumeration value="Multi Family - Residential"/>
 *     &lt;enumeration value="Recreational"/>
 *     &lt;enumeration value="Residential"/>
 *     &lt;enumeration value="Single Family - Residential"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ZoningDescriptionType")
@XmlEnum
public enum ZoningDescriptionType {

    @XmlEnumValue("Agricultural")
    AGRICULTURAL("Agricultural"),
    @XmlEnumValue("Commercial")
    COMMERCIAL("Commercial"),
    @XmlEnumValue("Industrial")
    INDUSTRIAL("Industrial"),
    @XmlEnumValue("Mixed Use")
    MIXED_USE("Mixed Use"),
    @XmlEnumValue("Multi Family - Residential")
    MULTI_FAMILY_RESIDENTIAL("Multi Family - Residential"),
    @XmlEnumValue("Recreational")
    RECREATIONAL("Recreational"),
    @XmlEnumValue("Residential")
    RESIDENTIAL("Residential"),
    @XmlEnumValue("Single Family - Residential")
    SINGLE_FAMILY_RESIDENTIAL("Single Family - Residential"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    ZoningDescriptionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ZoningDescriptionType fromValue(String v) {
        for (ZoningDescriptionType c: ZoningDescriptionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
