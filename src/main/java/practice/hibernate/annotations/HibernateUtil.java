package practice.hibernate.annotations;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import practice.PropertyUtil;
import practice.hibernate.annotations.model.Address;
import practice.hibernate.annotations.model.AddressPK;
import practice.hibernate.annotations.model.Student;

import java.util.Properties;

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

        //Create Properties, can be read from property files too
        Properties props = new PropertyUtil().getProp();
        configuration.setProperties(props);

        //we can set mapping file or class with annotation
        //addClass(Employee1.class) will look for resource
        // com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(AddressPK.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Java Config serviceRegistry created");

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
