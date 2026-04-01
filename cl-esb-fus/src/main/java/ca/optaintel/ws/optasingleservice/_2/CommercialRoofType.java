
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialRoofType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialRoofType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Open (no roof)"/>
 *     &lt;enumeration value="Flat"/>
 *     &lt;enumeration value="Gable"/>
 *     &lt;enumeration value="Hip"/>
 *     &lt;enumeration value="Gambrel"/>
 *     &lt;enumeration value="Mansard"/>
 *     &lt;enumeration value="Arched/Barrel"/>
 *     &lt;enumeration value="Clerestory"/>
 *     &lt;enumeration value="Dome"/>
 *     &lt;enumeration value="Complex"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialRoofType")
@XmlEnum
public enum CommercialRoofType {

    @XmlEnumValue("Open (no roof)")
    OPEN_NO_ROOF("Open (no roof)"),
    @XmlEnumValue("Flat")
    FLAT("Flat"),
    @XmlEnumValue("Gable")
    GABLE("Gable"),
    @XmlEnumValue("Hip")
    HIP("Hip"),
    @XmlEnumValue("Gambrel")
    GAMBREL("Gambrel"),
    @XmlEnumValue("Mansard")
    MANSARD("Mansard"),
    @XmlEnumValue("Arched/Barrel")
    ARCHED_BARREL("Arched/Barrel"),
    @XmlEnumValue("Clerestory")
    CLERESTORY("Clerestory"),
    @XmlEnumValue("Dome")
    DOME("Dome"),
    @XmlEnumValue("Complex")
    COMPLEX("Complex");
    private final String value;

    CommercialRoofType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialRoofType fromValue(String v) {
        for (CommercialRoofType c: CommercialRoofType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
