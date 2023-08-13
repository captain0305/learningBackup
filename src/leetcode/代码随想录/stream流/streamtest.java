package stream流;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
stream流可以做一些for循环的操作
对list或set进行修改 不能修改map类型数据
 */

public class streamtest {
    @Test
    public void teststream(){
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");

       stringList.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
    }
}
