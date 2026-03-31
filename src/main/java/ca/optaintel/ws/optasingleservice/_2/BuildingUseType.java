
package ca.optaintel.ws.optasingleservice._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BuildingUseType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BuildingUseType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Auto Dealership / Showroom"/>
 *     &lt;enumeration value="Apartment / Condominium"/>
 *     &lt;enumeration value="Apmt / Condo (High-Rise)"/>
 *     &lt;enumeration value="Apmt / Condo - Luxury (High Rise)"/>
 *     &lt;enumeration value="Apmt / Condo (High-Rise) - Shell"/>
 *     &lt;enumeration value="Apmt / Condo (Low-Rise)"/>
 *     &lt;enumeration value="Apmt / Condo (Low-Rise, Pre-1950)"/>
 *     &lt;enumeration value="Garage - Auto Service / Repair Shop"/>
 *     &lt;enumeration value="Arcade / Video Game Building"/>
 *     &lt;enumeration value="Bowling Alley"/>
 *     &lt;enumeration value="Bar / Tavern"/>
 *     &lt;enumeration value="Bed and Breakfast Inn"/>
 *     &lt;enumeration value="Bank"/>
 *     &lt;enumeration value="Bus Terminal"/>
 *     &lt;enumeration value="Casino - Small"/>
 *     &lt;enumeration value="Church – Contemporary / Traditional"/>
 *     &lt;enumeration value="Auditorium / Banquet Hall"/>
 *     &lt;enumeration value="Club / Community Center"/>
 *     &lt;enumeration value="Club - Health / Fitness Center"/>
 *     &lt;enumeration value="Apmt / Condo - Deluxe"/>
 *     &lt;enumeration value="Community Recreation Center"/>
 *     &lt;enumeration value="Courthouse"/>
 *     &lt;enumeration value="Concert Hall"/>
 *     &lt;enumeration value="Car Wash"/>
 *     &lt;enumeration value="Day Care Center"/>
 *     &lt;enumeration value="Dormitory"/>
 *     &lt;enumeration value="Drycleaner"/>
 *     &lt;enumeration value="Dance Studio / Karate Dojo"/>
 *     &lt;enumeration value="Fire Station"/>
 *     &lt;enumeration value="Funeral Home"/>
 *     &lt;enumeration value="Store - Furniture Showroom"/>
 *     &lt;enumeration value="Group Care Home"/>
 *     &lt;enumeration value="Garage - Mini Lube"/>
 *     &lt;enumeration value="Parking - Multi-Level Structure"/>
 *     &lt;enumeration value="Gymnasium / Indoor Court"/>
 *     &lt;enumeration value="Hotel"/>
 *     &lt;enumeration value="Indoor Ice Skating Rink"/>
 *     &lt;enumeration value="Library"/>
 *     &lt;enumeration value="Large Manufacturing Plant"/>
 *     &lt;enumeration value="Laundromat"/>
 *     &lt;enumeration value="Shopping Center - Indoor Mall"/>
 *     &lt;enumeration value="Manufacturing Plant"/>
 *     &lt;enumeration value="Shopping Center - Outdoor Strip Mall"/>
 *     &lt;enumeration value="Lodging - Motel"/>
 *     &lt;enumeration value="Movie Theater"/>
 *     &lt;enumeration value="Museum"/>
 *     &lt;enumeration value="Nursing Home / Retirement Home"/>
 *     &lt;enumeration value="Office - Dental Clinic"/>
 *     &lt;enumeration value="Office - Medical"/>
 *     &lt;enumeration value="Office"/>
 *     &lt;enumeration value="Post Office"/>
 *     &lt;enumeration value="Swimming Pool - Indoor"/>
 *     &lt;enumeration value="Print Shop / Copy Center"/>
 *     &lt;enumeration value="Police Station / Jail"/>
 *     &lt;enumeration value="Retail - Beauty Salon / Barber Shop"/>
 *     &lt;enumeration value="Restaurant"/>
 *     &lt;enumeration value="Restaurant – Fast Food"/>
 *     &lt;enumeration value="Indoor Roller Skating Rink"/>
 *     &lt;enumeration value="Elementary / Trade School"/>
 *     &lt;enumeration value="High School"/>
 *     &lt;enumeration value="Store - Mixed Retail with Residential Units"/>
 *     &lt;enumeration value="Store - Department"/>
 *     &lt;enumeration value="Store - Retail"/>
 *     &lt;enumeration value="Store - Mixed Retail with Office Units"/>
 *     &lt;enumeration value="Surgical Center"/>
 *     &lt;enumeration value="University"/>
 *     &lt;enumeration value="Veterinary / Animal Clinic"/>
 *     &lt;enumeration value="Warehouse - Distribution"/>
 *     &lt;enumeration value="Warehouse - Commercial"/>
 *     &lt;enumeration value="Warehouse - Shop / Storage / Misc"/>
 *     &lt;enumeration value="Warehouse - Refrigerated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BuildingUseType")
