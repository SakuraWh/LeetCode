package main.other.thread.DesignMode.singleton;

/**
 * 懒汉式（线程不安全）
 */
public class Singleton3 {
    // 类装载时就完成了实例化
    private static Singleton3 INSTANCE;

    // 私有，不希望外界调用
    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Singleton3();
        return INSTANCE;
    }
}
