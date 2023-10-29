package main.other.thread.mian;

public class SwapPrint3 {
    static int count = 0;
    public static void main(String[] args) {

        Object lock = new Object();
        new Thread(new PrintThread(lock)).start();
        new Thread(new PrintThread(lock)).start();
    }
    static class PrintThread implements Runnable {

        public Object lock;

        public PrintThread( Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count > 100)
                        break;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

