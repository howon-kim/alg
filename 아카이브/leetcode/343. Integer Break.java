/**
343. Integer Break | Medium
https://leetcode.com/problems/integer-break/


Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.


Runtime: 0 ms, faster than 100.00% of Java online submissions for Integer Break.
Memory Usage: 36 MB, less than 14.29% of Java online submissions for Integer Break.
O(1)
 */

class Solution {
    public int integerBreak(int n) {
        if (n < 4) return n - 1;
        int max = 1;
        
        while (n != 0) {
            if (n <= 4) {
                max *= n;
                n = 0;
            } else {
                max *= 3;
                n -= 3;
            }
        }
        
        return max;
    }
}