/**
Maximum Subarray



Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.



202 / 202 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 39.5 MB
**/

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE; int curr = 0;
        for (int num: nums) {
            curr = Math.max(num, curr + num);
            max = Math.max(curr, max);
        }
        return max;
    }
}