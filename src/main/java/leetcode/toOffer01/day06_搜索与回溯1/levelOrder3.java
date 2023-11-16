package leetcode.toOffer01.day06_搜索与回溯1;

import java.util.*;
/*
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

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
  [20,9],
  [15,7]
]
 */

public class levelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> a= new ArrayDeque<>();
        Deque<TreeNode> b= new ArrayDeque<>();
        Deque<Integer> depth=new ArrayDeque<>();
        ArrayList<List<Integer>> result=new ArrayList<>();
        int ini=1;

        if(root!=null) {
            a.add(root);
            depth.add(ini);



            int count = 1;
            ArrayList<Integer> temp = new ArrayList<>();
            while (!depth.isEmpty()) {

                Integer remove_depth = depth.remove();
                if (count != remove_depth) {
                    Object clone = temp.clone();
                    ArrayList clone2 = (ArrayList) clone;
                    result.add(clone2);
                    temp.clear();
                    count++;
                }
                if(count%2==0){
                    TreeNode remove = b.pop();

                    if (remove.right != null) {
                        a.push(remove.right);
                        depth.add(remove_depth + 1);
                    }
                    if (remove.left != null) {
                        a.push(remove.left);
                        depth.add(remove_depth + 1);
                    }
                    temp.add(remove.val);

                }else if(count%2==1){
                    TreeNode remove=a.pop();
                    if (remove.left != null) {
                        b.push(remove.left);
                        depth.add(remove_depth + 1);
                    }
                    if (remove.right != null) {
                        b.push(remove.right);
                        depth.add(remove_depth + 1);
                    }

                    temp.add(remove.val);
                }


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


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null){
            return resList;
        }
        que.offer(root);
        int lineNum = 0;
        while(! que.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int len = que.size();
            while(len > 0){
                TreeNode node = que.poll();
                res.add(node.val);
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
                len --;
            }
            //逆向化
            if(lineNum % 2 != 0){
                Collections.reverse(res);
            }
            lineNum ++;
            resList.add(res);
        }
        return resList;
    }

}
