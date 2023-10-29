package main.other.thread.mian;

public class SwapPrint2 {
    public static final Object lock = new Object();
    public static int count = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        if (count > 100)
                            break;
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        if (count > 100)
                            break;
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
}
