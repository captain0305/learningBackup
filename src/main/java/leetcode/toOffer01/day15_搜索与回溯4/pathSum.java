package leetcode.toOffer01.day15_搜索与回溯4;

import java.util.*;
/*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]


输入：root = [1,2,3], targetSum = 5
输出：[]

输入：root = [1,2], targetSum = 0
输出：[]
 */

public class pathSum {
    List<List<Integer>> result=new ArrayList<List<Integer>>();
    Deque<Integer> path=new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return result;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            result.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.removeLast();
    }
}


