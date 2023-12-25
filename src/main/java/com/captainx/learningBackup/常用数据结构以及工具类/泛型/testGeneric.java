package com.captainx.learningBackup.常用数据结构以及工具类.泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuchengrui
 * @Date: 2023/12/13
 * @Description:泛型测试
 **/
public class testGeneric {
    public<T> List<List<T>> splitList(List<T> inputList, int chunkSize) {
        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, inputList.size());
            List<T> chunk = inputList.subList(i, end);
            result.add(chunk);
        }

        return result;
    }


}
