package com.captainx.learningBackup.leetcode.toOffer01.day04_查找算法;

import java.util.HashMap;

/*
统计一个数字在排序数组中出现的次数。



示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 */
public class searchNum {
    public int search(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                Integer integer = map.get(nums[i]);
                map.replace(nums[i],integer+1);
            }else {
                map.put(nums[i],1);
            }
        }


        if(map.containsKey(target)){
            return map.get(target);
        }else {
            return 0;
        }
    }

    //最快
    public int search1(int[] nums, int target) {
        int res= 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == target) res++;
        }
        return res;
    }
}
