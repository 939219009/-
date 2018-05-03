package com.wym;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Goods> list=new ArrayList<Goods>();

    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }
}
