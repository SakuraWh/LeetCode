package main.test.t2023.hw;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Node> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i);
            map.put(i,node);
        }
        int root = -1;
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            if(x ==0){
                root = i;
            }

            for (int j = 0; j < x; j++) {
                int t = sc.nextInt();
                map.get(t).child.add(i);
            }
        }
        if(root==-1){
            System.out.println(root);
            return;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        int len = 1;
        while(!queue.isEmpty()){
            for (int i = 0; i < len; i++) {
                int num = queue.removeFirst();
                for (Integer x : map.get(num).child) {
                    queue.addLast(x);
                }
            }
            len = queue.size();
            count++;
        }
        System.out.println(count);

    }
    static class Node{
        int id;
        List<Integer> child;
        Node(int id){
            this.id = id;
            child = new ArrayList<>();
        }
    }
}
