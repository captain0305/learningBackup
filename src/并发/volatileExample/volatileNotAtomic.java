package 并发.volatileExample;

public class volatileNotAtomic {
    private volatile int counter = 0;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        volatileNotAtomic example = new volatileNotAtomic();

        // 创建多个线程对计数器进行递增操作
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    example.increment();
                }
            });
            threads[i].start();
        }

        // 等待所有线程执行完毕
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 输出计数器的最终值
        System.out.println("Counter: " + example.getCounter());
    }
}
