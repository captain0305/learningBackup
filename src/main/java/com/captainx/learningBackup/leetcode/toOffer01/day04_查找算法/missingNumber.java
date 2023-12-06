package com.captainx.learningBackup.leetcode.toOffer01.day04_查找算法;

import java.util.HashMap;

/*
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。



示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8
 */
public class missingNumber {
    public int missingNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int n=nums.length+1;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
        }
        for(int i=0;i<=nums.length;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }
        return 0;
    }
    //最快
    public int missingNumber1(int[] nums) {
        int i;
        for(i = 0;i < nums.length; i++){
            if(i != nums[i]){
                return i;
            }
        }
        return i;
    }


}
