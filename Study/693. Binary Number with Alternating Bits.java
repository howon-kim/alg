/**
693. Binary Number with Alternating Bits | Easy
https://leetcode.com/problems/binary-number-with-alternating-bits/


Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:

Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:

Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
Example 3:

Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
Example 4:

Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.


Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Number with Alternating Bits.
Memory Usage: 36.2 MB, less than 12.50% of Java online submissions for Binary Number with Alternating Bits.
O(1)
*/

class Solution {
    public boolean hasAlternatingBits(int n) {
        int compare = n % 2; n /= 2;
        while (n != 0) {
            if (compare == (n % 2)) return false;
            compare = n % 2;
            n /= 2;
        }
        return true;
    }
}