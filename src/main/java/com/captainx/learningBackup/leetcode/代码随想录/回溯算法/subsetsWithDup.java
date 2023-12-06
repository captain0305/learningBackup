package com.captainx.learningBackup.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。



示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
 */
public class subsetsWithDup {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    boolean[] visited;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        visited=new boolean[nums.length];
        backtrack(nums,0);
        return res;
    }

    void backtrack(int[] nums,int start){
        res.add(new ArrayList<>(temp));//这棵树每个节点都要记录一下
        if(start>= nums.length){
            return;
        }
        for (int i = start; i < nums.length ; i++) {
            if(i>0&&nums[i]==nums[i-1]&&visited[i-1]==false)
                continue;
            temp.add(nums[i]);
            visited[i]=true;
            backtrack(nums,i+1);
            temp.removeLast();
            visited[i]=false;
        }

    }

}
