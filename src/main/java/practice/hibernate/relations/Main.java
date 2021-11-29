package practice.hibernate.relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory=null;
        try {
            //Get Session
             sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            //start transaction
            session.beginTransaction();
            //Save the Model object
            System.out.println(session.get(Address.class, 1));
            //Commit transaction
            session.getTransaction().commit();
        }catch (Exception e){e.printStackTrace();}
        finally {
        //terminate session factory, otherwise program won't end
        sessionFactory.close();}

    }
}
