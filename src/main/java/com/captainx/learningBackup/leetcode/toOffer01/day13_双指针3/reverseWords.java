package com.captainx.learningBackup.leetcode.toOffer01.day13_双指针3;

public class reverseWords {
    public String reverseWords(String s) {
        String[] s1 = s.split(" +");
        StringBuilder sb=new StringBuilder();
        for(int i=s1.length-1;i>=0;i--){
            if(s1[0]!=""){

                if(i!=0)
                    sb.append(s1[i]+" ");
                else if (i==0) {
                    sb.append(s1[i]);
                }
            } else if (s1[0]=="") {
                if(i!=1)
                    sb.append(s1[i]+" ");
                else if (i==1) {
                    sb.append(s1[i]);
                    break;
                }
            }
        }
        String s2 = sb.toString();
        return s2;
    }

    public String reverseWords1(String s) {
        String [] ret=s.split(" ");
        StringBuilder arr = new StringBuilder();
        for(int i=ret.length-1;i>=0;i--){
            if(ret[i].equals("")){
                continue;
            }else{
                arr.append(ret[i]+" ");
            }
        }
        //public String trim()返回字符串的副本，忽略前导空白和尾部空白。
        return  arr.toString().trim();
    }
}
