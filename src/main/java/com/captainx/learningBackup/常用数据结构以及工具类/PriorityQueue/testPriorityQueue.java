package com.captainx.learningBackup.常用数据结构以及工具类.PriorityQueue;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class testPriorityQueue {
    @Test
    public void test1(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)->(a-b));
        minHeap.add(3);
        minHeap.add(30);
        minHeap.add(2);
        minHeap.add(7);
        System.out.println(minHeap);
        System.out.println(minHeap.peek());

    }

    @Test
    public void test2(){
        List<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);

        List<Integer> b=new ArrayList<>();
        b.addAll(a);
        for (Integer i : b) {
            System.out.println(i);
        }

    }
    @Test
    public void test3(){
        Set<Integer> a=new HashSet<>();
        a.add(1);
        a.add(3);
        a.add(5);
        Set<String> collect = a.stream().map(Object::toString).collect(Collectors.toSet());
        List<String> b=new ArrayList<>();
        b.addAll(collect);
        for (String i : b) {
            System.out.println(i);
        }

    }
}
