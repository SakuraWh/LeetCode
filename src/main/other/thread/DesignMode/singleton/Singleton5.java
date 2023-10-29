package main.other.thread.DesignMode.singleton;

/**
 * 懒汉式（线程不安全，同步代码块）【不推荐】
 */
public class Singleton5 {
    // 类装载时就完成了实例化
    private static Singleton5 INSTANCE;

    // 私有，不希望外界调用
    private Singleton5() {
    }

    public  static  Singleton5 getInstance() {
        // 多线程环境下效率低下
        if (INSTANCE == null) //可能出现两个线程都进入这个if条件
            synchronized (Singleton5.class){
                INSTANCE = new Singleton5();
            }

        return INSTANCE;
    }
}