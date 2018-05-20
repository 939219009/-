package com.wym.A;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
    public static void main(String[] args) {
        BeanFactory bf=
                new ClassPathXmlApplicationContext("beans.xml");

        JavaCource jc= (JavaCource) bf.getBean("java");
        jc.JavaCource();
    }
}
