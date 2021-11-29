package practice.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import practice.hibernate.basics.Student;
import practice.hibernate.basics.HibernateUtil;
import practice.PropertyUtil;

import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public abstract class Dao<T> {
    private Class<T> genericClass;
    private SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
    public Dao(Class<T> genericClass) {
        this.genericClass=genericClass;
    }

    public T get(long id) {
        T res=null;
        try {
            //Get Session
            Session session = getCreateSession();
            //start transaction
            session.beginTransaction();
            //Save the Model object
             res = (T) session.get(genericClass,id);
            //Commit transaction
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            sessionFactory.close();
        }
        return res;
    }

    List<T> getAll() {
        //TODO
        return null;
    }

    public void save(T object) {
        try {
            //Get Session
            Session session = getCreateSession();
            //start transaction
            session.beginTransaction();
            //Save the Model object
            Object id = session.save(object);
            //Commit transaction
            session.getTransaction().commit();
            System.out.println("object "+object+" saved to "+getSchemaName()+"."+getTableName()+" as "+id);
        } catch (Exception e){
            e.printStackTrace();
            sessionFactory.close();
        }

    }

    private String getTableName() {
        return genericClass.getAnnotation(Table.class).name();
    }

    private static String getSchemaName() {
        String url=new PropertyUtil().getProperty("hibernate.connection.url").toString();
        return url.split("/")[url.split("/").length-1];
    }

    void update(T object, String[] params) {
//TODO
    }

    void delete(T object) {
//TODO
    }

    public  void closeSession(){
        sessionFactory.close();
    }

    public  List<T> findAll(){
        return findAllWhere(null);
    }
    private   List<T> findAllWhere(BiFunction<CriteriaBuilder, Root<T>, Predicate> where){

        List<T> res=new ArrayList<>();
        try {
            //Get Session
            Session session = getCreateSession();
            //start transaction
            session.beginTransaction();
            //Save the Model object
            res = session.createQuery( getQueryFindAllWhere(session,where)).getResultList();
            //Commit transaction
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            sessionFactory.close();
        }
        return res;
    }
    public  List<T> findAllWhereEqual(Map<String,Object> equalFieldMap){
        return findAllWhere(whereEqual(equalFieldMap));
    }

    private CriteriaQuery<T> getQueryFindAllWhere(Session session, BiFunction<CriteriaBuilder, Root<T>, Predicate> where) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> query = cb
                .createQuery(genericClass);
        Root<T> root = query.from(genericClass);
        query.select(root);
        if (where != null) {
            query.where(where.apply(cb, root));
        }

        return query;
    }

    private BiFunction<CriteriaBuilder, Root<T>, Predicate> whereEqual(Map<String, Object> fieldsEqual) {
        return (cb, root) -> cb.and(fieldsEqual.entrySet().stream().map(entry ->
                equal(cb, root, entry.getKey(), entry.getValue())).toArray(Predicate[]::new));
    }

    private Predicate equal(CriteriaBuilder cb, Root<T> root, String key, Object value) {
        if (value == null) {
            return cb.isNull(root.get(key));
        } else {
            return cb.equal(root.get(key), value);
        }
    }

    Session getCreateSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (Exception e) {
            e.printStackTrace();
            return sessionFactory.openSession();
        }
    }
}