package com.acecademy.dao;

import com.acecademy.entity.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public int insert(Student student) {
        Integer res = (Integer) this.hibernateTemplate.save(student);
        return res;
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.hibernateTemplate.update(student);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
 /*       Session session = hibernateTemplate.getSessionFactory().openSession();
        Student student = session.load(Student.class, id);
        session.close();
        return student;*/
        return hibernateTemplate.load(Student.class, id);
    }

    @Override
    public List<Student> getAllStudent() {
        return hibernateTemplate.loadAll(Student.class);
    }
}
