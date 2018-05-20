package com.wym.A;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext app=
                new ClassPathXmlApplicationContext("applicationContext.xml");
         Bill bill=(Bill)app.getBean("bill");
         bill.eat();
         bill.go("wym");
    }
}
