
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommercialFuelSourceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommercialFuelSourceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Butane"/>
 *     &lt;enumeration value="Coal"/>
 *     &lt;enumeration value="Combination - Other"/>
 *     &lt;enumeration value="Diesel"/>
 *     &lt;enumeration value="Electric"/>
 *     &lt;enumeration value="Ethanol"/>
 *     &lt;enumeration value="Grain"/>
 *     &lt;enumeration value="Kerosene"/>
 *     &lt;enumeration value="Liquified Petroleum Gas"/>
 *     &lt;enumeration value="Naphtha Gas"/>
 *     &lt;enumeration value="Natural Gas"/>
 *     &lt;enumeration value="Oil"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Other Solid Fuel"/>
 *     &lt;enumeration value="Pellet"/>
 *     &lt;enumeration value="Propane"/>
 *     &lt;enumeration value="Solar"/>
 *     &lt;enumeration value="Wind"/>
 *     &lt;enumeration value="Wood"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommercialFuelSourceType")
@XmlEnum
public enum CommercialFuelSourceType {

    @XmlEnumValue("Butane")
    BUTANE("Butane"),
    @XmlEnumValue("Coal")
    COAL("Coal"),
    @XmlEnumValue("Combination - Other")
    COMBINATION_OTHER("Combination - Other"),
    @XmlEnumValue("Diesel")
    DIESEL("Diesel"),
    @XmlEnumValue("Electric")
    ELECTRIC("Electric"),
    @XmlEnumValue("Ethanol")
    ETHANOL("Ethanol"),
    @XmlEnumValue("Grain")
    GRAIN("Grain"),
    @XmlEnumValue("Kerosene")
    KEROSENE("Kerosene"),
    @XmlEnumValue("Liquified Petroleum Gas")
    LIQUIFIED_PETROLEUM_GAS("Liquified Petroleum Gas"),
    @XmlEnumValue("Naphtha Gas")
    NAPHTHA_GAS("Naphtha Gas"),
    @XmlEnumValue("Natural Gas")
    NATURAL_GAS("Natural Gas"),
    @XmlEnumValue("Oil")
    OIL("Oil"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Other Solid Fuel")
    OTHER_SOLID_FUEL("Other Solid Fuel"),
    @XmlEnumValue("Pellet")
    PELLET("Pellet"),
    @XmlEnumValue("Propane")
    PROPANE("Propane"),
    @XmlEnumValue("Solar")
    SOLAR("Solar"),
    @XmlEnumValue("Wind")
    WIND("Wind"),
    @XmlEnumValue("Wood")
    WOOD("Wood");
    private final String value;

    CommercialFuelSourceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommercialFuelSourceType fromValue(String v) {
        for (CommercialFuelSourceType c: CommercialFuelSourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
