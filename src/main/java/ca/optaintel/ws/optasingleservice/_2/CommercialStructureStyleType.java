
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialStructureStyleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialStructureStyleType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="High Rise"/>
 *     &lt;enumeration value="Row"/>
 *     &lt;enumeration value="Walk Up"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialStructureStyleType")
@XmlEnum
public enum CommercialStructureStyleType {

    @XmlEnumValue("High Rise")
    HIGH_RISE("High Rise"),
    @XmlEnumValue("Row")
    ROW("Row"),
    @XmlEnumValue("Walk Up")
    WALK_UP("Walk Up");
    private final String value;

    CommercialStructureStyleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialStructureStyleType fromValue(String v) {
        for (CommercialStructureStyleType c: CommercialStructureStyleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
