package com.wym.A;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

import java.awt.peer.SystemTrayPeer;

@Aspect
@Order(1)
public class Dog {
    @Before("execution(* com.wym.A.*.*(..))")
    public void mark(){
        System.out.println("Dog-mark");
    }
    @After("execution(* com.wym.A.*.*(..))")
    public void mark2(){
        System.out.println("Dog-mark2");
    }
}
