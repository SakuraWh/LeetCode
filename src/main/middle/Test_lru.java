package main.middle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test_lru {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }


}

class LRUCache {

    class TwoNode {
        int key;
        int val;
        TwoNode pre;
        TwoNode next;

        public TwoNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity
     * ，则应该 逐出 最久未使用的关键字。
     */
    int capacity;
    int len;
    TwoNode head, tail;
    Map<Integer, TwoNode> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
        head = new TwoNode(-1, -1);
        tail = new TwoNode(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            TwoNode t = map.get(key);
            deleteA(t);
            insertBackA(head, t);
            return t.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            TwoNode t = map.get(key);
            deleteA(t);
            t.val = value;
            insertBackA(head, t);
        } else {
            TwoNode t = new TwoNode(key, value);
            insertBackA(head, t);
            map.put(key, t);
            len++;
            if (len > capacity) {
                map.remove(tail.pre.key);
                deleteA(tail.pre);
                len--;
            }
        }
    }

    private void insertBackA(TwoNode A, TwoNode node) {
        TwoNode t = A.next;
        A.next = node;
        node.pre = A;
        node.next = t;
        if (t != null)
            t.pre = node;
    }

    private void deleteA(TwoNode node) {
        TwoNode pre = node.pre;
        TwoNode next = node.next;
        pre.next = next;
        if (next != null)
            next.pre = pre;
        node.pre = null;
        node.next = null;
    }
}
