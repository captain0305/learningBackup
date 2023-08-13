package leetcode.toOffer01.day06_搜索与回溯1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */

public class levelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> a= new ArrayDeque<>();
        Deque<Integer> depth=new ArrayDeque<>();
        ArrayList<List<Integer>> result=new ArrayList<>();
        int ini=1;
        if(root!=null) {
            a.add(root);
            depth.add(ini);


            int count = 1;
            ArrayList<Integer> temp = new ArrayList<>();
            while (!a.isEmpty()) {
                TreeNode remove = a.remove();
                Integer remove_depth = depth.remove();
                if (count != remove_depth) {
                    Object clone = temp.clone();
                    ArrayList clone2 = (ArrayList) clone;
                    result.add(clone2);
                    temp.clear();
                    count++;
                }
                if (remove.left != null) {
                    a.add(remove.left);
                    depth.add(remove_depth + 1);
                }
                if (remove.right != null) {
                    a.add(remove.right);
                    depth.add(remove_depth + 1);
                }
                temp.add(remove.val);

            }
            if (a.isEmpty()) {
                Object clone = temp.clone();
                ArrayList clone2 = (ArrayList) clone;
                result.add(clone2);
            }

            return result;
        }else {
            return result;
        }
    }
}
