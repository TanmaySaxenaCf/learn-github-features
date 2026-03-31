
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialPlumbingTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialPlumbingTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ABS"/>
 *     &lt;enumeration value="Copper"/>
 *     &lt;enumeration value="Galvanized"/>
 *     &lt;enumeration value="Lead"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="PEX"/>
 *     &lt;enumeration value="Plastic"/>
 *     &lt;enumeration value="POLY-B"/>
 *     &lt;enumeration value="PVC"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialPlumbingTypeType")
@XmlEnum
public enum CommercialPlumbingTypeType {

    ABS("ABS"),
    @XmlEnumValue("Copper")
    COPPER("Copper"),
    @XmlEnumValue("Galvanized")
    GALVANIZED("Galvanized"),
    @XmlEnumValue("Lead")
    LEAD("Lead"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    PEX("PEX"),
    @XmlEnumValue("Plastic")
    PLASTIC("Plastic"),
    @XmlEnumValue("POLY-B")
    POLY_B("POLY-B"),
    PVC("PVC"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    CommercialPlumbingTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialPlumbingTypeType fromValue(String v) {
        for (CommercialPlumbingTypeType c: CommercialPlumbingTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
