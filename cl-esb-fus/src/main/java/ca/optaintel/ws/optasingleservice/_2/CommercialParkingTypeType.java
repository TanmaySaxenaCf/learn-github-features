
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialParkingTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialParkingTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Above Ground"/>
 *     &lt;enumeration value="Parking Garage"/>
 *     &lt;enumeration value="Underground"/>
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Attached Garage"/>
 *     &lt;enumeration value="Built-in Garage"/>
 *     &lt;enumeration value="Basement Garage"/>
 *     &lt;enumeration value="Carport"/>
 *     &lt;enumeration value="Detached Garage"/>
 *     &lt;enumeration value="Indoor Parking Unit"/>
 *     &lt;enumeration value="Outdoor Parking Unit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialParkingTypeType")
@XmlEnum
public enum CommercialParkingTypeType {

    @XmlEnumValue("Above Ground")
    ABOVE_GROUND("Above Ground"),
    @XmlEnumValue("Parking Garage")
    PARKING_GARAGE("Parking Garage"),
    @XmlEnumValue("Underground")
    UNDERGROUND("Underground"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Attached Garage")
    ATTACHED_GARAGE("Attached Garage"),
    @XmlEnumValue("Built-in Garage")
    BUILT_IN_GARAGE("Built-in Garage"),
    @XmlEnumValue("Basement Garage")
    BASEMENT_GARAGE("Basement Garage"),
    @XmlEnumValue("Carport")
    CARPORT("Carport"),
    @XmlEnumValue("Detached Garage")
    DETACHED_GARAGE("Detached Garage"),
    @XmlEnumValue("Indoor Parking Unit")
    INDOOR_PARKING_UNIT("Indoor Parking Unit"),
    @XmlEnumValue("Outdoor Parking Unit")
    OUTDOOR_PARKING_UNIT("Outdoor Parking Unit");
    private final String value;

    CommercialParkingTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialParkingTypeType fromValue(String v) {
        for (CommercialParkingTypeType c: CommercialParkingTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
