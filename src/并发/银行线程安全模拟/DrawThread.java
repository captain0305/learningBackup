package 并发.银行线程安全模拟;

public class DrawThread extends Thread{
    private Account acc;

    public DrawThread() {

    }
    public DrawThread(Account acc,String name) {
        super(name);
        this.acc=acc;

    }

    @Override
    public void run() {
        acc.drawMoney(100000);
        super.run();
    }
}
