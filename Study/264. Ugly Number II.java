/**
 * 264. Ugly Number II | Medium | 50 Min
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * Performance
 * Runtime: 3 ms, faster than 57.24% of Java online submissions for Ugly Number II.
 * Memory Usage: 34.5 MB, less than 54.55% of Java online submissions for Ugly Number II.
 *
 * Description
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:  
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 **/

class Solution {
    public int nthUglyNumber(int n) {
        int [] lst = new int[n];
        lst[0] = 1;
        int f2 = 0; int f3 = 0; int f5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(lst[f2] * 2, lst[f3] * 3), lst[f5] * 5);
            lst[i] = min;

            if (lst[i] == lst[f2] * 2) f2++;
            if (lst[i] == lst[f3] * 3) f3++;
            if (lst[i] == lst[f5] * 5) f5++;
        }
        return lst[n - 1];
    }
}

