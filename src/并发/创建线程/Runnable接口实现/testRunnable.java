package 并发.创建线程.Runnable接口实现;

public class testRunnable {
    public static void main(String[] args) {
        Runnable target=new MyRunnable();
        Thread t=new Thread(target);
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出"+i);
        }
    }
}
