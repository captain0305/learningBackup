package com.captainx.learningBackup.leetcode.代码随想录.链表;

import java.util.Deque;
import java.util.LinkedList;

public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
        Deque<ListNode> stack=new LinkedList<>();
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        dummy.next=head;
        while (true){
            int count=0;
            ListNode tmp=head;

            while (count!=k&&tmp!=null){
                stack.add(tmp);
                tmp=tmp.next;
                count++;
            }
            if (count<k){
                pre.next=head;
                break;
            }
            while (!stack.isEmpty()){
                pre.next=stack.pollLast();
                pre=pre.next;
            }
            pre.next=tmp;
            head=tmp;
        }
        return dummy.next;
    }
}
