package 常用数据结构以及工具类.PriorityQueue;

import org.junit.Test;

import java.util.PriorityQueue;

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
}
