package leetcode.toOffer01.day24_数学2;

import java.util.ArrayList;
import java.util.List;

/*
0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。



示例 1：

输入: n = 5, m = 3
输出: 3
示例 2：

输入: n = 10, m = 17
输出: 2
 */
public class lastRemaining {
    public int lastRemaining(int n, int m) {
        List<Integer> a=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(i);
        }
        int pos=0;

        while (a.size()!=1){
            pos=pos+m-1;
            if(pos>=a.size()){
                pos=pos-a.size();
            }
            a.remove(pos);
        }
        int result=a.get(0);
        return result;
    }
}
