package leetcode.代码随想录.栈与队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。



示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
 */
public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> queue=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        int id=0;
        for (int i = 0; i < nums.length-k+1; i++) {
            while (id<i+k){
                if(!queue.isEmpty()&&id>=k&&queue.peekFirst() == nums[id - k])//i-k为滑窗的第一个元素
                    queue.removeFirst();

                while (!queue.isEmpty()&&queue.peekLast()<nums[id]) {
                    queue.removeLast();
                }
                queue.addLast(nums[id]);
                id++;

            }
            res[i]=queue.peekFirst();
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        Deque<Integer> queue=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        int id=0;
        for (int i = 0; i < nums.length-k+1; i++) {
            int[] ints = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(ints);
            res[i]=ints[ints.length-1];

        }
        return res;
    }
}
