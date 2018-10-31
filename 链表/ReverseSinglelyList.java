package com.lsheng.algorithm.linkedlist;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-31 21:46
 */
public class ReverseSinglelyList {

    public static Node reverseSinglelyList(Node head){
       Node pre = null;
       Node next = null;

       while (head != null){
          next = head.next;
          head.next = pre;
          pre = head;
          head = next;
       }
       return pre;
    }

    static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }

    }
}
