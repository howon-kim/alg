/**
Min Stack
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/


Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

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


18 / 18 test cases passed.
Status: Accepted
Runtime: 4 ms
Memory Usage: 41.3 MB

 */

class MinStack {

    ArrayList<Integer> alist;
    ArrayList<Integer> min;
    int size;
    /** initialize your data structure here. */
    public MinStack() {
        alist = new ArrayList<>();
        min = new ArrayList<>();
        size = 0;
    }
    
    public void push(int x) {
        alist.add(x);
        if (min.size() == 0 || x < alist.get(min.get(min.size() - 1))) {
            min.add(size);
        }
        size++;
    }
    
    public void pop() {
        if (min.get(min.size() - 1) == size - 1) {
            min.remove(min.size() - 1);
        }
        alist.remove(--size);
    }
    
    public int top() {
        return alist.get(size - 1);
    }
    
    public int getMin() {
        return alist.get(min.get(min.size() - 1));
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */