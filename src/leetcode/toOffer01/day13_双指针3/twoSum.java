package leetcode.toOffer01.day13_双指针3;
/*
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
示例 2：

输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for (int i=0,j= nums.length-1;i<j;){
            if(nums[j]>target){
                j--;
                continue;
            }
            if(nums[j]+nums[i]==target){
                result[0]=nums[i];
                result[1]=nums[j];
                break;
            } else if (nums[j]+nums[i]<target) {
                i++;
                continue;
            } else if (nums[j]+nums[i]>target) {

                j--;
                continue;
            }
        }
        return result;
    }

    //最快
    public int[] twoSum1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                break;
            }
            if (nums[l] + nums[r] < target) {
                l++;
                continue;
            }
            r--;
        }
        return new int[]{nums[l], nums[r]};
    }
}
