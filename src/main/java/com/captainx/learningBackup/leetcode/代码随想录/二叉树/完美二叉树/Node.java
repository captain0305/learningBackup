package com.captainx.learningBackup.leetcode.代码随想录.二叉树.完美二叉树;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/11
 * @Description:完美二叉树节点
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
