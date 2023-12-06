package 单元测试Mock;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @Author: xuchengrui
 * @Date: 2023/11/23
 * @Description:计算器测试类
 **/
public class CalculateTest {

        @Test
        public void testAddition() {
            // 创建 Calculator 的模拟对象
            Calculator calculatorMock = Mockito.mock(Calculator.class);

            // 设置模拟对象的行为
            Mockito.when(calculatorMock.add(2, 3)).thenReturn(5);

            // 在测试中使用模拟对象
            int result = calculatorMock.add(2, 3);


            // 验证模拟对象的调用
            Mockito.verify(calculatorMock).add(2, 3);

            // 断言结果是否符合预期

            Assert.assertEquals(5, result);
        }

        @Test
        public void testSubstract(){
            // 创建 Calculator 的模拟对象
            Calculator calculatorMock = Mockito.mock(Calculator.class);


            Mockito.when(calculatorMock.subtract(3,1)).thenReturn(2);
            int substract = calculatorMock.subtract(3, 1);
            System.out.println(substract);
            Assert.assertEquals(2,substract);
        }

}
