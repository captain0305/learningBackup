package leetcode.回溯算法;

import java.util.*;
/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
 */
public class subsets {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> temp=new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    void backtrack(int[] nums,int start){
        res.add(new ArrayList<>(temp));//这棵树每个节点都要记录一下
        if(start>= nums.length){
            return;
        }
        for (int i = start; i < nums.length ; i++) {
            temp.add(nums[i]);
            backtrack(nums,i+1);
            temp.removeLast();
        }

    }



}
