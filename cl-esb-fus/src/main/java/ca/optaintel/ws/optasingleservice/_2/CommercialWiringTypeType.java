
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialWiringTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialWiringTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Aluminum"/>
 *     &lt;enumeration value="Copper"/>
 *     &lt;enumeration value="Knob/Tube"/>
 *     &lt;enumeration value="Metal Clad"/>
 *     &lt;enumeration value="Non-metallic Sheathed"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialWiringTypeType")
@XmlEnum
public enum CommercialWiringTypeType {

    @XmlEnumValue("Aluminum")
    ALUMINUM("Aluminum"),
    @XmlEnumValue("Copper")
    COPPER("Copper"),
    @XmlEnumValue("Knob/Tube")
    KNOB_TUBE("Knob/Tube"),
    @XmlEnumValue("Metal Clad")
    METAL_CLAD("Metal Clad"),
    @XmlEnumValue("Non-metallic Sheathed")
    NON_METALLIC_SHEATHED("Non-metallic Sheathed"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    CommercialWiringTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialWiringTypeType fromValue(String v) {
        for (CommercialWiringTypeType c: CommercialWiringTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
