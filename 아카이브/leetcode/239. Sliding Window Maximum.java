/**
 * 239. Sliding Window Maximum | Hard | 70 Min
 * https://leetcode.com/problems/sliding-window-maximum/
 
 * MY SUBMISSION PERFORMANCE
 * Runtime: 25 ms, faster than 28.25% of Java online submissions for Sliding Window Maximum.
 * Memory Usage: 40.4 MB, less than 93.75% of Java online submissions for Sliding Window Maximum.
 
 * DESCRIPTION
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        int answerindex = 0;
        int max = k;
        int min = 0;
        int maxindex = 0;
        int maxnum = Integer.MIN_VALUE;
        while (max <= nums.length) {
            for (; index < max; index++) {
                if (maxnum <= nums[index]) {
                    maxindex = index;
                    maxnum = nums[index];
                }
            }
            ans[answerindex++] = maxnum;
            if (maxindex == min) {
                min++;
                index = min;
                maxnum = Integer.MIN_VALUE;
            } else {
                min++;
                index = maxindex;
            }
            max++;
        }
        return ans;
    }
}