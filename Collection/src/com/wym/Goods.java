package com.wym;

import java.io.Serializable;

public class Goods implements Serializable {
    private String name;
    private String no;
    private int quantity;
    private float price;

    public Goods() {

    }

    public Goods(String name, String no, float price,int quantity) {
        this.name = name;
        this.no = no;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
