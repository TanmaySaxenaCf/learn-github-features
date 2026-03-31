
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassificationTypeTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClassificationTypeTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Municipal Code"/>
 *     &lt;enumeration value="Economic Region"/>
 *     &lt;enumeration value="Dissemination Area"/>
 *     &lt;enumeration value="Dissemination Block"/>
 *     &lt;enumeration value="Census Metropolitan Area"/>
 *     &lt;enumeration value="Census Tract"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClassificationTypeTypes")
@XmlEnum
public enum ClassificationTypeTypes {

    @XmlEnumValue("Municipal Code")
    MUNICIPAL_CODE("Municipal Code"),
    @XmlEnumValue("Economic Region")
    ECONOMIC_REGION("Economic Region"),
    @XmlEnumValue("Dissemination Area")
    DISSEMINATION_AREA("Dissemination Area"),
    @XmlEnumValue("Dissemination Block")
    DISSEMINATION_BLOCK("Dissemination Block"),
    @XmlEnumValue("Census Metropolitan Area")
    CENSUS_METROPOLITAN_AREA("Census Metropolitan Area"),
    @XmlEnumValue("Census Tract")
    CENSUS_TRACT("Census Tract");
    private final String value;

    ClassificationTypeTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClassificationTypeTypes fromValue(String v) {
        for (ClassificationTypeTypes c: ClassificationTypeTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
