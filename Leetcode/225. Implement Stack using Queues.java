/**
 * 225. Implement Stack using Queues | Easy
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * My Submission Performance :: 
 * Runtime: 42 ms, faster than 82.64% of Java online submissions for Implement Stack using Queues.
 * Memory Usage: 33.9 MB, less than 91.67% of Java online submissions for Implement Stack using Queues.
 *
 * Description :: 
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */

class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;
    boolean useQueue1;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        useQueue1 = true;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        if (useQueue1) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (useQueue1) {
            while (queue1.size() > 1) {
                top = queue1.poll();
                queue2.add(top);
            }
            useQueue1 = false;
            return queue1.poll();
        } else {
            while (queue2.size() > 1) {
                top = queue2.poll();
                queue1.add(top);
            }
            useQueue1 = true;
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (useQueue1) {
            return queue1.isEmpty();
        } else {
            return queue2.isEmpty();
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */