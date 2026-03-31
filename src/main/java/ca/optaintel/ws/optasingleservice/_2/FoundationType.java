
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FoundationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FoundationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Basement"/>
 *     &lt;enumeration value="Crawlspace"/>
 *     &lt;enumeration value="Pier"/>
 *     &lt;enumeration value="Slab on Grade"/>
 *     &lt;enumeration value="Walkout Basement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FoundationType")
@XmlEnum
public enum FoundationType {

    @XmlEnumValue("Basement")
    BASEMENT("Basement"),
    @XmlEnumValue("Crawlspace")
    CRAWLSPACE("Crawlspace"),
    @XmlEnumValue("Pier")
    PIER("Pier"),
    @XmlEnumValue("Slab on Grade")
    SLAB_ON_GRADE("Slab on Grade"),
    @XmlEnumValue("Walkout Basement")
    WALKOUT_BASEMENT("Walkout Basement");
    private final String value;

    FoundationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FoundationType fromValue(String v) {
        for (FoundationType c: FoundationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
