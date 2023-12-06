package com.captainx.learningBackup.leetcode.代码随想录.二叉树.遍历;

import java.util.ArrayList;
import java.util.List;

public class levelOrder {
    List<List<Integer>> resList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,0);
        return resList;
    }

    void dfs(TreeNode root,int deep){
        if(root==null)return;
        deep++;
        if(resList.size()<deep){
            List<Integer> tmp=new ArrayList<>();
            resList.add(tmp);
        }
        resList.get(deep-1).add(root.val);

        dfs(root.left,deep);
        dfs(root.right,deep);
    }
}
