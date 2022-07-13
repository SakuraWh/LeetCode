package main.easy;

import main.algorithm.DataStruct.list.entity.ListNode;

public class Test_removeduplicatesfromsortedlist {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == curr.val) {
                curr.next = curr.next.next;
            }
            curr=curr.next;
        }
        return head;
    }

}
