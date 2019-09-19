/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false

Notes:

You must use only standard operations of a queue -- 
which means only push to back, peek/pop from front, 
size, and is empty operations are valid.

Depending on your language, queue may not be supported 
natively. You may simulate a queue by using a list or 
deque (double-ended queue), as long as you use only 
standard operations of a queue.

You may assume that all operations are valid (for 
example, no pop or top operations will be called on 
an empty stack).
*/

import java.util.Queue;
import java.util.LinkedList;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// push: O(1) pop: O(n) time: 78.67% 
public class LeetCode225ImplementStackusingQueues {
	private Queue<Integer> queue;
	private int top;

	/** Initialize your data structure here. */
    public LeetCode225ImplementStackusingQueues() {
        this.queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.offer(x);
        this.top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = this.queue.size();
        int first = 0;

        for (int i = 0; i < size - 1; i++) {
        	first = this.queue.poll();
        	this.queue.offer(first);
        }

        this.top = first;
        return this.queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return this.top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.isEmpty();
    }
}