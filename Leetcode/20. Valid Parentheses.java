/**
20. Valid Parentheses

* My Submission Performance
Runtime: 1 ms, faster than 98.31% of Java online submissions for Valid Parentheses.
Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Valid Parentheses.

* Description
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

* Example
Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char p: s.toCharArray()){
            if (p == ')' || p == ']' || p == '}'){
                if (stack.empty()) {
                    return false;
                } else if (p == ')'){
                    if (stack.peek().equals('(')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (p == '}') {
                    if (stack.peek().equals('{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (p == ']') {
                    if (stack.peek().equals('[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else {
                stack.push(p);
            }
        }
        if (stack.empty()){
            return true;
        } else {
            return false;
        }
    }
}
