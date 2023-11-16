package leetcode.toOffer01.day16_排序1;

import java.util.Arrays;

/*
从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。



示例 1:

输入: [1,2,3,4,5]
输出: True


示例 2:

输入: [0,0,1,2,5]
输出: True
 */
public class isStraight {
    public boolean isStraight(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        int countz_zero=0;
        int need_zero=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==0){
                countz_zero++;
                continue;
            }
            if(nums[i]==nums[i+1]){
                return false;
            }
            if(nums[i]+1!=nums[i+1]){
                need_zero+=(nums[i+1]-nums[i]-1);
            }
        }
        return need_zero<=countz_zero;
    }

    public boolean isStraight1(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }


}
