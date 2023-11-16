package 常用数据结构以及工具类.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class map {
    public static void main(String[] args) {
        String str="abcabcabc";
        char[] chars=str.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        int res=0;
        for(int i=0;i<str.length();i++){

            if(map.containsKey(chars[i])){
                int temp=map.get(chars[i]);

                Set<Map.Entry<Character, Integer>> entries =map.entrySet();
                for (Map.Entry<Character, Integer> entry : entries) {
                    Character key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value<=temp){
                        map.remove(key);
                    }
                }

            }else{
                map.put(chars[i],i);
                res=Math.max(res, map.size());
            }

        }
        System.out.println(res);
    }
}

