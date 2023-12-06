package com.captainx.learningBackup.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。



示例 1：

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
示例 2：

输入：n = 1, k = 1
输出：[[1]]
 */
public class combine {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1);
        return res;
    }
    void backtrack(int n,int k,int startId){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startId; i <= n-(k-path.size())+1; i++) {//列表中剩余元素（n-i） >= 所需需要的元素个数（k - path.size()）
            //剪枝

                // 做出选择
                path.add(i);
                // 更新标记

                // 进入下层回溯
                backtrack(n,k,i+1);
                // 撤销选择
                path.removeLast();//删除最后一个


        }
    }
}
