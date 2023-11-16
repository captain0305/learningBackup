package leetcode.代码随想录.链表;
/*
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]
 */
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        ListNode cur=head.next;
        ListNode pre=head;
        ListNode tmp=null;
        ListNode res=head.next;
        while (cur!=null){
            tmp=cur.next;
            if(tmp!=null&&tmp.next!=null){
                cur.next=pre;
                pre.next=tmp.next;
                cur=tmp.next;
                pre=tmp;
            }else if(tmp!=null&&tmp.next==null){
                cur.next=pre;
                pre.next=tmp;
                cur=tmp.next;
                pre=tmp;
            } else if (tmp==null) {
                cur.next=pre;
                pre.next=null;
                cur=tmp;
                pre=tmp;
            }
        }
        return res;
    }
}
