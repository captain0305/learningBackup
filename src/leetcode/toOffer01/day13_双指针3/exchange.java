package leetcode.toOffer01.day13_双指针3;

import java.util.ArrayDeque;
import java.util.Deque;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。



示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
 */
public class exchange {
    public int[] exchange(int[] nums) {
        Deque<Integer> a=new ArrayDeque();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==1){
                a.addFirst(nums[i]);
            }else {
                a.addLast(nums[i]);
            }
        }
        int[] ints = a.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }
    //最快
    public int[] exchange1(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++) {
            if (nums[i] % 2 == 0) {//左指针，找到不合法的数据往后面丢就好了，右指针不用主动去搜索偶数
                int c = nums[j];
                nums[j--] = nums[i];//j左移
                nums[i--] = c;//原有的i位置不确保是奇数  ，需要再次检查
            }
        }
        return nums;
    }
}
