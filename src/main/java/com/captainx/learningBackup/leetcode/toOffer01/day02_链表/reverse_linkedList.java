package com.captainx.learningBackup.leetcode.toOffer01.day02_链表;

/*
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */

public class reverse_linkedList {


    public ListNode reverseList(ListNode head) {
       ListNode pre=null;
       ListNode cur=head;
       while (cur!=null){
           ListNode tmp=cur.next;
           cur.next=pre;
           pre=cur;
           cur=tmp;

       }
       return pre;
    }

    public static void main(String[] args) {

    }
}
