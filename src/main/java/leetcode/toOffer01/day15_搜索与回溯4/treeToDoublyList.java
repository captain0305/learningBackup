package leetcode.toOffer01.day15_搜索与回溯4;

import java.util.Deque;
import java.util.LinkedList;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。



为了让您更好地理解问题，以下面的二叉搜索树为例：







我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。







特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱2-》1 1-》5，树中节点的右指针需要指向后继1-》2。还需要返回链表中的第一个节点的指针。
 */
public class treeToDoublyList {
    Deque<TreeNode> a=new LinkedList<>();
    public TreeNode treeToDoublyList(TreeNode root) {
        addDeque(root);
        //给第一个节点添加前驱
        TreeNode first = a.getFirst();
        first.left=a.getLast();
        TreeNode last=new TreeNode();
        TreeNode tmp;
        int size=a.size();


        for (int i = 0; i < size; i++) {
            if(i==0) {
                tmp=a.removeFirst();
                tmp.right=a.getFirst();
                last=tmp;
                continue;
            }
            if(i==size-1){
                tmp=a.removeFirst();
                tmp.right=first;
                continue;
            }
            tmp=a.removeFirst();
            tmp.left=last;
            tmp.right=a.getFirst();
            last=tmp;

        }

        return first;


    }

    public void addDeque(TreeNode root){
        while (root!=null){

            addDeque(root.left);
            a.add(root);
            addDeque(root.right);

        }
    }
}
