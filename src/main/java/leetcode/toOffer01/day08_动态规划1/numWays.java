package leetcode.toOffer01.day08_动态规划1;

import java.util.ArrayList;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
示例 3：

输入：n = 0
输出：1
 */
public class numWays {
    //f(n-1)+f(n-2)=f(n)
    public int numWays(int n) {
        ArrayList<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(1);
        while(a.size()<n+1){
            a.add((a.get(a.size()-1)+a.get(a.size()-2))%1000000007);
        }
        return a.get(n);

    }

}
