/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false

Notes:

You must use only standard operations of a stack -- which means 
only push to top, peek/pop from top, size, and is empty operations 
are valid.

Depending on your language, stack may not be supported natively. 
You may simulate a stack by using a list or deque (double-ended 
queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no 
pop or peek operations will be called on an empty queue).
*/

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// // push O(1) pop O(n) peek O(n): 40%
// public class LeetCode232ImplementQueueUsingStacks {
// 	private Stack<Integer> stack;
// 	private Stack<Integer> tmp;

//     /** Initialize your data structure here. */
//     public MyQueue() {
//         this.stack = new Stack<>();
//         this.tmp = new Stack<>();
//     }
    
//     /** Push element x to the back of queue. */
//     public void push(int x) {
//         this.stack.push(x);
//     }
    
//     /** Removes the element from in front of queue and returns that element. */
//     public int pop() {
//         while (!stack.isEmpty()) tmp.push(stack.pop());
//         int front = tmp.pop();
//         while (!tmp.isEmpty()) stack.push(tmp.pop());
//         return front;
//     }
    
//     /** Get the front element. */
//     public int peek() {
//         while (!stack.isEmpty()) tmp.push(stack.pop());
//         int front = tmp.peek();
//         while (!tmp.isEmpty()) stack.push(tmp.pop());
//         return front;
//     }
    
//     /** Returns whether the queue is empty. */
//     public boolean empty() {
//         return stack.isEmpty();
//     }
// }

// push O(n) pop O(1) peek O(1): 80%
public class LeetCode232ImplementQueueUsingStacks {
	private Stack<Integer> stack;
	private Stack<Integer> tmp;

    /** Initialize your data structure here. */
    public LeetCode232ImplementQueueUsingStacks() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty()) tmp.push(stack.pop());
        tmp.push(x);
        while (!tmp.isEmpty()) stack.push(tmp.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}