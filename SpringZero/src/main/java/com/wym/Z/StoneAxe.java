package com.wym.Z;

import org.springframework.stereotype.Component;

@Component(value = "stone")
public class StoneAxe implements Axe {
    public void chop() {
        System.out.println("石斧砍得慢！");
    }
}
