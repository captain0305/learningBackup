package 并发.创建线程.继承Thread类;


public class testThread {
    public static void main(String[] args) {
        Thread t=new MyThread();
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出"+i);
        }
    }
}
