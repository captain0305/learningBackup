package leetcode.代码随想录.二叉树.遍历;

import java.util.ArrayList;
import java.util.List;

public class postOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res;
    }

    void dfs(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }

        dfs(root.left,res);
        dfs(root.right,res);

        res.add(root.val);


    }
}
