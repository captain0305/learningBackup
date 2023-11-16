package leetcode.代码随想录.栈与队列;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
 */
public class isValid {
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()||s.charAt(i)!=map.get(stack.pop())){
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
