package main.test.t2023.mhy;

import java.util.*;

public class mhy2 {
    static Map<Integer, Integer> map = new HashMap<>();
    static Container container = new Container();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b[] = new int[n - 1];
        //int dp[] = new int[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 1; i < b[0]; i++) {
            container.add(i, b[0] - i);
        }

        for (int i = 1; i < b.length; i++) {
            //依次判断头是否在container的尾巴集合中，删除所有不在的数
            List<int[]> list = new ArrayList<>();
            for (int j = 1; j < b[i]; j++) {
                if (j > container.max)
                    break;//优化
                if (container.tail.containsKey(j)) {
                    //表示存在 加入新集合
                    list.add(new int[]{j, b[i] - j});
                }
            }
            //将剩下的数加入集合
            container.clearAll();
            for (int[] ints : list) {
                container.add(ints[0], ints[1]);
            }
        }
        System.out.println(container.head.size());

    }

    static class Container {
        Map<Integer, Integer> head = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();
        int max = Integer.MIN_VALUE;

        Container() {
        }

        public void add(int h, int t) {
            head.put(h, t);
            tail.put(t, h);
            max = Math.max(max, t);// 优化
        }

//        public void removeHead(int h) {
//            Integer t = head.get(h);
//            tail.remove(t);
//            head.remove(h);
//        }
//
//        public void removeTail(int t) {
//            Integer h = tail.get(t);
//            head.remove(h);
//            tail.remove(t);
//        }

        public void clearAll() {
            head.clear();
            tail.clear();
            max = Integer.MIN_VALUE;
        }
    }

    public static void addContainer(int n) {

    }
}
