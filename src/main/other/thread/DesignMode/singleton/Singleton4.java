package main.other.thread.DesignMode.singleton;

/**
 * 懒汉式（线程安全，同步方法）【不推荐】
 */
public class Singleton4 {
    // 类装载时就完成了实例化
    private static Singleton4 INSTANCE;

    // 私有，不希望外界调用
    private Singleton4() {
    }

    public synchronized static  Singleton4 getInstance() {
        // 多线程环境下效率低下
        if (INSTANCE == null)
            INSTANCE = new Singleton4();
        return INSTANCE;
    }
}
