package com.lsheng.algorithm.stackandqueue;

import java.util.Stack;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2018-10-28 10:43
 */
public class GetMinStack {

    private Stack<Integer> stack;
    private Stack<Integer> helpStack;


    public GetMinStack(){
        stack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(Integer obj){
        stack.push(obj);
        Integer value = ! helpStack.empty() && helpStack.peek() < obj ? helpStack.peek() : obj;
        helpStack.push(value);
    }

    public Integer pop(){
        if (stack.empty()){
            throw new RuntimeException("the stack is empty");
        }
        helpStack.pop();
        return stack.pop();
    }

    public Integer getMin(){
        if (stack.empty()){
            throw new RuntimeException("the stack is empty");
        }
        return helpStack.peek();
    }
}
