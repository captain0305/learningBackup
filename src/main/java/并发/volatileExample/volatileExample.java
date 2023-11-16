package 并发.volatileExample;

public class volatileExample {
    private volatile boolean flag = false;

    public void start() {
        new Thread(() -> {
            System.out.println("Thread A started");
            while (!flag) {
                // 执行一些操作
            }
            System.out.println("Thread A finished");
        }).start();

        new Thread(() -> {
            System.out.println("Thread B started");
            // 模拟一些操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true; // 修改共享变量的值
            System.out.println("Thread B updated flag");
        }).start();
    }

    public static void main(String[] args) {
        volatileExample example = new volatileExample();
        example.start();
    }
}
