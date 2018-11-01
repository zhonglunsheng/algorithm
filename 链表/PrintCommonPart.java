package com.lsheng.algorithm.linkedlist;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-11-01 14:01
 */
public class PrintCommonPart {
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printCommonPart(node1, node2);

    }

    public static void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value == head2.value) {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                head1 = head1.next;
            }
            System.out.println();
        }
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
