package com.captainx.learningBackup.leetcode.常问数据结构;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/12
 * @Description:lru
 **/


class LRUCache {
    DlinkNode dummyHead;
    DlinkNode dummyTail;
    Map<Integer,DlinkNode> freqMap;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        freqMap=new HashMap<>();
        dummyHead=new DlinkNode();
        dummyTail=new DlinkNode();
        dummyHead.next=dummyTail;
        dummyTail.pre=dummyHead;
    }

    public int get(int key) {
        if (!freqMap.containsKey(key)){
            return -1;
        }
        DlinkNode dlinkNode = freqMap.get(key);

        DlinkNode next = dlinkNode.next;
        DlinkNode pre = dlinkNode.pre;
        next.pre=pre;
        pre.next=next;

        DlinkNode headNext = dummyHead.next;
        headNext.pre=dlinkNode;
        dlinkNode.next=headNext;
        dlinkNode.pre=dummyHead;
        dummyHead.next=dlinkNode;
        int value = dlinkNode.value;

        return value;
    }

    public void put(int key, int value) {
        if (freqMap.size()<capacity){
            DlinkNode dlinkNode;
            if (freqMap.containsKey(key)){
                //原部分重新连接
                dlinkNode = freqMap.get(key);
                DlinkNode next = dlinkNode.next;
                DlinkNode pre = dlinkNode.pre;
                pre.next=next;
                next.pre=pre;
            }else {
                dlinkNode=new DlinkNode(key,value);
            }
            DlinkNode headNext = dummyHead.next;
            dlinkNode.next=headNext;
            headNext.pre=dlinkNode;
            dummyHead.next=dlinkNode;
            dlinkNode.pre=dummyHead;
        }else {
            DlinkNode dlinkNode;
            if (freqMap.containsKey(key)){
                //原部分重新连接
                dlinkNode = freqMap.get(key);
                DlinkNode next = dlinkNode.next;
                DlinkNode pre = dlinkNode.pre;
                pre.next=next;
                next.pre=pre;
            }else {
                dlinkNode=new DlinkNode(key,value);
                DlinkNode delete = dummyTail.pre;
                DlinkNode pre = delete.pre;
                dummyTail.pre=pre;
            }
            DlinkNode headNext = dummyHead.next;
            dlinkNode.next=headNext;
            headNext.pre=dlinkNode;
            dummyHead.next=dlinkNode;
            dlinkNode.pre=dummyHead;
        }

    }
}

class DlinkNode{
    int key;
    int value;
    DlinkNode pre;
    DlinkNode next;

    DlinkNode(int key,int value){
        this.key=key;
        this.value=value;
    }
    DlinkNode(){

    }

}