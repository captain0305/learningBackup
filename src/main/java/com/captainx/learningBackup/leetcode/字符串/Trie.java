package com.captainx.learningBackup.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/12
 * @Description:前缀树
 **/
class Trie {

    Map<Character, Trie> next;
    boolean isEnd;
    public Trie() {
        this.next=new HashMap<>();
        this.isEnd=false;
    }
    public void insert(String word) {
        Trie cur = this; // 得到根结点
        for(char c : word.toCharArray()){
            if(cur.next.get(c) == null){ // 若当前无此字符，添加之
                cur.next.put(c, new Trie());
            }
            cur = cur.next.get(c); // 向下考察
        }
        cur.isEnd = true; // 置末尾字符节点isEnd为true

    }


    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        if (trie!=null){
            return trie.isEnd;
        }
        return false;
    }
    public boolean startsWith(String prefix) {
        Trie trie = searchPrefix(prefix);
        if (trie!=null){
            return true;
        }

        return false;

    }
    private Trie searchPrefix(String prefix){
        Trie cur = this;
        for(char c : prefix.toCharArray()){
            if(cur.next.get(c) == null){
                return null; // 无此前缀，返回null
            }
            cur = cur.next.get(c);
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */