package com.wym;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class Buy {
    List<Goods> list;
    public Buy(){
        Cart cart=new Cart();
        list=cart.getList();
    }

    public List<Goods> buy(Goods newGoods){
        Iterator<Goods> it=list.iterator();
        boolean flag=false;
        while(it.hasNext()) {
            Goods oldGoods = (Goods) it.next();
            if (newGoods.getNo().equals(oldGoods.getNo())) {
                oldGoods.setQuantity(oldGoods.getQuantity() + newGoods.getQuantity());
                flag = true;
                break;
            }
            if (!flag) {
                list.add(newGoods);
            }
        }
        return list;
    }
    @Test
    public void test() {
        Goods g1=new Goods("牛奶","00001",10,1);
        this.buy(g1);
        Goods g2=new Goods("牛奶","00001",10,2);
        this.buy(g2);
        Goods g3=new Goods("奶牛","00002",100,2);
        this.buy(g3);
        Goods g4=new Goods("咖啡","00003",20,2);
        List<Goods> list=this.buy(g4);

        for(Goods oj : list){
            System.out.println(oj.getName()+":"+oj.getQuantity()*oj.getPrice());
        }

    }
}
