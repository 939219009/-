package com.wym.B;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        JavaCourse teacher;
        BeanFactory beanFactory=
                new ClassPathXmlApplicationContext("beans1.xml");
        teacher= (JavaCourse) beanFactory.getBean("java");

        teacher.JavaCourse();

        Student s= (Student) beanFactory.getBean("student");
        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getAge());
    }
}
