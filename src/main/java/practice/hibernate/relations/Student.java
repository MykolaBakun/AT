package practice.hibernate.relations;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer student_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "card_id")
    private Card card;

    private String name;

    @ManyToOne
    @JoinColumn(name="address_id", insertable=false, updatable=false)
    private Address address;

    private Integer age;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", card=" + card +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
