package 并发.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;


//输出结果可能是4312 4132 4321都有可能
public class testCyclicBarrier2 {
    static CyclicBarrier c=new CyclicBarrier(3,new A());
    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(4);
        }
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                }catch (Exception e){

                }
                System.out.println(1);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                }catch (Exception e){

                }
                System.out.println(2);
            }
        }).start();
        try{
            c.await();
        }catch (Exception e){

        }
        System.out.println(3);


    }
}
