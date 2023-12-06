package com.captainx.learningBackup.leetcode.代码随想录.链表;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class testPopPollLast {
    @Test
    public void testDequePop(){
        Deque<Integer> a=new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        System.out.println(a.pollLast());
        System.out.println(a.pop());
    }

    @Test
    public void testStackPop(){
        Stack<Integer> a=new Stack<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        System.out.println(a.pop());
    }
}
