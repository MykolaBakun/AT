package practice.hibernate.basics;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
//   `id` int(11) NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer student_id;

//                           `name` varchar(45) DEFAULT NULL,
    private String name;
//                           `address` int(11) DEFAULT NULL,

    private Integer address_id;
//                           `age` int(11) DEFAULT NULL,
    private Integer age;


    public void setName(String name) {
        this.name = name;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public Integer getAge() {
        return age;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", address_id=" + address_id +
                ", age=" + age +
                '}';
    }
}
