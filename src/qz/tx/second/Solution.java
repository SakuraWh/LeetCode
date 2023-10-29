package qz.tx.second;

import java.util.*;


public class Solution {
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

        Solution solution = new Solution();
        solution.solve(a);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一个指向链表头部的指针。
     *
     * @param a ListNode类一维数组 指向这些数链的开头
     * @return ListNode类
     */
    public ListNode solve(ListNode[] a) {
        ListNode head = new ListNode(0);
        tail = head;
        while (true) {
            boolean b = getFirst(a, tail);
            if (!b)
                return head.next;
        }
    }

    ListNode tail, next;

    public boolean getFirst(ListNode[] a, ListNode tail) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null)
                break;
            min = Math.min(min, a[i].val);
        }
        if (min == Integer.MAX_VALUE)
            return false;
        for (int i = 0; i < a.length; i++) {
            tail.next = getValLink(a, i, min);
            tail = next;
        }
        return true;
    }

    public ListNode getValLink(ListNode[] a, int i, int val) {
        if (a[i] == null || a[i].val != val)
            return null;
        ListNode p = a[i].next, head = a[i], q = a[i];
        while (p != null && p.val == val) {
            p = p.next;
            q = q.next;
        }
        a[i] = p;
        q.next = null;
        next = q;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}