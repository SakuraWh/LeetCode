package main.test.t2023;

import java.math.BigDecimal;
import java.util.*;

public class xc4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for (int i = 0; i < n - 1; i++) {
            int source = sc.nextInt();
            int target = sc.nextInt();
            int width = sc.nextInt();
            Edge edge = new Edge(source, target, width);

            list.add(edge);
        }
        dfs(new BigDecimal(0));
        System.out.println(max);


    }

    static List<Edge> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static BigDecimal max = new BigDecimal(0);

    public static void dfs(BigDecimal sum) {
        max = (max.compareTo(sum) > 0 ? max : sum);
        boolean change = false;
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            if (set.contains(edge.head) || set.contains(edge.tail))
                continue;
            set.add(edge.head);
            set.add(edge.tail);

            dfs(sum.add(BigDecimal.valueOf(edge.weight)));
            set.remove(edge.head);
            set.remove(edge.tail);
            change = true;
        }
        if (!change)
            return;
    }


    public static class Edge {
        int head;
        int tail;
        int weight;

        public Edge(int head, int tail, int weight) {
            this.head = head;
            this.tail = tail;
            this.weight = weight;
        }
    }
}


//            List<Edge> l1 = map.getOrDefault(edge.head, new ArrayList<>());
//            l1.add(edge);
//            map.put(edge.head, l1);
//
//            List<Edge> l2 = map.getOrDefault(edge.tail, new ArrayList<>());
//            l2.add(edge);
//            map.put(edge.tail, l2);

//    static Map<Integer, List<Edge>> map = new HashMap<>();