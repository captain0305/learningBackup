package leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class permuteUnique {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if(i>0&&nums[i]==nums[i-1]&&visited[i-1]==false)
                continue;
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
