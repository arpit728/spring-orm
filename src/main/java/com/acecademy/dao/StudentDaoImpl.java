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

    @Transactional
    @Override
    public int insert(Student student) {
        Integer res = (Integer) hibernateTemplate.save(student);
        return res;
    }

    @Transactional
    @Override
    public void update(Student student) {
        hibernateTemplate.update(student);
    }

    @Transactional
    @Override
    public void upsert(Student student) {
        hibernateTemplate.saveOrUpdate(student);

    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Student getStudent(int id) {
        return hibernateTemplate.get(Student.class, id);
    }

    @Override
    public List<Student> getAllStudent() {
        return hibernateTemplate.loadAll(Student.class);
    }
}
