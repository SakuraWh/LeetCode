package main.other.thread.DesignMode.singleton;

/**
 * 饿汉式（静态代码块） 【可用】
 */
public class Singleton2 {
    // 类装载时就完成了实例化
    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    // 私有，不希望外界调用
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
