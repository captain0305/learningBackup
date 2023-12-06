package com.captainx.learningBackup.leetcode.toOffer01.day17_排序2;

import org.junit.Test;

import java.util.PriorityQueue;

public class testPriorityQueue {
    @Test
    public void testLambda(){
        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));//重写compare方法实现降序排列，大堆顶
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));//实现升序排列，小堆顶
        queMax.add(1);
        queMax.add(3);
        System.out.println(queMax);
        System.out.println(queMax.peek());
        queMax.add(6);
        System.out.println(queMax);
        System.out.println(queMax.peek());
        queMax.add(0);
        System.out.println(queMax);
        System.out.println(queMax.peek());
        queMax.add(-10);
        System.out.println(queMax);
        System.out.println(queMax.peek());
        queMax.poll();
        System.out.println(queMax);
        System.out.println(queMax.peek());
    }
}
