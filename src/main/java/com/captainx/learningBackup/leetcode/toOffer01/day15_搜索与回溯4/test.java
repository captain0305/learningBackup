package com.captainx.learningBackup.leetcode.toOffer01.day15_搜索与回溯4;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
    @Test
    public void testpoll(){
        Deque a=new ArrayDeque();
        a.add(1);
        a.add(2);
        a.add(5);
        a.add(7);


        System.out.println(a);
        a.pollLast();
        System.out.println(a);
        a.poll();
        System.out.println(a);
        a.pollFirst();
        System.out.println(a);
    }
}
