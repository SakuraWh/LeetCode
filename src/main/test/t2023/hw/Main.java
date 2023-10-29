package main.test.t2023.hw;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
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

    static class Pool {
        LinkedNode head,tail;
        Map<Integer, LinkedNode> map;
        int left;
        int right;
        int len;

        Pool(int left, int right) {
            this.left = left;
            this.right = right;
            head = new LinkedNode(0);
            tail = new LinkedNode(0);
            head.next = tail;
            tail.pre = head;

            map = new HashMap<>();
            for (int i = left; i <= right; i++) {
                len ++;
                LinkedNode node = new LinkedNode(i);
                map.put(i, node);
                node.pre = tail.pre;
                node.next = tail;
                tail.pre.next = node;
                tail.pre = node;
            }

        }

        public void func1(int x) {
            // 动态分配
//            if (x > len)
//                return;
            for (int i = 0; i < x; i++) {
                if (len==0)
                    return;
                LinkedNode first = head.next;
                deleteNode(first);
                len --;
            }
        }

        public void func2(int x) {
            // 指定分配
            if(!map.containsKey(x))
                return;
            LinkedNode node = map.get(x);
            if (inPool(node)){
                deleteNode(node);
                len--;
            }
        }

        public void func3(int x) {
            // 释放
            if (!map.containsKey(x))
                    return;

            LinkedNode node = map.get(x);
            if (inPool(node))
                return;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            len++;
        }

        public int getHead() {
            return head.next.val;
        }

        private boolean inPool(LinkedNode node){
            if(node.pre == null||node.next==null)
                return false;
            return true;
        }

        private void deleteNode(LinkedNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
        }

        class LinkedNode{
            LinkedNode pre,next;
            int val;

            public LinkedNode(int val) {
                this.val = val;
            }
        }
    }
}
