package practice.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String login;
    private String pass;

//    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId(){ return id;}
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getLogin() {
        return login;
    }
    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + "\'," +
                "pass='" + pass + "\' }";
    }
}
