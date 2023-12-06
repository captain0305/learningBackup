package com.captainx.learningBackup.leetcode.toOffer01.day12_双指针2;

import java.util.ArrayList;

public class getIntersectionNode {
    ListNode getIntersectionNode_final(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }

        ArrayList<ListNode> a=new ArrayList<>();
        ArrayList<ListNode> b=new ArrayList<>();
        while (headA!=null){
            a.add(headA);
            headA=headA.next;
        }
        while (headB!=null){
            b.add(headB);
            headB=headB.next;
        }
        int size=a.size()<b.size()?a.size():b.size();
        ListNode result=null;

        for (int i = 0; i < size; i++) {
            ListNode listNodea = a.get(a.size() - 1 - i);
            ListNode listNodeb = b.get(b.size() - 1 - i);
            if(i==0&&listNodea!=listNodeb)
                return null;
            else if(i==0&&listNodea==listNodeb){
                result=listNodea;
            }
            if(listNodea!=listNodeb)
                return result;
            result=listNodea;

        }
        return result;
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null&&headB==null){
            return null;
        }
        if(!isSameorNot(headA,headB)){
            return null;
        }
        ArrayList<ListNode> a=new ArrayList<>();
        ArrayList<ListNode> b=new ArrayList<>();
        while (headA!=null){
            a.add(headA);
            headA=headA.next;
        }
        while (headB!=null){
            b.add(headB);
            headB=headB.next;
        }
        int size=a.size()<b.size()?a.size():b.size();
        ListNode result=a.get(a.size()-1);
        for (int i = 0; i < size; i++) {
            ListNode listNodea = a.get(a.size() - 1 - i);
            ListNode listNodeb = b.get(b.size() - 1 - i);

            if(listNodea!=listNodeb)
                return result;
            result=listNodea;

        }
        return null;
    }
    Boolean isSameorNot(ListNode headA, ListNode headB){
        if(headA!=null&&headB==null)
            return false;
        if(headA==null&&headB!=null)
            return false;
        if(headA==null&&headB==null)
            return true;
        if(headA.val==headB.val){
            return isSameorNot(headA.next,headB.next);
        }else {
            return isSameorNot(headA.next, headB)||(isSameorNot(headA, headB.next));
        }
    }
}
