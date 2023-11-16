package leetcode.toOffer01.day18_搜索与回溯5;
/*
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */
public class maxDepth {
//    int depth=0;

    public int maxDepth(TreeNode root) {
        return dfs(root,0);

    }

    public int dfs(TreeNode root,int depth){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        return Math.max(dfs(root.left,depth),dfs(root.right,depth))+1;

    }
}
