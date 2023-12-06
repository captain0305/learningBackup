package com.captainx.learningBackup.leetcode.toOffer01.day27_栈与队列2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue=new LinkedList<>();
        deque=new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty()?-1:deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty()&&deque.peekLast()<value)
            deque.removeLast();
        deque.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty())return -1;
        int ans=queue.peek();
        if(ans==deque.peekFirst()){
            deque.removeFirst();
        }
        return queue.poll();
    }
}
