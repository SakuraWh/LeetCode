package main.other.thread.DesignMode.singleton;

/**
 * 饿汉式（静态常量） 【可用】
 */
public class Singleton1 {
    // 类装载时就完成了实例化
    private final static Singleton1 INSTANCE = new Singleton1();

    // 私有，不希望外界调用
    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
