package com.captainx.learningBackup.leetcode.杂题;


import java.util.Arrays;

/*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。



示例 1：


输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：


输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]
 */
public class sortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode cur=head;
        int len=0;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        cur=head;
        ListNode[] tmp=new ListNode[len];
        for (int i = 0; i < len; i++) {
            tmp[i]=cur;
            cur=cur.next;
        }

        Arrays.sort(tmp, (o1, o2) -> o1.val-o2.val);
        ListNode res=tmp[0];
        for (int i = 0; i < len-1; i++) {
            tmp[i].next=tmp[i+1];
        }
        tmp[len-1].next=null;
        return res;
    }
}
