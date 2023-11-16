package 事物处理.编程式事物;

import org.junit.Test;

import java.sql.Time;

public class transactionTemplateTest {
    @Test
    public void test1(){
        Time time = Time.valueOf("11:23:44");
        System.out.println(time);

        Time time2 = Time.valueOf("1699252274303");

        System.out.println(time2);
    }
}
