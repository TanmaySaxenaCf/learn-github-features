
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidentialImageryProvider.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResidentialImageryProvider">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ILookAbout"/>
 *     &lt;enumeration value="Google"/>
 *     &lt;enumeration value="WIES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResidentialImageryProvider")
@XmlEnum
public enum ResidentialImageryProvider {

    @XmlEnumValue("ILookAbout")
    I_LOOK_ABOUT("ILookAbout"),
    @XmlEnumValue("Google")
    GOOGLE("Google"),
    WIES("WIES");
    private final String value;

    ResidentialImageryProvider(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResidentialImageryProvider fromValue(String v) {
        for (ResidentialImageryProvider c: ResidentialImageryProvider.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
