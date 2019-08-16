class Solution {
    /**
     * 55. Jump Game | Medium
     * https://leetcode.com/problems/jump-game/
     *
     * My Submission Performance
     * Runtime: 1 ms, faster than 99.26% of Java online submissions for Jump Game.
     * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Jump Game.
     *
     * Description
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     * Example 1:
     *
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     *              jump length is 0, which makes it impossible to reach the last index.
     */

    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--)
            if (nums[i]  + i >= end) end = i;
        return end == 0;
    }
}