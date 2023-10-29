package main.hard;

import main.algorithm.DataStruct.list.entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test_mergeksortedlists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode t : lists) {
            while (t != null) {
                heap.add(t);
                t = t.next;
            }
        }

        ListNode head = new ListNode();
        ListNode p = head;
        while(heap.size()!=0){
            p.next = heap.poll();
            p = p.next;
        }
        return head.next;
    }
}
