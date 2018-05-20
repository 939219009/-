package com.wym.Z;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext actx=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        SteelAxe axe= (SteelAxe) actx.getBean("steelAxe");
        SteelAxe axe1= (SteelAxe) actx.getBean("steelAxe");

      //  System.out.println(axe);//测试Scope
      //  System.out.println(axe1);// prototype 开辟两个堆

        wym waxe= (wym) actx.getBean("wym");

     //   waxe.setAxe(axe);
        waxe.useAxe();
        StoneAxe stoneAxe= (StoneAxe) actx.getBean("stone");
    //    waxe.setAxe(stoneAxe);
        waxe.useAxe();
    }
}
