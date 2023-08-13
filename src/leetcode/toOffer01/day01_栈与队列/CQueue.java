package leetcode.toOffer01.day01_栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

Queue有一个直接子类PriorityQueue。PriorityQueue叫做优先队列，顾名思义，该队列是有序的，该队列内部是一个通过小顶堆维护的二叉树，
通过数组实现，多以在插入时会更新小顶堆，取出元素时会取出最小的值。

 */
//add和remove是队列 add和removelast是栈

public class CQueue {
    Deque<Integer> inStack;

    public CQueue() {
        inStack=new ArrayDeque<Integer>();

    }

    public void appendTail(int value) {
        inStack.add(value);//加在队列后面

    }

    public int deleteHead() {
        if (inStack.isEmpty()==false){
            int a=inStack.remove();//删除队列最前元素
            return a;
        }
        return -1;

    }

    public static void main(String[] args) {

    }
}
