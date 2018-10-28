package com.lsheng.algorithm.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-28 14:19
 */
public class TwoQueueStack {

    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueueStack(){
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public void push(Integer obj){
        queue.add(obj);
    }

    public Integer poll(){
        if (queue.isEmpty() && help.isEmpty()){
            throw new RuntimeException("the stack is empty");
        }

        while (queue.size() > 1){
            help.add(queue.poll());
        }

        int res = queue.poll();
        swap();
        return res;
    }

    public Integer peek(){
        if (queue.isEmpty() && help.isEmpty()){
            throw new RuntimeException("the stack is empty");
        }

        while (queue.size() > 1){
            help.add(queue.poll());
        }

        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        stack.poll();
        System.out.println(stack.peek());
    }

}
