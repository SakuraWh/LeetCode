package main.hard;

import main.algorithm.DataStruct.list.entity.ListNode;

public class Test_reversenodesinkgroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode();
        ListNode q = root;
        q.next = head;
        ListNode p = q;
        while (q != null) {
            for (int i = 0; i < k && q != null; i++) {
                q = q.next;
            }
            if (q == null)
                break;
            ListNode t = q.next;
            q.next = null;
            q = p.next;
            p.next = reverse(p.next);
            q.next = t;
            p = q;

        }
        return root.next;

    }

    public static ListNode reverse(ListNode head) {
        ListNode root = new ListNode();
        ListNode p = head;
        root.next = null;
        while (p != null) {
            ListNode t = p.next;
            p.next = root.next;
            root.next = p;
            p = t;
        }
        return root.next;

    }

    public static void main(String[] args) {
        ListNode[] listNode = new ListNode[5];
        for (int i = 0; i < 5; i++) {
            listNode[i] = new ListNode(i);
        }
        for (int i = 0; i < 4; i++) {
            listNode[i].next = listNode[i + 1];
        }
        reverseKGroup(listNode[0], 2);
    }

}
