package com.captainx.learningBackup.leetcode.代码随想录.链表;
/*
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

图示两个链表在节点 c1 开始相交：



题目数据 保证 整个链式结构中不存在环。

注意，函数返回结果后，链表必须 保持其原始结构 。



示例 1：



输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
示例 2：



输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Intersected at '2'
解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 */
public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen=0;
        int bLen=0;
        ListNode cur=headA;
        while (cur!=null){
            aLen++;
            cur=cur.next;
        }
        cur=headB;
        while (cur!=null){
            bLen++;
            cur=cur.next;
        }
        ListNode curA=headA;
        ListNode curB=headB;
        if(aLen<bLen){
            int tmpLen=aLen;
            aLen=bLen;
            bLen=tmpLen;
            ListNode tmpNode=curA;
            curA=curB;
            curB=tmpNode;
        }
        int gap=aLen-bLen;
        while (gap-->0){
            curA=curA.next;
        }
        while (curA!=null){
            if(curA==curB)
                return curA;
            curA=curA.next;
            curB=curB.next;
        }
        return null;

    }
}
