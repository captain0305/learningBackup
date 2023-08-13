package leetcode.二叉树.遍历;

import java.util.ArrayList;
import java.util.List;

public class preorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res;
    }

    void dfs(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }
        res.add(root.val);
        dfs(root.left,res);
        dfs(root.right,res);


    }
}
