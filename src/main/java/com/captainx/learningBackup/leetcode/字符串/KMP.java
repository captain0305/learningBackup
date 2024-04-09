package com.captainx.learningBackup.leetcode.字符串;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/12
 * @Description:字符串匹配
 **/
public class KMP {
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABABCABAB";
        String pat = "ABABCABAB";
        KMPSearch(pat, txt);
    }

    // Fills lps[] for given patttern pat[0..M-1]
    static void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else { // (pat[i] != pat[len])
                if (len != 0) {
                    len = lps[len - 1];
                } else { // if (len == 0)
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // Prints occurrences of txt[] in pat[]
    static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // 模式串的最大匹配前缀
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        //j为模式串下表 i为目标串下表
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                //找到匹配位置重置下标继续匹配
                j = lps[j - 1];
                //目标串还没到尾且目标串和文本串不匹配
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
}
