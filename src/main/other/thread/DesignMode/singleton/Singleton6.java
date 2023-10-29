package main.other.thread.DesignMode.singleton;

/**
 * 双重检查
 */
public class Singleton6 {
    private volatile static Singleton6 instance;

    private Singleton6() {

    }

    private static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) { // 区别于加在方法上，范围变小了，可能存在其他操作，每个操作都强行同步效率低下
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
