
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialRoofTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialRoofTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Flat"/>
 *     &lt;enumeration value="Pitched"/>
 *     &lt;enumeration value="Gable"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialRoofTypeType")
@XmlEnum
public enum CommercialRoofTypeType {

    @XmlEnumValue("Flat")
    FLAT("Flat"),
    @XmlEnumValue("Pitched")
    PITCHED("Pitched"),
    @XmlEnumValue("Gable")
    GABLE("Gable"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    CommercialRoofTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialRoofTypeType fromValue(String v) {
        for (CommercialRoofTypeType c: CommercialRoofTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
