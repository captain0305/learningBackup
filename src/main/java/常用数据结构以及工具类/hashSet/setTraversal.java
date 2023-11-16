package 常用数据结构以及工具类.hashSet;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class setTraversal {
    @Test
    public void method1(){
        int[] array = {1,2,3,3,4,4,5,5};



        HashSet<Integer> set = new HashSet<>();
        for (int i:array) {
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        int[] ret = set.stream().mapToInt(Integer::intValue).toArray();//set转换成int[]
        System.out.println(Arrays.toString(ret));
    }

    @Test
    public void method2(){
        int[] array = {1,2,3,3,4,4,5,5};



        HashSet<Integer> set = new HashSet<>();
        for (int i:array) {
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            System.out.println(element);
        }
    }
}
