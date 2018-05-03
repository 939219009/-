package com.wym;

import org.junit.Test;

import java.util.*;

public class ListTest {
    @Test
    public void TestList(){
        List list =new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add(2,"E");
        list.remove("E");

        Iterator it=list.iterator();

        while(it.hasNext()){
            System.out.print(it.next());
        }
        System.out.println();
        for(Object l: list){
            System.out.print(l);
        }
        System.out.println();

        ListIterator li=list.listIterator();
        while(li.hasNext()){
            System.out.print(li.next());
        }
        while(li.hasPrevious()){
            System.out.print(li.previous());
        }
        System.out.println();
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
        System.out.println();

        Object[] ob=list.toArray();
        for(int i=0;i<ob.length;i++){
            System.out.print(ob[i]);
        }
    }
    @Test
    public void TestVector(){
        Vector vector=new Vector();
        vector.add("A");
        vector.add("B");
        vector.add("C");

        Enumeration enumeration=vector.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

    }
}
