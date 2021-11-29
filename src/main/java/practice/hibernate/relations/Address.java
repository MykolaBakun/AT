package practice.hibernate.relations;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id
    private Integer address_id;

    private String county;

    private String city;

    private String street;

    private Integer building_number;

    @OneToMany(mappedBy="student_id")
    private Set<Student> studentSet;

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

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
        return "Address{" +
                "address_id=" + address_id +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building_number=" + building_number +
                ", studentSet=" + studentSet +
                '}';
    }
}
