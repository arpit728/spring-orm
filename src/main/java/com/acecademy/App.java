package com.acecademy;

import com.acecademy.dao.StudentDao;
import com.acecademy.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        System.out.println(studentDao.getStudent(1));

        Student s = new Student(16, "Mike", "Bhopal");
        studentDao.update(s);

        System.out.println(studentDao.getAllStudent());
    }
}
