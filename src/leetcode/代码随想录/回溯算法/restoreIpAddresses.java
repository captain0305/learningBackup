package leetcode.回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。



示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class restoreIpAddresses {
    List<List<String>> res=new ArrayList<>();
    LinkedList<String> temp=new LinkedList<>();
    List<String> result=new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s,0);

        for (int i = 0; i < res.size(); i++) {
            List<String> strings = res.get(i);
            String tmp="";
            for (int j = 0; j < strings.size()-1; j++) {
                tmp+=strings.get(j);
                tmp+=".";
            }
            tmp+=strings.get(strings.size()-1);
            result.add(tmp);
        }
        return result;
    }

    void backtrack(String s,int start){
        if(start>=s.length()&&temp.size()==4){
            res.add(new ArrayList<>(temp));
            return;
        }
        //加入这部分剪枝代码从7ms变成3ms
        if(start>=s.length()||temp.size()==4){

            return;
        }


        for (int i = start; i <s.length() ; i++) {

            if(isIpAddress(s,start,i)){
                String str=s.substring(start,i+1);
                temp.addLast(str);
            }else {
                continue;
            }


            backtrack(s,i+1);

            temp.removeLast();
        }

    }
    private boolean isIpAddress(String s, int startIndex, int end) {
        String str=s.substring(startIndex,end+1);
        if(str.length()>1&&str.charAt(0)=='0'||str.length()>3){
            return false;
        }
        Integer aLong = Integer.valueOf(str);
        if(aLong<=255&&aLong>=0){
            return true;
        }
        return false;

    }


}
