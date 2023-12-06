package com.captainx.learningBackup.leetcode.代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。



示例 1：

输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：

输入：ransomNote = "aa", magazine = "ab"
输出：false
示例 3：

输入：ransomNote = "aa", magazine = "aab"
输出：true
 */
public class canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> magazineMap=new HashMap<>();
        HashMap<Character,Integer> ransomNoteMap=new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i),0)+1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteMap.put(ransomNote.charAt(i), ransomNoteMap.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        Set<Map.Entry<Character, Integer>> entries = ransomNoteMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue()>magazineMap.getOrDefault(entry.getKey(),0))
                return false;
        }
        return true;

    }

    public boolean canConstruct1( String ransomNote, String magazine) {
        int[] ransomNoteMap=new int[26];
        int[] magazineMap=new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineMap[magazine.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteMap[ransomNote.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < 26; i++) {
            if(magazineMap[i]<ransomNoteMap[i]){
                return false;
            }
        }
        return true;
    }
}
