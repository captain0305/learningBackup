package 设计模式.chapter1简单工厂.计算器4;

public class OperationFactory {

    public static Operation createOperate(String operate){
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new Add();
                break;
            case "-":
                oper = new Sub();
                break;
            case "*":
                oper = new Mul();
                break;
            case "/":
                oper = new Div();
                break;
        }
        return oper;
    }
    
}
