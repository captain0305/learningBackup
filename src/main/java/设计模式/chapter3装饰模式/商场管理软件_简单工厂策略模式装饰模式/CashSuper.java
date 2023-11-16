package 设计模式.chapter3装饰模式.商场管理软件_简单工厂策略模式装饰模式;

public class CashSuper implements ISale {

    protected ISale component;

    //装饰对象
    public void decorate(ISale component) {
        this.component=component;
    }

    public double acceptCash(double price,int num){

        return 0;
    }
    
}


