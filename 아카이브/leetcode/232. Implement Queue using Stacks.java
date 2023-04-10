/**
232. Implement Queue using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/

Runtime: 41 ms, faster than 99.71% of Java online submissions for Implement Queue using Stacks.
Memory Usage: 34.1 MB, less than 20.83% of Java online submissions for Implement Queue using Stacks.

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

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
**/

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Boolean isFirst;
    int first;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        isFirst = false;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (!isFirst) {
            first = x;
            isFirst = true;
        }
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()) {
            int temp = stack2.pop();
            if (!stack2.isEmpty()) { first = stack2.peek(); }
            else {
                while (!stack1.isEmpty()) { stack2.push(stack1.pop()); }
                if (!stack2.isEmpty()) { first = stack2.peek(); }
                else { isFirst = false; } 
            }
            return temp;
        } else {
            while (!stack1.isEmpty()) { stack2.push(stack1.pop()); }
            int temp = stack2.pop();
            if (!stack2.isEmpty()) { first = stack2.peek(); }
            else { isFirst = false; }
            return temp;
        }
    }
    
    /** Get the front element. */
    public int peek() {
        return first;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */