package leetcode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]
 */
public class permute {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited=new boolean[nums.length];
        Arrays.fill(visited,false);
        backtrack(nums,0);
        return res;

    }

    void backtrack(int[] nums,int start){

        if(temp.size()== nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(visited[i]==false) {
                temp.add(nums[i]);
                visited[i]=true;
                backtrack(nums, i + 1);
                temp.removeLast();
                visited[i]=false;
            }

        }

    }
}
