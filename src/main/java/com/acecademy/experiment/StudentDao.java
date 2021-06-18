package com.acecademy.experiment;

import com.acecademy.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;


public interface StudentDao {

    int insert(Student student);

    int update(Student student);

    int delete(int id);

    Student getStudent(int id);

    List<Student> getAllStudent();
}
