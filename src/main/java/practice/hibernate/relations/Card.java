package practice.hibernate.relations;

import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    private Integer card_id;

@OneToOne
@MapsId
@JoinColumn(name = "student_id")
    private Student student;

//            `code` varchar(45) DEFAULT NULL,
private String code;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", code='" + code + '\'' +
                '}';
    }
}
