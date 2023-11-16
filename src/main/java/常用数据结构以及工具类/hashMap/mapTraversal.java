package 常用数据结构以及工具类.hashMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapTraversal {
    @Test
    public void method1(){
        Map<String , Integer> maps = new HashMap<>();
        // 1.添加元素: 无序，不重复，无索引。
        maps.put("娃娃",30);
        maps.put("iphoneX",100);
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);
        // maps = {huawei=1000, 手表=10, 生活用品=10, iphoneX=100, 娃娃=30}

        // 1、键找值：第一步：先拿到集合的全部键。
        Set<String> keys = maps.keySet();
        // 2、第二步：遍历每个键，根据键提取值
        for (String key : keys) {
            int value = maps.get(key);
            System.out.println(key + "===>" + value);
        }

    }


    //最常用
    @Test
    public void  method2(){
        Map<String , Integer> maps = new HashMap<>();
        // 1.添加元素: 无序，不重复，无索引。
        maps.put("娃娃",30);
        maps.put("iphoneX",100);
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);
        // maps = {huawei=1000, 手表=10, 生活用品=10, iphoneX=100, 娃娃=30}
        /**
         maps = {huawei=1000, 手表=10, 生活用品=10, iphoneX=100, 娃娃=30}
         👇
         使用foreach遍历map集合.发现Map集合的键值对元素直接是没有类型的。所以不可以直接foreach遍历集合。
         👇
         可以通过调用Map的方法 entrySet把Map集合转换成Set集合形式  maps.entrySet();
         👇
         Set<Map.Entry<String,Integer>> entries =  maps.entrySet();
         [(huawei=1000), (手表=10), (生活用品=10), (iphoneX=100), (娃娃=30)]
         entry
         👇
         此时可以使用foreach遍历
         */
        // 1、把Map集合转换成Set集合
        Set<Map.Entry<String, Integer>> entries = maps.entrySet();
        // 2、开始遍历
        for(Map.Entry<String, Integer> entry : entries){
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + "====>" + value);
        }
    }

    @Test
    public void method3(){
        Map<String , Integer> maps = new HashMap<>();
        // 1.添加元素: 无序，不重复，无索引。
        maps.put("娃娃",30);
        maps.put("iphoneX",100);//  Map集合后面重复的键对应的元素会覆盖前面重复的整个元素！
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);

        //  maps = {huawei=1000, 手表=10, 生活用品=10, iphoneX=100, 娃娃=30}

//        maps.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String key, Integer value) {
//                System.out.println(key + "--->" + value);
//            }
//        });

        maps.forEach((k, v) -> {
            System.out.println(k + "--->" + v);
        });
    }
}
