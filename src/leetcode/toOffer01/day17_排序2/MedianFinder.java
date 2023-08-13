package leetcode.toOffer01.day17_排序2;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianFinder {
    ArrayList<Integer> a=new ArrayList<>();
    int[] result;
    public MedianFinder() {

    }

    public void addNum(int num) {
        a.add(num);
    }

    public double findMedian() {
        int size = a.size();
        result=new int[size];
        for (int i = 0; i < size; i++) {
            if(a.get(i)!=null)
                result[i]=a.get(i);
        }
        Arrays.sort(result);
        if(size%2==1){
            return result[size/2];
        }
        return (double) (result[size/2]+result[size/2+1])/2;


    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
