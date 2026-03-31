
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidentialImageryCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResidentialImageryCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Street"/>
 *     &lt;enumeration value="Satellite"/>
 *     &lt;enumeration value="StaticSatelliteHigh"/>
 *     &lt;enumeration value="StaticSatelliteLow"/>
 *     &lt;enumeration value="PanoramicStreetView"/>
 *     &lt;enumeration value="Overlay"/>
 *     &lt;enumeration value="OverlayMerged"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResidentialImageryCode")
@XmlEnum
public enum ResidentialImageryCode {

    @XmlEnumValue("Street")
    STREET("Street"),
    @XmlEnumValue("Satellite")
    SATELLITE("Satellite"),
    @XmlEnumValue("StaticSatelliteHigh")
    STATIC_SATELLITE_HIGH("StaticSatelliteHigh"),
    @XmlEnumValue("StaticSatelliteLow")
    STATIC_SATELLITE_LOW("StaticSatelliteLow"),
    @XmlEnumValue("PanoramicStreetView")
    PANORAMIC_STREET_VIEW("PanoramicStreetView"),
    @XmlEnumValue("Overlay")
    OVERLAY("Overlay"),
    @XmlEnumValue("OverlayMerged")
    OVERLAY_MERGED("OverlayMerged");
    private final String value;

    ResidentialImageryCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResidentialImageryCode fromValue(String v) {
        for (ResidentialImageryCode c: ResidentialImageryCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
