package com.wym;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class Linked {
    @Test
    public void test(){
        LinkedList list=new LinkedList();
//        list.add(1);
//        list.addFirst(2);
//        list.addLast(3);
//        list.add(4);
//        list.push(5);
//        list.offer(6);
//        list.offerFirst(7);
//        list.offerLast(8);
//        list.add(9);
//        //752134689
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("pop"+":"+list.pop());
        System.out.println("poll"+":"+list.poll());
        System.out.println("peek"+":"+list.peek());//返回头元素

        System.out.println("peekFirst"+":"+list.peekFirst());
        System.out.println("peekLast"+":"+list.peekLast());
        System.out.println("popFirst"+":"+list.pollFirst());
        System.out.println("pollLast"+":"+list.pollLast());

        Iterator it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
