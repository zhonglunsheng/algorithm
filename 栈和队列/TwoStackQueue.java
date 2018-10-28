package com.lsheng.algorithm.stackandqueue;

import java.util.Stack;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-28 14:34
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(Integer obj){
        stackPush.push(obj);
    }


    public Integer pop(){
        if (stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("the stack is empty");
        }
        if (stackPop.empty()){
            while(! stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public Integer peek(){
        if (stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("the stack is empty");
        }
        if (stackPop.empty()){
            while(! stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
    }
}
