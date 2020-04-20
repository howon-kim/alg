/**
945. Minimum Increment to Make Array Unique | Medium
https://leetcode.com/problems/minimum-increment-to-make-array-unique/


Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every value in A unique.

 

Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 

Note:

0 <= A.length <= 40000
0 <= A[i] < 40000


Runtime: 12 ms, faster than 79.33% of Java online submissions for Minimum Increment to Make Array Unique.
Memory Usage: 47.6 MB, less than 83.33% of Java online submissions for Minimum Increment to Make Array Unique.
 */

class Solution {
    public int minIncrementForUnique(int[] A) {
        int count = 0;
        Arrays.sort(A);

        for (int i = 1; i < A.length; i++) {
            int need = A[i - 1] + 1;

            if (A[i - 1] >= A[i]) {
                count += (need - A[i]);
                A[i] = need;
            }
        }
        
        return count;
    }
}