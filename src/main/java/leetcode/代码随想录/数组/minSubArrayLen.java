package leetcode.代码随想录.数组;
/*
给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



示例 1：

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
示例 2：

输入：target = 4, nums = [1,4,4]
输出：1
示例 3：

输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
 */
public class minSubArrayLen {
    //暴力解法时间复杂度为o(n^2)
    public int minSubArrayLen(int target, int[] nums) {
        int res=0;
        lo:
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if(sum>=target&&res==0){
                    res=j-i+1;
                }
                if(sum>=target&&res!=0&&j-i+1<res){
                    res=j-i+1;
                }
                if(j== nums.length-1&&sum<target){
                    break lo;
                }
            }

        }
        return res;
    }
    //双指针时间复杂度为o(n)
    public int minSubArrayLen1(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int left=0;

        int sum=0;

        for ( int right=0; right < nums.length; right++) {
            sum+=nums[right];
            while (sum>=target){
                res=Math.min(res,right-left+1);
                sum-=nums[left++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;

    }
}
