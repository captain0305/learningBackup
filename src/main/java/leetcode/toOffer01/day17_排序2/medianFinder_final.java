package leetcode.toOffer01.day17_排序2;

import java.util.PriorityQueue;

public class medianFinder_final {

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public medianFinder_final() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));//重写compare方法实现降序排列，大堆顶
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));//实现升序排列，小堆顶
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }




}
