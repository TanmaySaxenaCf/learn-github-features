
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialCoverageTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialCoverageTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Building"/>
 *     &lt;enumeration value="Contents"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialCoverageTypeType")
@XmlEnum
public enum CommercialCoverageTypeType {

    @XmlEnumValue("Building")
    BUILDING("Building"),
    @XmlEnumValue("Contents")
    CONTENTS("Contents");
    private final String value;

    CommercialCoverageTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialCoverageTypeType fromValue(String v) {
        for (CommercialCoverageTypeType c: CommercialCoverageTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
