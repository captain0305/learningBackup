package leetcode.链表;
/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


示例 1：


输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：


输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]
 */
public class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode cur=new ListNode();
        ListNode pre=new ListNode();
        ListNode tmp=new ListNode();
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        cur=head.next;
        pre=head;
        pre.next=null;
        while (cur!=null){
            tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }
}
