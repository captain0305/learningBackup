package com.captainx.learningBackup.leetcode.toOffer01.day15_搜索与回溯4;

public class treeToDoublyList2 {
    Node head,pre;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;

    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;//现在非空的话，设置上一个查询到的节点的后驱节点为cur
        else head = cur;//最小的值设置一下记录head节点
        cur.left = pre;//设置现在的前驱为pre为上一个访问过的节点
        pre = cur;//设置上一个查询到的节点为pre
        dfs(cur.right);
    }


}
