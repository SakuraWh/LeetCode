package main.other.thread.DesignMode.singleton;

/*
    静态内部类
 */
public class Singleton7 {
    private Singleton7() {

    }

    //只有调用时才加载，finnal保证不可更改
    private static class SingletonInstance {
        private static final Singleton7 instance = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.instance;
    }

}
