package com.wym.Z;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("prototype")// singleton 默认singleton 开辟一个堆
@Component
public class SteelAxe implements Axe {
    public void chop() {
        System.out.println("钢斧砍得快！");
    }
}
