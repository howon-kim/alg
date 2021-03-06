/**
 * 326. Power of Three | Easy
 * https://leetcode.com/problems/power-of-three/

 * My Submission Performance
 * Runtime: 12 ms, faster than 17.49% of Java online submissions for Power of Three.
 * Memory Usage: 36.4 MB, less than 6.25% of Java online submissions for Power of Three.

 * Description
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 *
 * Input: 27
 * Output: true
 * Example 2:
 *
 * Input: 0
 * Output: false
 * Example 3:
 *
 * Input: 9
 * Output: true
 * Example 4:
 *
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 */


class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}