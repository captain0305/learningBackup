package 设计模式.单例模式;

import java.util.HashMap;

//懒汉加载
public class Singleton {
    private volatile static Singleton instance;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance==null){//检查实例是否存在不直接加锁
            synchronized (Singleton.class){//加锁
                if (instance==null){//再次判断是否有创建实例
                    instance =new Singleton();
                }
            }
        }
        return instance;
    }
}
