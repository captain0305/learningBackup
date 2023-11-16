package leetcode.toOffer01.day06_搜索与回溯1;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]
 */

public class levelOrder {
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> a= new ArrayDeque<>();
        ArrayList<Integer> result=new ArrayList<>();
        if(root!=null)
            a.add(root);

        while (!a.isEmpty()){
            TreeNode remove = a.remove();
            if(remove.left!=null){
                a.add(remove.left);
            }
            if(remove.right!=null){
                a.add(remove.right);
            }
            result.add(remove.val);
        }
//        Object[] objects = result.toArray();


        int[] arr = result.stream().mapToInt(Integer::valueOf).toArray();
        return arr;
    }
}
