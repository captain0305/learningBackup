package com.captainx.learningBackup.leetcode.toOffer01.day01_栈与队列;
/*
    定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
//pop peek push一起用


import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> instack;
    Deque<Integer> min_stack;
    /** initialize your data structure here. */
    public MinStack() {
        instack=new ArrayDeque<Integer>();
        min_stack=new ArrayDeque<Integer>();
        min_stack.push(Integer.MAX_VALUE);
    }
    //如果空直接加入，不为空比较当前栈顶值
    public void push(int x) {
            instack.push(x);
            int min=min_stack.peek();
            if (min<=x){
                min_stack.push(min);
            }else {
                min_stack.push(x);
            }
    }

    public void pop() {
        min_stack.pop();
        instack.pop();
    }

    public int top() {
        return instack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */