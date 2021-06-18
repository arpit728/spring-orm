package com.acecademy.experiment;

import com.acecademy.AppConfig;
import com.acecademy.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringORMDemo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        System.out.println(studentDao.getStudent(1));
        /*Student student = new Student(101, "Alice", "Delhi");
        int res = studentDao.insert(student);
        System.out.println("Insert result " + res);*/
    }
}
