package 并发.创建线程.Runnable接口实现;

public class testRunnable2 {
    public static void main(String[] args) {
        Runnable target=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("MyRunnable"+i);
                }
            }
        };

        new Thread(target).start();

    }
}
