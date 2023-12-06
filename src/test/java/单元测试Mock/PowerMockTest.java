package 单元测试Mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.*;


/**
 * @Author: xuchengrui
 * @Date: 2023/11/23
 * @Description:powermock的用法
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest({MyStaticClass.class,FinalClass.class})
public class PowerMockTest {

    /**
     * 模拟静态方法
     */
    @Test
    public void testStaticMethod() {
        // 使用mockStatic方法模拟静态类
        mockStatic(MyStaticClass.class);

        // 设置模拟静态方法的行为
        when(MyStaticClass.staticMethod()).thenReturn("Mocked Static Method");

        // 测试类调用静态方法
        String result = MyStaticClass.staticMethod();

        // 验证结果
        Assert.assertEquals("Mocked Static Method", result);
    }

    /**
     * 模拟私有方法
     * @throws Exception
     */
    @Test
    public void testPrivateMethod() throws Exception {
        MyStaticClass myStaticClass= spy(new MyStaticClass());
        PowerMockito.when(myStaticClass, "myPrivate").thenReturn("Mocked Value");

        String aa = myStaticClass.getAa();
        System.out.println(MyStaticClass.staticMethod());
        Assert.assertEquals("123",aa);

    }

    /**
     * 模拟final方法
     */
    @Test
    public void testFinalMethod(){
        FinalClass finalClass=mock(FinalClass.class);
        Mockito.when(finalClass.getMessage()).thenReturn("123");

        String message = finalClass.getMessage();
        Assert.assertEquals("123",message);

    }


}