@XmlEnum
public enum BuildingUseType {

    @XmlEnumValue("Auto Dealership / Showroom")
    AUTO_DEALERSHIP_SHOWROOM("Auto Dealership / Showroom"),
    @XmlEnumValue("Apartment / Condominium")
    APARTMENT_CONDOMINIUM("Apartment / Condominium"),
    @XmlEnumValue("Apmt / Condo (High-Rise)")
    APMT_CONDO_HIGH_RISE("Apmt / Condo (High-Rise)"),
    @XmlEnumValue("Apmt / Condo - Luxury (High Rise)")
    APMT_CONDO_LUXURY_HIGH_RISE("Apmt / Condo - Luxury (High Rise)"),
    @XmlEnumValue("Apmt / Condo (High-Rise) - Shell")
    APMT_CONDO_HIGH_RISE_SHELL("Apmt / Condo (High-Rise) - Shell"),
    @XmlEnumValue("Apmt / Condo (Low-Rise)")
    APMT_CONDO_LOW_RISE("Apmt / Condo (Low-Rise)"),
    @XmlEnumValue("Apmt / Condo (Low-Rise, Pre-1950)")
    APMT_CONDO_LOW_RISE_PRE_1950("Apmt / Condo (Low-Rise, Pre-1950)"),
    @XmlEnumValue("Garage - Auto Service / Repair Shop")
    GARAGE_AUTO_SERVICE_REPAIR_SHOP("Garage - Auto Service / Repair Shop"),
    @XmlEnumValue("Arcade / Video Game Building")
    ARCADE_VIDEO_GAME_BUILDING("Arcade / Video Game Building"),
    @XmlEnumValue("Bowling Alley")
    BOWLING_ALLEY("Bowling Alley"),
    @XmlEnumValue("Bar / Tavern")
    BAR_TAVERN("Bar / Tavern"),
    @XmlEnumValue("Bed and Breakfast Inn")
    BED_AND_BREAKFAST_INN("Bed and Breakfast Inn"),
    @XmlEnumValue("Bank")
    BANK("Bank"),
    @XmlEnumValue("Bus Terminal")
    BUS_TERMINAL("Bus Terminal"),
    @XmlEnumValue("Casino - Small")
    CASINO_SMALL("Casino - Small"),
    @XmlEnumValue("Church \u2013 Contemporary / Traditional")
    CHURCH_CONTEMPORARY_TRADITIONAL("Church \u2013 Contemporary / Traditional"),
    @XmlEnumValue("Auditorium / Banquet Hall")
    AUDITORIUM_BANQUET_HALL("Auditorium / Banquet Hall"),
    @XmlEnumValue("Club / Community Center")
    CLUB_COMMUNITY_CENTER("Club / Community Center"),
    @XmlEnumValue("Club - Health / Fitness Center")
    CLUB_HEALTH_FITNESS_CENTER("Club - Health / Fitness Center"),
    @XmlEnumValue("Apmt / Condo - Deluxe")
    APMT_CONDO_DELUXE("Apmt / Condo - Deluxe"),
    @XmlEnumValue("Community Recreation Center")
    COMMUNITY_RECREATION_CENTER("Community Recreation Center"),
    @XmlEnumValue("Courthouse")
    COURTHOUSE("Courthouse"),
    @XmlEnumValue("Concert Hall")
    CONCERT_HALL("Concert Hall"),
    @XmlEnumValue("Car Wash")
    CAR_WASH("Car Wash"),
    @XmlEnumValue("Day Care Center")
    DAY_CARE_CENTER("Day Care Center"),
    @XmlEnumValue("Dormitory")
    DORMITORY("Dormitory"),
    @XmlEnumValue("Drycleaner")
    DRYCLEANER("Drycleaner"),
    @XmlEnumValue("Dance Studio / Karate Dojo")
    DANCE_STUDIO_KARATE_DOJO("Dance Studio / Karate Dojo"),
    @XmlEnumValue("Fire Station")
    FIRE_STATION("Fire Station"),
    @XmlEnumValue("Funeral Home")
    FUNERAL_HOME("Funeral Home"),
    @XmlEnumValue("Store - Furniture Showroom")
    STORE_FURNITURE_SHOWROOM("Store - Furniture Showroom"),
    @XmlEnumValue("Group Care Home")
    GROUP_CARE_HOME("Group Care Home"),
    @XmlEnumValue("Garage - Mini Lube")
    GARAGE_MINI_LUBE("Garage - Mini Lube"),
    @XmlEnumValue("Parking - Multi-Level Structure")
    PARKING_MULTI_LEVEL_STRUCTURE("Parking - Multi-Level Structure"),
    @XmlEnumValue("Gymnasium / Indoor Court")
    GYMNASIUM_INDOOR_COURT("Gymnasium / Indoor Court"),
    @XmlEnumValue("Hotel")
    HOTEL("Hotel"),
    @XmlEnumValue("Indoor Ice Skating Rink")
    INDOOR_ICE_SKATING_RINK("Indoor Ice Skating Rink"),
    @XmlEnumValue("Library")
    LIBRARY("Library"),
    @XmlEnumValue("Large Manufacturing Plant")
    LARGE_MANUFACTURING_PLANT("Large Manufacturing Plant"),
    @XmlEnumValue("Laundromat")
    LAUNDROMAT("Laundromat"),
    @XmlEnumValue("Shopping Center - Indoor Mall")
    SHOPPING_CENTER_INDOOR_MALL("Shopping Center - Indoor Mall"),
    @XmlEnumValue("Manufacturing Plant")
    MANUFACTURING_PLANT("Manufacturing Plant"),
    @XmlEnumValue("Shopping Center - Outdoor Strip Mall")
    SHOPPING_CENTER_OUTDOOR_STRIP_MALL("Shopping Center - Outdoor Strip Mall"),
    @XmlEnumValue("Lodging - Motel")
    LODGING_MOTEL("Lodging - Motel"),
    @XmlEnumValue("Movie Theater")
    MOVIE_THEATER("Movie Theater"),
    @XmlEnumValue("Museum")
    MUSEUM("Museum"),
    @XmlEnumValue("Nursing Home / Retirement Home")
    NURSING_HOME_RETIREMENT_HOME("Nursing Home / Retirement Home"),
    @XmlEnumValue("Office - Dental Clinic")
    OFFICE_DENTAL_CLINIC("Office - Dental Clinic"),
    @XmlEnumValue("Office - Medical")
    OFFICE_MEDICAL("Office - Medical"),
    @XmlEnumValue("Office")
    OFFICE("Office"),
    @XmlEnumValue("Post Office")
    POST_OFFICE("Post Office"),
    @XmlEnumValue("Swimming Pool - Indoor")
    SWIMMING_POOL_INDOOR("Swimming Pool - Indoor"),
    @XmlEnumValue("Print Shop / Copy Center")
    PRINT_SHOP_COPY_CENTER("Print Shop / Copy Center"),
    @XmlEnumValue("Police Station / Jail")
    POLICE_STATION_JAIL("Police Station / Jail"),
    @XmlEnumValue("Retail - Beauty Salon / Barber Shop")
    RETAIL_BEAUTY_SALON_BARBER_SHOP("Retail - Beauty Salon / Barber Shop"),
    @XmlEnumValue("Restaurant")
    RESTAURANT("Restaurant"),
    @XmlEnumValue("Restaurant \u2013 Fast Food")
    RESTAURANT_FAST_FOOD("Restaurant \u2013 Fast Food"),
    @XmlEnumValue("Indoor Roller Skating Rink")
    INDOOR_ROLLER_SKATING_RINK("Indoor Roller Skating Rink"),
    @XmlEnumValue("Elementary / Trade School")
    ELEMENTARY_TRADE_SCHOOL("Elementary / Trade School"),
    @XmlEnumValue("High School")
    HIGH_SCHOOL("High School"),
    @XmlEnumValue("Store - Mixed Retail with Residential Units")
    STORE_MIXED_RETAIL_WITH_RESIDENTIAL_UNITS("Store - Mixed Retail with Residential Units"),
    @XmlEnumValue("Store - Department")
    STORE_DEPARTMENT("Store - Department"),
    @XmlEnumValue("Store - Retail")
    STORE_RETAIL("Store - Retail"),
    @XmlEnumValue("Store - Mixed Retail with Office Units")
    STORE_MIXED_RETAIL_WITH_OFFICE_UNITS("Store - Mixed Retail with Office Units"),
    @XmlEnumValue("Surgical Center")
    SURGICAL_CENTER("Surgical Center"),
    @XmlEnumValue("University")
    UNIVERSITY("University"),
    @XmlEnumValue("Veterinary / Animal Clinic")
    VETERINARY_ANIMAL_CLINIC("Veterinary / Animal Clinic"),
    @XmlEnumValue("Warehouse - Distribution")
    WAREHOUSE_DISTRIBUTION("Warehouse - Distribution"),
    @XmlEnumValue("Warehouse - Commercial")
    WAREHOUSE_COMMERCIAL("Warehouse - Commercial"),
    @XmlEnumValue("Warehouse - Shop / Storage / Misc")
    WAREHOUSE_SHOP_STORAGE_MISC("Warehouse - Shop / Storage / Misc"),
    @XmlEnumValue("Warehouse - Refrigerated")
    WAREHOUSE_REFRIGERATED("Warehouse - Refrigerated");
    private final String value;

    BuildingUseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BuildingUseType fromValue(String v) {
        for (BuildingUseType c: BuildingUseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
