package qz.jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1); // 返回 1
        cache.put(3, 3); // 该操作会使得关键字 2 作废
        cache.get(2); // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得关键字 1 作废
        cache.get(1); // 返回 -1 (未找到)
        cache.get(3); // 返回 3
        cache.get(4); // 返回 4
    }

    public static class LRUCache {

        Map<Integer,Node> map = new HashMap<>();
        Node head,tail;
        int maxSize,count;

        public LRUCache(int maxSize){
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.pre = head;
            this.maxSize = maxSize;
            count=0;
        }

        public int get(Integer key){
            if(!map.containsKey(key)){
                return -1;
            }
            // 移动
            Node d = map.get(key);
            d.pre.next = d.next;
            d.next.pre = d.pre;

            d.pre = head;
            d.next = head.next;
            head.next = d;
            d.next.pre = d;

            return d.val;
        }

        public void put(Integer key,Integer value){
            Node t = map.getOrDefault(key,new Node(value));
            // move
            if(t.pre!=null||t.next!=null){
                t.pre.next = t.next;
                t.next.pre = t.pre;
            }

            if(count >= maxSize){
                // delete
                Node d = tail.pre;
                d.pre.next = tail;
                tail.pre = d.pre;
                map.remove(d.val);
                count--;
            }
            t.pre = head;
            t.next = head.next;
            head.next = t;
            t.next.pre = t;
            map.put(key, t);
            count++;
        }

    }

    public static class Node{
        public int val;
        public Node pre,next;

        public Node(int val){
            this.val = val;
        }
    }
}