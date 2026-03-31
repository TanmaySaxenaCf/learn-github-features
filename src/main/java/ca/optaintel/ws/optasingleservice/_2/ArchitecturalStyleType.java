
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArchitecturalStyleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ArchitecturalStyleType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Detached"/>
 *     &lt;enumeration value="End Row"/>
 *     &lt;enumeration value="In Row"/>
 *     &lt;enumeration value="Semi Detached"/>
 *     &lt;enumeration value="Duplex"/>
 *     &lt;enumeration value="Triplex"/>
 *     &lt;enumeration value="Fourplex"/>
 *     &lt;enumeration value="Fiveplex"/>
 *     &lt;enumeration value="Sixplex"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ArchitecturalStyleType")
@XmlEnum
public enum ArchitecturalStyleType {

    @XmlEnumValue("Detached")
    DETACHED("Detached"),
    @XmlEnumValue("End Row")
    END_ROW("End Row"),
    @XmlEnumValue("In Row")
    IN_ROW("In Row"),
    @XmlEnumValue("Semi Detached")
    SEMI_DETACHED("Semi Detached"),
    @XmlEnumValue("Duplex")
    DUPLEX("Duplex"),
    @XmlEnumValue("Triplex")
    TRIPLEX("Triplex"),
    @XmlEnumValue("Fourplex")
    FOURPLEX("Fourplex"),
    @XmlEnumValue("Fiveplex")
    FIVEPLEX("Fiveplex"),
    @XmlEnumValue("Sixplex")
    SIXPLEX("Sixplex");
    private final String value;

    ArchitecturalStyleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ArchitecturalStyleType fromValue(String v) {
        for (ArchitecturalStyleType c: ArchitecturalStyleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
