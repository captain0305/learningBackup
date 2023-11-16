package 转换器工具类;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author: xuchengrui
 * @Date: 2023/11/13
 * @Description:转换器测试
 **/

public class convertorTest {
    /**
     *
     */
    @Test
    public void testConvertor(){
        SourcePerson sourcePerson=new SourcePerson();
        sourcePerson.setName("Jhon");
        sourcePerson.setAge(23);
        sourcePerson.setSchool("bupt");
        sourcePerson.setBirth(new Date());
        TargetPerson targetPerson=CustomConvert.personConvert.toTarget(sourcePerson);
        System.out.println(sourcePerson);
        System.out.println(targetPerson);
    }
}
