package 设计模式.chapter1简单工厂.计算器3;

public class Operation {
    public static double getResult(double numberA, 
        double numberB, String operate) {
        double result = 0d;
        switch (operate) {
            case "+":
                result = numberA + numberB;
                break;
            case "-":
                result = numberA - numberB;
                break;
            case "*":
                result = numberA * numberB;
                break;
            case "/":
                result = numberA / numberB;
                break;
            case "pow":
                result= Math.pow(numberA,numberB);
                break;
        }
        return result;
    }
}
