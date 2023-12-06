package 单元测试Mock;

/**
 * @Author: xuchengrui
 * @Date: 2023/11/23
 * @Description:计算器类用于mock测试
 **/
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    // 其他可能的计算方法
    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
