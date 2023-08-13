package leetcode.toOffer01.day19_搜索与回溯6;

public class lowestCommonAncestor_common {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;//当root为p或q或者null时返回
        TreeNode left = lowestCommonAncestor(root.left, p, q);//left为左树的查询
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;//如果左树为空的话说明结果在右树里
        if(right == null) return left;//如果右树为空的话说明结果在左树里
        return root;//左边不空且右边不空的情况
    }


}
