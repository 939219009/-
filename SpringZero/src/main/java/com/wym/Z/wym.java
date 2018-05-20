package com.wym.Z;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class wym implements Person {
    @Autowired
   /* @Qualifier("stone")
    private Axe axe;*/
   private StoneAxe axe;
/*
    public Axe getAxe() {
        return axe;
    }
    @Resource(name="stone")//直接插入对象 Test不必再set  本人觉得 没用
    public void setAxe(Axe axe) {
        this.axe = axe;
    }
*/
    public void useAxe() {
       this.axe.chop();
    }
}
