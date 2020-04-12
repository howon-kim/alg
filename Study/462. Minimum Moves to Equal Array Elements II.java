/**
462. Minimum Moves to Equal Array Elements II | Medium
https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/


Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]


Runtime: 2 ms, faster than 96.50% of Java online submissions for Minimum Moves to Equal Array Elements II.
Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for Minimum Moves to Equal Array Elements II.
O(nlogn)
 */

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int start = 0; int end = nums.length - 1;
        int total = 0;
        
        while (end > start) {
            total += (mid - nums[start++]);
            total += (nums[end--] - mid);
        }
        
        return total;
    }
}

