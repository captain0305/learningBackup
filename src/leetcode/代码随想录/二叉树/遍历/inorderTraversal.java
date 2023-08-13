package leetcode.二叉树.遍历;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res;
    }

    void dfs(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }

        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);




    }
}
