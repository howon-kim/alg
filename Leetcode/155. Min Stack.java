/**
155. Min Stack
https://leetcode.com/problems/min-stack/

* My Submission Performance
Runtime: 45 ms, faster than 99.27% of Java online submissions for Min Stack.
Memory Usage: 40.4 MB, less than 30.73% of Java online submissions for Min Stack.

* Description
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
*/

class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> min;
    int mintemp;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
        mintemp = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x < mintemp) {
            mintemp = x;
        }            
        min.push(mintemp);
        stack.push(x);
    }
    
    public void pop() {
        stack.pop();  
        min.pop();
        if (min.size() == 0){
            mintemp = Integer.MAX_VALUE;
        } else {
            mintemp = min.peek();
        }
    }
    
    public int top() {        
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
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

 /** My First Approach **
 class MinStack {
    
    List<Integer> lst;
    Queue<Integer> min;
    int size;
    
    public MinStack() {
        lst = new ArrayList<>();    
        min = new PriorityQueue<>();
        size = 0;
    }
    
    public void push(int x) {
        lst.add(x);
        min.add(x);
        size++;
    }
    
    public void pop() {
        if (min.peek() == lst.get(size - 1)){
            min.remove();
        }
        lst.remove(--size);      
    }
    
    public int top() {
        return lst.get(size - 1);
    }
    
    public int getMin() {
        while (!lst.contains(min.peek())) {
            min.remove();
        }
        return min.peek();
    }
}
*/