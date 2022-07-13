package main.middle;

import main.algorithm.DataStruct.list.entity.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test_removeduplicatesfromsortedlistii {
    /*
        笨比解法
     */
    public ListNode deleteDuplicates1(ListNode head) {
        Map<Integer,Boolean> map = new HashMap<>();
        ListNode curr = head;
        while(curr!=null){
            if(map.containsKey(curr.val))
                map.put(curr.val,false);
            else
                map.put(curr.val,true);
            curr=curr.next;
        }
        ListNode h = new ListNode();
        ListNode t = h;
        curr = head;
        while(curr!=null){
            Boolean y = map.get(curr.val);
            if(y){
                t.next = new ListNode(curr.val);
                t= t.next;
            }
            curr=curr.next;
        }
        return h.next;
    }
    /*
        递归解法
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        if(head.val== head.next.val){
            //删除
            ListNode move = head;
            while(move!=null&&move.val==head.val)
                move=move.next;
            return deleteDuplicates(move);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
