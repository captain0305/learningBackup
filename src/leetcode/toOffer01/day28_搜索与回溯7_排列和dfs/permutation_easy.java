package leetcode.toOffer01.day28_搜索与回溯7_排列和dfs;

import java.util.*;

public class permutation_easy {
    /**
     该题类似于 全排列2，本题使用set来去除重复元素
     除了使用set去重外，还可以对数组进行排序，使用visited数组进行剪枝！

     */
    List<String> res = new ArrayList<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        //先排序来进行剪枝
        Arrays.sort(chars);
        backtrack(chars,new StringBuilder(), new boolean[s.length()]);
        return res.toArray(new String[0]);

    }

    // 回溯函数
    public void backtrack(char[] ch,StringBuilder sb, boolean[] visitid){
        // 终止条件
        if(sb.length() == ch.length){
            res.add(sb.toString());
            return;
        }
        // 剪枝，如果当前位置的元素已经使用过，则跳过进入下一个位置
        for(int i = 0; i < ch.length; i++){
            //剪枝
            if (i > 0 && ch[i] == ch[i - 1] && visitid[i - 1] == false) {
                continue;
            }
            if(visitid[i]==false){// 做出选择
                sb.append(ch[i]);
                // 更新标记
                visitid[i] = true;
                // 进入下层回溯
                backtrack(ch,sb,visitid);
                // 撤销选择
                sb.deleteCharAt(sb.length()-1);//删除最后一个
                visitid[i] = false;
            }
        }
    }
}
