package com.wym.A;

import org.springframework.stereotype.Component;

@Component
public class Bill {
    public void eat(){
        System.out.println("吃瓜群众");
    }
    public String go(String name){

        System.out.println("go"+name);
       // int i=5/0;
        return name;

    }
}
