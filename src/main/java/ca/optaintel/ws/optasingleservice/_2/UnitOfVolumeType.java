
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfVolumeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfVolumeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ImperialGallons"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfVolumeType")
@XmlEnum
public enum UnitOfVolumeType {

    @XmlEnumValue("ImperialGallons")
    IMPERIAL_GALLONS("ImperialGallons");
    private final String value;

    UnitOfVolumeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfVolumeType fromValue(String v) {
        for (UnitOfVolumeType c: UnitOfVolumeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
