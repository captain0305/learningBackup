package leetcode.toOffer01.day15_搜索与回溯4;

/*
给定一棵二叉搜索树，请找出其中第 k 大的节点的值。



示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
 */

//右中左
public class kthLargest {
    int k,res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;

    }

    void dfs(TreeNode cur) {
        if(cur == null) return;
        dfs(cur.right);
        k--;
        if(k == 0) res = cur.val;

        dfs(cur.left);


    }
}
