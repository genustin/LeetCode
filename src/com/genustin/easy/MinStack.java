package com.genustin.easy;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Genustin on 11/12/14.
 * Design a stack that supports push, pop, top,
 * and retrieving the minimum element in constant time.
 */
public class MinStack {
    private Deque<Integer> stack = new LinkedList<Integer>();
    private Deque<Integer> min   = new LinkedList<Integer>();

    public void push(int x) {
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(-1024);
        ms.push(-1024);
        ms.push(1);
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
