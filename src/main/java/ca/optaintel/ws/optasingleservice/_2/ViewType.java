
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ViewType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ViewType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="City"/>
 *     &lt;enumeration value="Lake"/>
 *     &lt;enumeration value="Mountain"/>
 *     &lt;enumeration value="Ocean"/>
 *     &lt;enumeration value="Residential"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ViewType")
@XmlEnum
public enum ViewType {

    @XmlEnumValue("City")
    CITY("City"),
    @XmlEnumValue("Lake")
    LAKE("Lake"),
    @XmlEnumValue("Mountain")
    MOUNTAIN("Mountain"),
    @XmlEnumValue("Ocean")
    OCEAN("Ocean"),
    @XmlEnumValue("Residential")
    RESIDENTIAL("Residential"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    ViewType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ViewType fromValue(String v) {
        for (ViewType c: ViewType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
