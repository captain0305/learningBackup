package leetcode.toOffer01.day13_双指针3;

import org.junit.Test;

public class test {
    @Test
    public void testsplit(){
        String s=" the sky is   blue ";
        String[] ret = s.split(" +");
        StringBuilder arr=new StringBuilder();
        for(int i=ret.length-1;i>=0;i--){
            if(ret[i].equals("")){
                continue;
            }else{
                arr.append(ret[i]+" ");
            }
        }

        System.out.println(arr.toString().trim());

    }

    public String reverseWords(String s) {
        String [] ret=s.split(" ");
        StringBuilder arr = new StringBuilder();
        for(int i=ret.length-1;i>=0;i--){
            if(ret[i].equals("")){
                continue;
            }else{
                arr.append(ret[i]+" ");
            }
        }
        return  arr.toString().trim();
    }
}
