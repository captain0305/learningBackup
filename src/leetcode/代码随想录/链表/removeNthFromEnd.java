package leetcode.链表;
/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。



示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
 */

//用快慢指针用于恒定差倒序搜索

//0 1 2 3 4 null n=2 最后fast在4
public class removeNthFromEnd {
    //快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        //只要快慢指针相差 n 个结点即可
        for (int i = 0; i < n  ; i++){
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }
}
