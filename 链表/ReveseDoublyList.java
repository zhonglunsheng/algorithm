package com.lsheng.algorithm.linkedlist;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-31 22:05
 */
public class ReveseDoublyList {

    public static void main(String[] args) {
        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printList(reveseDoublyList(head2));
    }
    public static DoubleNode reveseDoublyList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printList(DoubleNode head){
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int date){
            this.value = date;
        }
    }
}

