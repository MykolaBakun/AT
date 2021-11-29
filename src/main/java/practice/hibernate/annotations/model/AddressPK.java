package practice.hibernate.annotations.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AddressPK implements Serializable {

    private String county;

    private String city;

    private String street;

    private Integer building_number;

    public Integer getBuilding_number() {
        return building_number;
    }

    public void setBuilding_number(Integer building_number) {
        this.building_number = building_number;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "AddressPK{" +
                "county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building_number=" + building_number +
                '}';
    }
}
