package com.captainx.learningBackup.leetcode.toOffer01.day07_搜索与回溯2;

import com.captainx.learningBackup.leetcode.toOffer01.day06_搜索与回溯1.TreeNode;
/*
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4

   /   \

  2     7

 / \   / \

1   3 6   9
镜像输出：

     4

   /   \

  7     2

 / \   / \

9   6 3   1



示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]

 */
public class mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root!=null){
            reverse(root);
            mirrorTree(root.right);
            mirrorTree(root.left);
        }
        return root;
    }

    public TreeNode reverse(TreeNode a){
        TreeNode temp=a.right;
        a.right=a.left;
        a.left=temp;
        return a;
    }
}
