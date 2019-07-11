/*
Design a stack that supports push, pop, top, and retrieving the
minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class LeetCode155MinStack {
    private List<Integer> stack;
    private List<Integer> minList;
    private int min;

    /** initialize your data structure here. */
    public LeetCode155MinStack() {
        stack = new ArrayList<>();
        minList = new ArrayList<>();
        min = Integer.MAX_VALUE;
        minList.add(min);
    }

    public void push(int x) {
        stack.add(x);
        if (x <= min) {
            min = x;
            minList.add(x);
        }
    }

    public void pop() {
        int end = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        if (end == min) {
            minList.remove(minList.size() - 1);
            min = minList.get(minList.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
