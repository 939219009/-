package com.wym.A;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class Animal {
    @Before("execution(* com.wym.A.*.*(..))")
    public void bark(){
        System.out.println("bark");
    }
    @AfterReturning(pointcut="execution(* com.wym.A.Bill.go(..))",returning = "rvt")
    public void plan(Object rvt){
       System.out.println(rvt);
    }
    @AfterThrowing(pointcut="execution(* com.wym.A.Bill.go(..))",throwing = "et")
    public void ear(Throwable et){
        System.out.println(et.getMessage());
    }
    @After("execution(* com.wym.A.*.*(..))")
    public void go1(){
        System.out.println("After");
    }
    @Around("execution(* com.wym.A.*.*(..))")
    public void go2(ProceedingJoinPoint jp){
        System.out.println("Around-before");
        try {
           /* Object[] os=jp.getArgs();
            os[0]=os[0]+" 吴云明";
            jp.proceed(os)*/
            jp.proceed();//核心方法 截取导致无返回值
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Around-after");
    }
}
