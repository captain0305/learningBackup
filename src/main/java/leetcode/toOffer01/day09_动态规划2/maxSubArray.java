package leetcode.toOffer01.day09_动态规划2;
/*
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。



示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

public class maxSubArray {
    //会超时用遍历的方法
    public int maxSubArray(int[] nums) {
        if(nums.length!=0) {
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int sum = nums[i];
                if (sum > max) {
                    max = sum;
                }
                for (int j = 1; j < nums.length - i; j++) {
                    sum += nums[i + j];
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            return max;
        }else {return 0;}
    }


    //假设 nums 数组的长度是 n，下标从 0 到 n−1。
    //
    //我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
    //f(i)=f(i-1)+num(i)
    public int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


}
