package 异常处理.Optional;


import org.junit.Test;

import java.util.Optional;


public class TestOptional {

    @Test
    public void testOptional1(){
        Optional<String> presentOptional = Optional.of("Hello"); // 创建一个包含非null值的Optional
        Optional<String> nullableOptional = Optional.ofNullable(null); // 创建一个可以包含null值的Optional
        Optional<String> emptyOptional = Optional.empty(); // 创建一个空的Optional

        System.out.println(presentOptional.get());
        System.out.println(presentOptional.isPresent());
        System.out.println(presentOptional.isPresent());

        //System.out.println(nullableOptional.get());
        System.out.println(nullableOptional.isPresent());


        //System.out.println(emptyOptional.get());
        System.out.println(emptyOptional.isPresent());
    }

    /**
     * 基本使用模板
     */
    @Test
    public void testOptional2(){
        Optional<String> optional = Optional.empty();
        String result = optional.orElse("Default Value");
        System.out.println(result); // 输出 "Default Value"

    }

    /**
     * 映射操作
     * 过滤操作
     */
    @Test
    public void testOptional3(){
        Optional<String> optional = Optional.of("Hello");
        Optional<Integer> lengthOptional = optional.map(String::length); // 映射为字符串长度
        Optional<String> filteredOptional = optional.filter(s -> s.length() > 5); // 过滤长度大于5的字符串
        System.out.println(optional.isPresent());
        System.out.println(lengthOptional.get());
        System.out.println(filteredOptional.isPresent());
    }


}
