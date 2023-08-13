package leetcode.toOffer01.day11_双指针1;
/*
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode result=head;
        ListNode tmp=head;
        if(head.val==val){
            return head.next;
        }
        while(tmp.next!=null){
            if(tmp.next.val==val){
                ListNode next=tmp.next.next;
                tmp.next=next;
                break;
            }
            tmp=tmp.next;

        }
        return result;
    }
}
