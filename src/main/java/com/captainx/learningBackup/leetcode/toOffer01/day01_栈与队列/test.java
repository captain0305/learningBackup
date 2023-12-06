package com.captainx.learningBackup.leetcode.toOffer01.day01_栈与队列;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {
    //测试Deque
    @Test
    public void testDeque(){
        Deque<Integer> inStack;//双向队列
        inStack=new ArrayDeque<Integer>();
        inStack.add(1);
        System.out.println(inStack);
        inStack.add(2);//加在队列后面
        System.out.println(inStack);

        inStack.push(6);//加在队列前面
        System.out.println(inStack);
        inStack.push(3);
        System.out.println(inStack);
        Integer integer = inStack.removeLast();//删除队列最后面
        System.out.println(integer);
        System.out.println(inStack);
        Integer integer1 = inStack.remove();//删除队列最前面
        System.out.println(integer1);
        System.out.println(inStack);
    }
    @Test
    public void testDeque2(){
        Deque<Integer> inStack;//双向队列
        inStack=new ArrayDeque<Integer>();
        inStack.push(Integer.MAX_VALUE);
        inStack.push(2);
        inStack.push(1);
        System.out.println(inStack);
        System.out.println(inStack.peek());
        inStack.pop();
        System.out.println(inStack);

        Deque<Integer> inStack2;//双向队列
        inStack2=new ArrayDeque<Integer>();
        inStack2.add(Integer.MAX_VALUE);
        inStack2.add(2);
        inStack2.add(1);
        System.out.println(inStack2);
        System.out.println(inStack2.peek());
    }

    //push和pop一起用先进先出
    //remove 和add一起用是队列 removelast和add一起用等于pop和push
}
