/**

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Runtime: 1 ms, faster than 89.47% of Java online submissions for Maximum Subarray.
Memory Usage: 43.1 MB, less than 5.02% of Java online submissions for Maximum Subarray.

**/

class Solution {
    public int maxSubArray(int[] nums) {
        int total = 0; int max = nums[0];
        for (int num: nums){
            total += num;
            if (num > total) {
                total = num;
            }
            if (total > max) {
                max = total;
            }
        }
        return max;
    }
}