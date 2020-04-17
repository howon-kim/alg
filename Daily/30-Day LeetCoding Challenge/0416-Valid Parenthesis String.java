/**
Valid Parenthesis String


Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:

Input: "()"
Output: True
Example 2:

Input: "(*)"
Output: True
Example 3:

Input: "(*))"
Output: True
Note:

The string size will be in the range [1, 100].
 */

class Solution {
    public boolean checkValidString(String s) {
        int L = 0; int R = 0;
        
        for (char c: s.toCharArray()) {
            if (c == ')') R--;
            else R++;
            
            if (c == '(') L++;
            else L--;   
            
            if (R < 0) return false;
            L = Math.max(0, L);
        }

        if (L == 0) return true;
        else return false;
    }
}

