package com.wym;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    @Test
    public void test(){
        Set<String> set=new HashSet<String>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");

        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


    }
}
