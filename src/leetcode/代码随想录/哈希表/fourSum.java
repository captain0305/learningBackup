package leetcode.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。



示例 1：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
 */
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // nums[i]>0且大于target不可能实现
            if (nums[i] > target&&nums[i]>0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a--剪枝
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {  // 去重a--剪枝
                continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (right > left) {
                    int sum = nums[i] + nums[left] + nums[right]+nums[j];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right],nums[j]));
                        // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }
            }




        }
        return result;
    }
}
