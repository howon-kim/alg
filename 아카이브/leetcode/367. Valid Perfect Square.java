/**
367. Valid Perfect Square
https://leetcode.com/problems/valid-perfect-square/

Submission Performance
Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
Memory Usage: 33.1 MB, less than 6.12% of Java online submissions for Valid Perfect Square.

Description
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
**/

class Solution {
    public boolean isPerfectSquare(int num) {
     return binarySearch(0, num, num);
    }
    public boolean binarySearch(int left, int right, int target) {
        int mid = (right + left) / 2;
        if (left > right) {
            return false;
        } else if (Math.pow(mid, 2) == target) {
            return true;
        } else if (Math.pow(mid, 2) < target) {
            return binarySearch(mid + 1, right, target);
        } else {
            return binarySearch(left, mid - 1, target);
        }
    }
}