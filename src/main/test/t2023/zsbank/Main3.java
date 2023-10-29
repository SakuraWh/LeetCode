package main.test.t2023.zsbank;

import java.util.*;

public class Main3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //LinkedList<Integer> list = new LinkedList<>();
        Node head = new Node();
        head.val = -1;
        Node tail = new Node();
        tail.val = Integer.MAX_VALUE;
        head.right = tail;
        tail.left = head;
        Node p;
        int max = 0;
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            char GL = sc.next().charAt(0);
            int bj = sc.nextInt();
            if (GL == 'G') {
                p = tail;
                while (p.val >= bj) {
                    p.count++;max = Math.max(p.count, max);
                    p = p.left;
                }
                if (p.val < bj) {
                    Node node = new Node();
                    node.val = bj;
                    node.count = p.right.count;
                    node.insert(p, p.right);
                }
            } else {
                p = head;
                while (p.val <= bj) {
                    p.count++;max = Math.max(p.count, max);
                    p = p.right;
                }
                if (p.val < bj) {
                    Node node = new Node();
                    node.val = bj;
                    node.count = p.left.count;
                    node.insert(p.left, p);
                }
            }
        }

        System.out.println(N - max);
    }

    static class Node {
        Node left;
        Node right;
        int val;
        int count;

        void insert(Node a, Node b) {
            left = a;
            right = b;
            a.right = this;
            b.left = this;
        }
    }

}
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//
//        int N = sc.nextInt();
//        List<Fw> fw = new ArrayList<>();
//        fw.add(new Fw());
//        for (int i = 0; i < N; i++) {
//            char GL = sc.next().charAt(0);
//            int bj = sc.nextInt();
//            if (GL == 'G'){
//                for (Fw fw1 : fw) {
//                    if (fw1.add(bj)) {
//                        fw1.updateLeft(bj);
//                    }else {
//                        Fw fw2 = new Fw();
//                        fw2.add(bj);
//                        fw2.updateLeft(bj);
//                        fw.add(fw2);
//                    }
//                    break;
//                }
//            }else {
//                for (Fw fw1 : fw) {
//                    if (fw1.add(bj)) {
//                        fw1.updateRight(bj);
//                    }else {
//                        Fw fw2 = new Fw();
//                        fw2.add(bj);
//                        fw2.updateRight(bj);
//                        fw.add(fw2);
//                    }
//                    break;
//                }
//            }
//        }
//        if(fw.size()==1)
//            System.out.println(0);
//        else {
//            int max = 0;
//            for (int i = 0; i < fw.size(); i++) {
//                max = Math.max(fw.get(i).count,max);
//            }
//            System.out.println(N-max);
//        }
//    }
//
//    static class Fw {
//        int upper;
//        int lower;
//        int count = 0;
//
//        Fw() {
//            upper = Integer.MAX_VALUE;
//            lower = Integer.MIN_VALUE;
//            count = 0;
//        }
//
//        boolean inFw(int x) {
//            if (x > upper || x < lower)
//                return false;
//            return true;
//        }
//        boolean add(int x){
//            if (inFw(x)){
//                count++;
//                return true;
//            }
//            return false;
//        }
//        void updateLeft(int left){
//            lower = Math.max(left,lower);
//        }
//        void updateRight(int right){
//            upper = Math.min(right,upper);
//        }
//
//
//
//    }

