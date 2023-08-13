package leetcode.toOffer01.day18_搜索与回溯5;
/*
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。



示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

 */
public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        return balanced(root);

    }

    public boolean balanced(TreeNode root){
        if(!subIsBalanced(root))
            return false;
        if(root==null)
            return true;
        if(root.left==null&&root.right==null)
            return true;
        return balanced(root.right)&&balanced(root.left);


    }

    public boolean subIsBalanced(TreeNode root){
        if(root==null)
            return true;
        int left=dfs(root.left,0);
        int right=dfs(root.right,0);
        if(Math.abs(left-right)<=1){
            return true;
        }
        return false;
    }
    public int dfs(TreeNode root,int depth){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        return Math.max(dfs(root.left,depth),dfs(root.right,depth))+1;

    }
}
