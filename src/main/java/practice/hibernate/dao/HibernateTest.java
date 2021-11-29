package practice.hibernate.dao;


import practice.hibernate.basics.Student;

import java.util.HashMap;
import java.util.Map;

public class HibernateTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Lisa");
        student.setAge(33);
        student.setAddress_id(1);

      // StudentDao.getInstance().save(student);
        System.out.println(StudentDao.getInstance().findAll());


        Map<String,Object> filterMap=new HashMap<>();
        filterMap.put("name","qweqwe");
        filterMap.put("age",11);

        System.out.println(StudentDao.getInstance().findAllWhereEqual(filterMap));
        //System.out.println(AddressDao.getInstance().get(1));
    }
}
