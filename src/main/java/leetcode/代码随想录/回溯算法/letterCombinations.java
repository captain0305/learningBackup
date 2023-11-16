package leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 */
public class letterCombinations {
    Map<Integer,String> map=new HashMap<>();
    List<String> res=new ArrayList<>();
    StringBuilder temp=new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        backtrack(digits,0);
        return res;
    }

    void backtrack(String digits,int StartId){
        if(temp.toString().length()==digits.length()){
            res.add(new String(temp.toString()));
            return;
        }
        char[] digitsChar = digits.toCharArray();
        int digit=digitsChar[StartId]-'0';
        String s = map.get(digit);
        char[] chars = s.toCharArray();
        for (int j = 0; j < s.length(); j++) {
            temp.append(chars[j]);
            backtrack(digits,StartId+1);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}
