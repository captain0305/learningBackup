package leetcode.toOffer01.day08_动态规划1;

import java.util.ArrayList;

/*
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。



示例 1：

输入：n = 2
输出：1
示例 2：

输入：n = 5
输出：5
 */
public class fibonacci {
    public int fib(int n) {
        ArrayList<Integer> a=new ArrayList<>();
        a.add(0);
        a.add(1);
        while(a.size()<n){
            a.add((a.get(a.size()-1)+a.get(a.size()-2))%1000000007);
        }
        return a.get(n);
    }

    public int fib1(int n) { //递归？ 不过题目是DP,感觉打表就可以了
        int arr[] = new int[105];
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else
        {
            arr[0] = 0; arr[1] = 1;
            for(int i = 2 ; i < 101 ; i ++)
            {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
            }
            return arr[n];
        }
    }
}
