package 并发.银行线程安全模拟;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String CardId;
    private double money;
    private final Lock lk=new ReentrantLock();//不能更改



    //静态方法用class进行锁
    public static void test(){
        synchronized (Account.class){}
    }
    //同步方法也是获取this作为锁
//    public  synchronized void drawMoney(double money){
    public  void drawMoney(double money){
        String name=Thread.currentThread().getName();
        lk.lock();
        //多用this作为锁
//        synchronized (this) {
//            if (this.money>=money){
//                System.out.println(name+"来取钱"+money+"成功");
//                this.money-=money;
//                System.out.println(name+"来取钱余额剩余"+this.money);
//            }else {
//                System.out.println(name+"余额不足");
//            }
//        }
        if (this.money>=money){
            System.out.println(name+"来取钱"+money+"成功");
            this.money-=money;
            System.out.println(name+"来取钱余额剩余"+this.money);
        }else {
            System.out.println(name+"余额不足");
        }
        lk.unlock();
    }
    public Account() {
    }

    public Account(String CardId, double money) {
        this.CardId = CardId;
        this.money = money;
    }

    /**
     * 获取
     * @return CardId
     */
    public String getCardId() {
        return CardId;
    }

    /**
     * 设置
     * @param CardId
     */
    public void setCardId(String CardId) {
        this.CardId = CardId;
    }

    /**
     * 获取
     * @return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    public String toString() {
        return "Account{CardId = " + CardId + ", money = " + money + "}";
    }
}
