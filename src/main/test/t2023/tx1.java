package main.test.t2023;

import main.algorithm.DataStruct.list.entity.ListNode;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */
public class tx1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] list = new ListNode[5];
        for (int i = 1; i <= 5; i++) {
            list[i-1] = new ListNode(i);
        }
        for (int i = 0; i < 4; i++) {
            list[i].next = list[i+1];
        }


        System.out.println(solution.reorderList(list[0]));
    }
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode reorderList(ListNode head) {
        // write code here
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);

            p = p.next;

            if(p == null)
                break;
            ListNode t = p.next;
            p.next = null;
            p = t;
        }
        List<ListNode> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i+=2) {
            ListNode b;
            if (list.size()<=i+1)
                b=null;
            else
                b = list.get(i + 1);
            ListNode swap = swap(list.get(i), b);
            res.add(swap);
        }
        for (int i = 0; i < res.size() -1; i++) {
            ListNode next = getNext(list.get(i));
            next.next = res.get(i+1);
        }
        return res.get(0);


    }
    public ListNode getNext(ListNode a){
        ListNode q = a;
        while(q.next!=null){
            q=q.next;
        }
        return q;
    }

    public ListNode swap(ListNode a,ListNode b){
        if (b == null)
            return a;
        if(b.next == null)
            b.next = a;
        else
            b.next.next = a;
        return b;
    }
}