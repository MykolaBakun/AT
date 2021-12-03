package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import practice.hibernate.model.User;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static User setUser(String login, String pass) {
        User user = new User();
        user.setLogin(login);
        user.setPass(pass);
        try {
            sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //Set User
            System.out.println("User ID=" + session.save(user));
            //Commit transaction
            session.getTransaction().commit();
        }
        catch (Exception e ){ e.printStackTrace(); }
        finally {
            sessionFactory.close();
        }
        return user;
    }

    public static User getUser(Integer id) {
        User user = null;
        try {
            sessionFactory = new HibernateUtil().getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //Get User
            user = session.get(User.class, id);
            System.out.println("user = " + user.getId());


            //Commit transaction
            session.getTransaction().commit();
            //terminate session factory, otherwise program won't end

        }
        catch (Exception e ){ e.printStackTrace(); }
        finally {
            sessionFactory.close();
        }
        return user;
    }

    public static void main(String[] args) {
//        User user = setUser("adskaya_drochka","brembo1234344");
        User user = getUser(5);
        System.out.println(user.getLogin());

    }

}
