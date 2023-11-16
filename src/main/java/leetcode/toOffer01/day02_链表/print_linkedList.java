package leetcode.toOffer01.day02_链表;

import java.util.ArrayList;

/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
输入：head = [1,3,2]
输出：[2,3,1]

 */

public class print_linkedList {
    ArrayList tmp=new ArrayList<Integer>();

    public int[] reversePrint(ListNode head) {
        while(head!=null){
            tmp.add(head.val);
            head=head.next;
        }
        int[] res=new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i]=(int)tmp.get(tmp.size()-1-i);
        }
        return res;
    }
}
