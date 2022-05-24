package main.other.thread;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i=0;
        for(;i<100;i++){
            System.out.println("call function "+ Thread.currentThread().getName() + " :" +i);
        }
        //带返回值
        return i;
    }
}
