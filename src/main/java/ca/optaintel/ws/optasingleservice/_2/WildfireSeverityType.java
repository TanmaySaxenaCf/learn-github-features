
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WildfireSeverityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WildfireSeverityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Low"/>
 *     &lt;enumeration value="Medium"/>
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="Extreme"/>
 *     &lt;enumeration value="Extremely Dry"/>
 *     &lt;enumeration value="Very Dry"/>
 *     &lt;enumeration value="Dry"/>
 *     &lt;enumeration value="Slightly Dry"/>
 *     &lt;enumeration value="Medium Humidity"/>
 *     &lt;enumeration value="Slightly Humid"/>
 *     &lt;enumeration value="Humid"/>
 *     &lt;enumeration value="Very Humid"/>
 *     &lt;enumeration value="Extremely Humid"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WildfireSeverityType")
@XmlEnum
public enum WildfireSeverityType {

    @XmlEnumValue("Low")
    LOW("Low"),
    @XmlEnumValue("Medium")
    MEDIUM("Medium"),
    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("Extreme")
    EXTREME("Extreme"),
    @XmlEnumValue("Extremely Dry")
    EXTREMELY_DRY("Extremely Dry"),
    @XmlEnumValue("Very Dry")
    VERY_DRY("Very Dry"),
    @XmlEnumValue("Dry")
    DRY("Dry"),
    @XmlEnumValue("Slightly Dry")
    SLIGHTLY_DRY("Slightly Dry"),
    @XmlEnumValue("Medium Humidity")
    MEDIUM_HUMIDITY("Medium Humidity"),
    @XmlEnumValue("Slightly Humid")
    SLIGHTLY_HUMID("Slightly Humid"),
    @XmlEnumValue("Humid")
    HUMID("Humid"),
    @XmlEnumValue("Very Humid")
    VERY_HUMID("Very Humid"),
    @XmlEnumValue("Extremely Humid")
    EXTREMELY_HUMID("Extremely Humid");
    private final String value;

    WildfireSeverityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WildfireSeverityType fromValue(String v) {
        for (WildfireSeverityType c: WildfireSeverityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
