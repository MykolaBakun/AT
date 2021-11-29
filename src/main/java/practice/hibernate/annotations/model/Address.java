package practice.hibernate.annotations.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "address")
@IdClass(AddressPK.class)
public class Address implements Serializable {
    private Long address_id;

    @Id
    private String county;
    @Id
    private String city;
    @Id
    private String street;
    @Id
    private Integer building_number;

    public Integer getBuilding_number() {
        return building_number;
    }

    public void setBuilding_number(Integer building_number) {
        this.building_number = building_number;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
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
}
