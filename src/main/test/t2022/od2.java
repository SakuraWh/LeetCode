package main.test.t2022;

import java.util.LinkedList;
import java.util.Scanner;

public class od2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // TODO
            int n = sc.nextInt();
            PriorQueue priorQueue = new PriorQueue();
            for (int i = 0; i < n; i++) {
                String c = sc.next();
                switch (c.charAt(0)) {
                    case 'a':
                        int num = sc.nextInt();//编号
                        int x = sc.nextInt();//优先级
                        priorQueue.add(num,x);
                        break;
                    case 'p':
                        int work = priorQueue.work();
                        System.out.println(work);
                        break;
                }
            }
        }
    }

    static class PriorQueue {
        LinkedList<Integer>[] arr = new LinkedList[5];

        public PriorQueue() {
            for (int i = 0; i < 5; i++) {
                arr[i] = new LinkedList<>();
            }
        }

        public void add(int num, int x) {
            arr[x - 1].addLast(num);
        }

        public int work() {
            for (int i = 0; i < 5; i++) {
                if (arr[i].size() == 0)
                    continue;
                return arr[i].removeFirst();
            }
            return -1;
        }


    }
}