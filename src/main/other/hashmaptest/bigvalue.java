package main.other.hashmaptest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class bigvalue {
    public static void main(String[] args) {

        long millis1 = System.currentTimeMillis();

        int n = (int)Math.pow(2,15);
        HashMap<testclass, Integer> map = new HashMap<>(n);
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            testclass testclass = new testclass();
            map.put(testclass,i);
        }

        long millis2 = System.currentTimeMillis();
        long time=millis2-millis1;//经过的毫秒数
        System.out.println(time+"ms");

        millis1 = System.currentTimeMillis();
        testclass testclass = new testclass();
        map.put(testclass,3);
        millis2 = System.currentTimeMillis();
        time=millis2-millis1;//经过的毫秒数
        System.out.println(time+"ms");





    }
    static class testclass{

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
