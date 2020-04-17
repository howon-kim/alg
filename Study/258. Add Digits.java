/**
258. Add Digits | Easy
https://leetcode.com/problems/add-digits/


Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?


Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Digits.
Memory Usage: 36.7 MB, less than 6.67% of Java online submissions for Add Digits.
 */

class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int count = 0;
            while (num != 0) {
                count += (num % 10);
                num /= 10;
            }
            num = count;
        }
        return num;
    }
}