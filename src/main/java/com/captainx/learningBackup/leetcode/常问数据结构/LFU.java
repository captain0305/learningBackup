package com.captainx.learningBackup.leetcode.常问数据结构;

import java.util.HashMap;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/12
 * @Description:LFU
 **/
class LFU {
    int capacity;

    int minfreq;

    HashMap<Integer,DoublyLinkedList> freqMap;
    HashMap<Integer,Node> nodeMap;

    public LFU(int capacity) {
        this.capacity=capacity;
        this.minfreq=0;
        this.freqMap=new HashMap<>();
        this.nodeMap=new HashMap<>();
    }

    public int get(int key) {
        if (capacity==0)
            return -1;
        int res=-1;
        if (nodeMap.containsKey(key)){
            Node node=nodeMap.get(key);
            int freq = node.freq;
            DoublyLinkedList list = freqMap.get(freq);
            list.remove(node);
            if (list.size==0){
                freqMap.remove(freq);
                if (freq==minfreq){
                    minfreq++;
                }
            }
            res= node.value;
            node.freq=freq+1;
            DoublyLinkedList newList = freqMap.getOrDefault(freq+1, new DoublyLinkedList());
            newList.addToFirst(node);
            nodeMap.put(key,node);
            freqMap.put(freq+1,newList);
        }
        return res;
    }



    public void put(int key, int value) {
        if (!nodeMap.containsKey(key)){
            if (nodeMap.size()==capacity){
                DoublyLinkedList list = freqMap.get(minfreq);
                Node node=list.removeLast();
                nodeMap.remove(node.key);

                if (list.size==0){
                    freqMap.remove(minfreq);

                }
            }

            Node node=new Node(key,value,1);
            DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
            list.addToFirst(node);
            nodeMap.put(key,node);

            freqMap.put(1,list);
            minfreq=1;
        }else {
            Node node=nodeMap.get(key);
            int freq = node.freq;
            DoublyLinkedList list = freqMap.get(freq);
            list.remove(node);
            if (list.size==0){
                freqMap.remove(freq);
                if (freq==minfreq){
                    minfreq++;
                }
            }

            Node newNode=new Node(key,value,freq+1);
            DoublyLinkedList newList = freqMap.getOrDefault(freq+1, new DoublyLinkedList());
            newList.addToFirst(newNode);
            nodeMap.put(key,newNode);
            freqMap.put(freq+1,newList);



        }
    }

}

class Node {
    int key,value,freq;
    Node pre;
    Node next;
    Node(int key,int value,int freq){
        this.key=key;
        this.value=value;
        this.freq=freq;
    }
    Node(){
        this.key=-1;
        this.value=-1;
        this.freq=0;
    }
}

class DoublyLinkedList {

    Node dummyHead;
    Node dummyTail;

    int size;

    DoublyLinkedList(){
        this.dummyHead=new Node();
        this.dummyTail=new Node();
        dummyHead.next=dummyTail;
        dummyTail.pre=dummyHead;
        size=0;
    }

    public Node removeLast(){
        Node node = dummyTail.pre;
        Node pre = node.pre;
        pre.next=dummyTail;
        dummyTail.pre=pre;

        size--;
        return node;

    }

    public void addToFirst(Node node){
        Node next = dummyHead.next;
        node.pre=dummyHead;
        dummyHead.next=node;
        node.next=next;
        next.pre=node;
        size++;

    }

    public void remove(Node node){
        Node pre=node.pre;
        Node next=node.next;
        pre.next=next;
        next.pre=pre;

        size--;
    }

}