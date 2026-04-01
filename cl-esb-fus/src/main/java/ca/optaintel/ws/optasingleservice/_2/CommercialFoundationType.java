
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialFoundationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialFoundationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Basement"/>
 *     &lt;enumeration value="Concrete Slab with Footings"/>
 *     &lt;enumeration value="Column/Pier/Post"/>
 *     &lt;enumeration value="Earth Anchors"/>
 *     &lt;enumeration value="Shallow Basement"/>
 *     &lt;enumeration value="Crawlspace"/>
 *     &lt;enumeration value="Post and Beam"/>
 *     &lt;enumeration value="Concrete Spot Footing and Column"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialFoundationType")
@XmlEnum
public enum CommercialFoundationType {

    @XmlEnumValue("Basement")
    BASEMENT("Basement"),
    @XmlEnumValue("Concrete Slab with Footings")
    CONCRETE_SLAB_WITH_FOOTINGS("Concrete Slab with Footings"),
    @XmlEnumValue("Column/Pier/Post")
    COLUMN_PIER_POST("Column/Pier/Post"),
    @XmlEnumValue("Earth Anchors")
    EARTH_ANCHORS("Earth Anchors"),
    @XmlEnumValue("Shallow Basement")
    SHALLOW_BASEMENT("Shallow Basement"),
    @XmlEnumValue("Crawlspace")
    CRAWLSPACE("Crawlspace"),
    @XmlEnumValue("Post and Beam")
    POST_AND_BEAM("Post and Beam"),
    @XmlEnumValue("Concrete Spot Footing and Column")
    CONCRETE_SPOT_FOOTING_AND_COLUMN("Concrete Spot Footing and Column");
    private final String value;

    CommercialFoundationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialFoundationType fromValue(String v) {
        for (CommercialFoundationType c: CommercialFoundationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
