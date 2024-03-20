package com.captainx.learningBackup.ACM模式;

import java.util.*;

/**
 * @Author: xuchengrui
 * @Date: 2024/3/1
 * @Description:阿里面试题
 **/
public class interview {
    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> singerSongs = new HashMap<>();
        // ... 初始化 userSongs 和 singerSongs ...

        Map<String, Map<String, Integer>> countMap = new HashMap<>();
        for (Map.Entry<String, List<String>> userEntry : userSongs.entrySet()) {
            String user = userEntry.getKey();
            List<String> songs = userEntry.getValue();
            for (String song : songs) {
                for (Map.Entry<String, List<String>> singerEntry : singerSongs.entrySet()) {
                    String singer = singerEntry.getKey();
                    List<String> singerSongList = singerEntry.getValue();
                    if (singerSongList.contains(song)) {
                        Map<String, Integer> singerCount = countMap.getOrDefault(user, new HashMap<>());
                        singerCount.put(singer, singerCount.getOrDefault(singer, 0) + 1);
                        countMap.put(user, singerCount);
                    }
                }
            }
        }

        Map<String, List<String>> res = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : countMap.entrySet()) {
            String user = entry.getKey();
            Map<String, Integer> singerCount = entry.getValue();
            int maxCount = Collections.max(singerCount.values());
            List<String> favoriteSingers = new ArrayList<>();
            for (Map.Entry<String, Integer> countEntry : singerCount.entrySet()) {
                if (countEntry.getValue() == maxCount) {
                    favoriteSingers.add(countEntry.getKey());
                }
            }
            res.put(user, favoriteSingers);
        }

        System.out.println(res);


    }
}
