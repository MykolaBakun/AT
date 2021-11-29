package practice.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Lisa");
        student.setAge(1);
        student.setAddress_id(1);

        //Get Session
        SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        System.out.println("student ID="+session.save(student));
        //Commit transaction
        session.getTransaction().commit();

        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
}
