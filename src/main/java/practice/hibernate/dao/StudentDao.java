package practice.hibernate.dao;

import practice.hibernate.basics.Student;

public class StudentDao extends Dao<Student> {

    private StudentDao() {
        super(Student.class);
    }

    private static final StudentDao INSTANCE = new StudentDao();

    public static StudentDao getInstance() {
        return INSTANCE;
    }



}
