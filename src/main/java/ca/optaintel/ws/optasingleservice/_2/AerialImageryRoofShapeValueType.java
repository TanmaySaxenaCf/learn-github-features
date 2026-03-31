
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AerialImageryRoofShapeValueType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AerialImageryRoofShapeValueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Hip"/>
 *     &lt;enumeration value="Gable"/>
 *     &lt;enumeration value="Flat"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AerialImageryRoofShapeValueType")
@XmlEnum
public enum AerialImageryRoofShapeValueType {

    @XmlEnumValue("Hip")
    HIP("Hip"),
    @XmlEnumValue("Gable")
    GABLE("Gable"),
    @XmlEnumValue("Flat")
    FLAT("Flat");
    private final String value;

    AerialImageryRoofShapeValueType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AerialImageryRoofShapeValueType fromValue(String v) {
        for (AerialImageryRoofShapeValueType c: AerialImageryRoofShapeValueType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
