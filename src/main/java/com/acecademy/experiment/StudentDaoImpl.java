package com.acecademy.experiment;

import com.acecademy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

//@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public int insert(Student student) {
        Integer res = (Integer) hibernateTemplate.save(student);
        return res;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Student getStudent(int id) {
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        return null;
    }
}
