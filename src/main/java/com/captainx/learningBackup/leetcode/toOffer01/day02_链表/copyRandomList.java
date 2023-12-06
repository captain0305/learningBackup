package com.captainx.learningBackup.leetcode.toOffer01.day02_链表;

import java.util.HashMap;

/*
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。


 */
public class copyRandomList {
    HashMap<Node,Node> cachedNode =new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        //通过回溯
        if(!cachedNode.containsKey(head)){
            Node headNew =new Node(head.val);
            cachedNode.put(head,headNew);
            headNew.next=copyRandomList(head.next);//如果不用这个函数来返回新空间地址值，会导致报错
            headNew.random=copyRandomList(head.random);//上下两行代码没什么不一样，因为next都执行过一遍以后节点在map里面都被执行创建过一遍 了
            headNew.random=cachedNode.get(head.random);

        }
        return cachedNode.get(head);
    }
}
