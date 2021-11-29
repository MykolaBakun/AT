package practice.hibernate.basics;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
//    `id` int(11) NOT NULL AUTO_INCREMENT,
    @Id
    private Long address_id;
//                           `county` varchar(45) DEFAULT NULL,
    private String county;
//                           `city` varchar(45) DEFAULT NULL,
    private String city;
//                           `street` varchar(45) DEFAULT NULL,
    private String street;

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

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
