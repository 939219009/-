package com.wym.vo;

public class Animal {
     private int old;
     private String color;

    public Animal(int old, String color) {
        this.old = old;
        this.color = color;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
