package main.middle;

import java.util.List;

public class Daily_designlinkedlist {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
//        obj.addAtHead(1);
//        obj.addAtTail(3);
//        obj.addAtIndex(1, 2);
//        System.out.println(obj.get(1));
//        obj.deleteAtIndex(1);
//        System.out.println(obj.get(1));
        obj.addAtHead(1);
        obj.deleteAtIndex(0);
    }

    static class MyLinkedList {
        class Node {
            int val;
            Node next;
            Node pre;

            Node() {
                val = 0;
                next = null;
                pre = null;

            }

            Node(int val) {
                this.val = val;
                next = null;
                pre = null;

            }
        }

        Node head, tail;
        int length;

        public MyLinkedList() {
            head = new Node();
            tail = head.next;
            length = 0;
        }

        public int get(int index) {
            if (index < 0 || index > length)
                return -1;
            Node p = head;
            while (index >= 0) {
                p = p.next;
                index--;
            }
            return p.val;
        }

        public void addAtHead(int val) {
            Node t = new Node(val);
            t.next = head.next;
            t.pre = head;
            if (tail != head.next) {
                head.next.pre = t;
            }
            head.next = t;
            if(tail == null)
                tail = t;
            length++;
        }

        public void addAtTail(int val) {
            Node t = new Node(val);
            tail.next = t;
            t.pre = tail;
            tail = t;
            length++;
        }

        public void addAtIndex(int index, int val) {
            if (index == length)
                addAtTail(val);
            else if (index > length)
                return;
            if (index < 0)
                addAtHead(val);

            Node p = head;
            while (index > 0) {
                p = p.next;
                index--;
            }
            Node t = new Node(val);
            t.next = p.next;
            t.pre = p;
            p.next.pre = t;
            p.next = t;
            length++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index > length)
                return;

            Node p = head;
            while (index > 0) {
                p = p.next;
                index--;
            }
            if(p.next==tail){
                tail=p;
                p.next = null;
                return;
            }
            p.next.next.pre = p;
            p.next = p.next.next;
            length--;

        }
    }

}
