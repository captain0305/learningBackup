package leetcode.toOffer01.day12_双指针2;

public class mergeTwoLists {
    //我写的大便
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) throws Exception{
        ListNode tmp1;
        ListNode tmp2;
        if(l1.val<=l2.val){
            tmp1=l1;
            tmp2=l2;

        }else {
            tmp1=l2;
            tmp2=l1;
        }
        ListNode tmp11;
        ListNode tmp22;
        ListNode result;
        if(l1==null&&l2!=null){
            return l2;
        }
        if(l1!=null&&l2==null){
            return l1;
        }
        if(l1==null&&l2==null){
            return null;
        }
        if(l1.val<=l2.val)
            result=l1;
        else
            result=l2;
        while (tmp2!=null&&tmp1.next!=null){

                if(tmp2.val<=tmp1.next.val&&tmp2.val>=tmp1.val){
                    tmp11=tmp1.next;
                    tmp22=tmp2.next;
                    tmp1.next=tmp2;
                    tmp2.next=tmp11;
                    tmp1=tmp2;
                    tmp2=tmp22;
                }else {
                    tmp1=tmp1.next;
                }

        }
        if(tmp2!=null&&tmp1.next==null){
            tmp1.next=tmp2;
        }



        return result;

    }
    //递归写法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
