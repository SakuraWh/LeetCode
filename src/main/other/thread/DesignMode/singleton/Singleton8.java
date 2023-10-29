package main.other.thread.DesignMode.singleton;

/**
 * 枚举
 */
public enum Singleton8 {
    INSTANCE; // 会在类加载时对枚举对象进行实例化，本质时饿汉式
    public void whatever(){

    }
}
