package practice.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import practice.PropertyUtil;
import practice.hibernate.model.User;

import java.util.*;

public class HibernateUtil {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            initSessionFactory();
        }
        return sessionFactory;
    }

    private void initSessionFactory() {
        Configuration configuration = new Configuration();
        Properties props = new PropertyUtil().getProp();
        configuration.setProperties(props);
        configuration.addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("#########Hibernate Java Config serviceRegistry created");

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
