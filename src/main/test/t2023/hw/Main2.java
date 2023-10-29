package main.test.t2023.hw;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        Pool pool = new Pool(left,right);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int mode = sc.nextInt();
            int x = sc.nextInt();
            switch (mode){
                case 1:pool.func1(x);break;
                case 2:pool.func2(x);break;
                case 3:pool.func3(x);break;
            }
        }
        System.out.println(pool.getHead());
    }
    static class Pool{
        Map<Integer,Boolean> map;
        LinkedList<Integer> list;

        public Pool(int left,int right) {
            map = new HashMap<>();
            list = new LinkedList<>();
            for (int i = left; i <= right; i++) {
                list.addLast(i);
                map.put(i,true);
            }
        }
        public void func1(int x) {
            // 动态分配
            if (x>list.size())
                return;

            for (int i = 0; i < x; i++) {
                Integer first = list.removeFirst();
                map.put(first,false);
            }
        }

        public void func2(int x) {
            // 指定分配
            if (!map.containsKey(x))
                return;
            if (map.get(x) == false)
                return;
            list.removeFirstOccurrence(x);
            map.put(x,false);
        }

        public void func3(int x) {
            // 释放
            if (!map.containsKey(x))
                return;
            if (map.get(x) == true)
                return;
            list.addLast(x);
            map.put(x,true);
        }

        public int getHead(){
            return list.getFirst();
        }
    }


}
