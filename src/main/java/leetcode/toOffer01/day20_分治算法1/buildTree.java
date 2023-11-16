package leetcode.toOffer01.day20_分治算法1;

import java.util.HashMap;

/*
输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



示例 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
示例 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */
public class buildTree {
    int[] preorder;//保留的前序遍历，方便递归时根据索引查看前序遍历的值
    HashMap<Integer, Integer> dic = new HashMap<>();//标记中序遍历
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;//将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        //三个索引分别为
        //当前根的的索引，为前序
        //递归树的左边界，即数组左边界，为中序
        //递归树的右边界，即数组右边界，为中序
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);
        //获取在中序遍历中根节点所在索引，以方便获取左子树的数量


        //左子树的根的索引为先序中的根节点+1
        //递归左子树的左边界为原来的中序in_left
        //递归左子树的右边界为中序中的根节点索引-1
        node.left = recur(root + 1, left, i - 1);
        //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        //递归右子树的左边界为中序中当前根节点+1
        //递归右子树的右边界为中序中原来右子树的边界
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;                                           // 回溯返回根节点
    }


}
