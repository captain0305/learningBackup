package leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。



示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]

 */

public class partition {
    List<List<String>> res=new ArrayList<>();
    LinkedList<String> temp=new LinkedList<>();

    public List<List<String>> partition(String s) {


        backtrack(s,0);
        return res;


    }

    void backtrack(String s,int start){
        if(start>=s.length()){
            res.add(new ArrayList<>(temp));

            return;
        }

        for (int i = start; i <s.length() ; i++) {
            if(isPalindrome(s,start,i)){
                String str=s.substring(start,i+1);
                temp.addLast(str);
            }else {
                continue;
            }


            backtrack(s,i+1);

            temp.removeLast();
        }

    }
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
