package main.other.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //RunnableTest R1 = new RunnableTest( "Thread-1");
        //R1.start();
        //ThreadTest t1 = new ThreadTest("thread-2");
        //t1.start();
        CallableTest C1 = new CallableTest();
        FutureTask<Integer> ft = new FutureTask<>(C1);
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName() + " 主线程 + i：" +i );
            if(i == 20){
                new Thread(ft,"ft子线程").start();
                Thread.sleep(10);
            }
        }
        //获取子线程执行结束的值
        System.out.println("返回值"+ft.get());

    }


}
