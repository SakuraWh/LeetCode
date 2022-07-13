package main.easy;

import main.algorithm.DataStruct.list.entity.ListNode;

public class Test_reverselinkedlist {
    public ListNode reverseList(ListNode head) {
        ListNode t = new ListNode(0);
        ListNode p = head.next;
        while(head!=null){
            p=head.next;
            head.next = t.next;
            t.next=head;
            head=p;
        }
        return t.next;
    }
}
