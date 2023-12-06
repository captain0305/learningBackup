package com.captainx.learningBackup.leetcode.toOffer01.day07_搜索与回溯2;

/*请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1

   / \

  2   2

 / \ / \

3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1

   / \

  2   2

   \   \

   3    3



示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false

 */

import com.captainx.learningBackup.leetcode.toOffer01.day06_搜索与回溯1.TreeNode;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
       return isSubStructure(cloneTree(root),mirrorTree(root));
    }
    public TreeNode cloneTree(TreeNode root){
        if (root!=null){
            TreeNode treeNode = addNode(root);
            treeNode.right=cloneTree(root.right);
            treeNode.left=cloneTree(root.left);
            return treeNode;
        }
        return null;
    }

    public TreeNode addNode(TreeNode node) {
        TreeNode new_node=new TreeNode(node.val);
        return new_node;
    }


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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null||A==null&&B==null)&&(recur(A,B));
    }
    //用于判断当前A节点往下是否对应结构
    public boolean recur(TreeNode A,TreeNode B){
        if(B==null)return true;
        if(A==null||A.val!=B.val)return false;
        return recur(A.left, B.left)&&recur(A.right,B.right);
    }
}
