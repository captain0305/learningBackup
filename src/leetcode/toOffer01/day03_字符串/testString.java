package leetcode.toOffer01.day03_字符串;

import org.junit.Test;

public class testString {
    @Test
    public void testString(){
        String s="we are happy.";

        String replace = s.replace(" ", "%20");
        System.out.println(replace);

    }

    @Test
    public void testLeftReverse(){
        StringBuilder res=new StringBuilder();
        String s="abcdefg";
        int k=2;
        char[] arr = s.toCharArray();

        for(int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            res.append(c);
        }
        for (int i=0;i<k;i++){
            char c=s.charAt(i);
            res.append(c);
        }

        System.out.println(res.toString());
    }

    //最快
}
