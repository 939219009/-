package com.wym;

import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.util.*;

public class Hash {
    @Test
    public void test(){
        Hashtable<String,String> hashtable=new Hashtable<String,String>();

        hashtable.put("A","a");
        hashtable.put("B","b");
        hashtable.put("C","c");

        Collection<String> c=hashtable.values();
        for(String str:c){
            System.out.println(str);
        }
        System.out.println("--------");

        Enumeration<String> e= hashtable.keys();
        while(e.hasMoreElements()){
            String key=e.nextElement();
            System.out.println(key+":"+hashtable.get(key));
        }
        System.out.println("--------");

        Enumeration<String> et=hashtable.elements();
        while(et.hasMoreElements()){
            System.out.println(et.nextElement());
        }
        System.out.println("--------");
        Set<String> set=hashtable.keySet();
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){
            String key=iterator.next();
            System.out.println(key+":"+hashtable.get(key));
        } System.out.println("--------");

        Set<Map.Entry<String,String>> se=hashtable.entrySet();
        Iterator<Map.Entry<String,String>> iterator1=se.iterator();
        while(iterator1.hasNext()){
            Map.Entry<String,String> entity=iterator1.next();
            System.out.println(entity.getKey()+":"+entity.getValue());
        }

    }
    @Test
    public void test2(){
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("A","a");
        map.put("B","b");
        map.put("C","c");
        map.put(null,"d");

        Collection<String> c=map.values();
        for(String str:c){
            System.out.println(str);
        }
    }
    @Test
    public void test3(){
        HashMap<String,Integer>map=new HashMap<String,Integer>();
        map.put("A",100);
        map.put("B",200);
        map.put("C",500);
        map.put("D",400);

        Collection<Integer> c=map.values();
        for(Integer v:c){
            System.out.println(v);
        }
        List<Map.Entry<String,Integer>> list=new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(Map.Entry<String,Integer> m:list){
            System.out.println(m.getKey()+":"+m.getValue());
        }
    }
}
