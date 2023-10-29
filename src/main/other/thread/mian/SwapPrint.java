package main.other.thread.mian;

// 使用两个线程交替打印奇数偶数
public class SwapPrint {
    static int count = 0;
    public static void main(String[] args) {

        Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if ((count & 1) == 1)
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        if (count>=100)
                            break;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if ((count & 1) == 0)
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        if (count>=100)
                            break;
                    }
                }
            }
        }).start();
    }
}

