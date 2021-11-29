package practice.hibernate.annotations.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {
//   `id` int(11) NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//                           `name` varchar(45) DEFAULT NULL,
    private String name;
//                           `address` int(11) DEFAULT NULL,

    private Integer address;
//                           `age` int(11) DEFAULT NULL,
    private Integer age;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAddress() {
        return address;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", age=" + age +
                '}';
    }
}
