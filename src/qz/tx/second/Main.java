package qz.tx.second;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ListNode[] a = new ListNode[3];
        a[0] = new ListNode(1);
        a[0].next = new ListNode(3);
        a[0].next.next = new ListNode(5);

        a[1] = new ListNode(2);
        a[1].next = new ListNode(4);
        a[1].next.next = new ListNode(6);

        a[2] = new ListNode(1);
        a[2].next = new ListNode(2);
        a[2].next.next = new ListNode(3);
        a[2].next.next.next = new ListNode(4);
        a[2].next.next.next.next = new ListNode(5);
        a[2].next.next.next.next.next = new ListNode(6);

        solve(a);

    }

    public static ListNode solve(ListNode[] a) {
        Map<Integer, ListNode> map = new HashMap<>();
        Map<Integer, ListNode> tail = new HashMap<>();
        for (ListNode p : a) {
            while (p != null) {
                ListNode q = p.next;
                p.next = null;
                ListNode t = map.get(p.val);
                if (t == null) {
                    map.put(p.val, p);
                    tail.put(p.val, p);
                } else {
                    p.next = t;
                    map.put(p.val,p);
                }
                p = q;
            }
        }
        ListNode head = new ListNode(0);
        ListNode tt = head;
        for (Integer key : map.keySet()) {
            ListNode list = map.get(key);
            ListNode t = tail.get(key);
            tt.next = list;
            tt = t;
        }
        return head.next;
    }
}




