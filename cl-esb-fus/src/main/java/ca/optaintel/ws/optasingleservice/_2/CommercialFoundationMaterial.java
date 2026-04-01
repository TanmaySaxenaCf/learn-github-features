
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialFoundationMaterial.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialFoundationMaterial">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Concrete"/>
 *     &lt;enumeration value="Block"/>
 *     &lt;enumeration value="Brick"/>
 *     &lt;enumeration value="Stone"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialFoundationMaterial")
@XmlEnum
public enum CommercialFoundationMaterial {

    @XmlEnumValue("Concrete")
    CONCRETE("Concrete"),
    @XmlEnumValue("Block")
    BLOCK("Block"),
    @XmlEnumValue("Brick")
    BRICK("Brick"),
    @XmlEnumValue("Stone")
    STONE("Stone");
    private final String value;

    CommercialFoundationMaterial(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialFoundationMaterial fromValue(String v) {
        for (CommercialFoundationMaterial c: CommercialFoundationMaterial.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
