/**
 * 189. Rotate Array | Easy
 * https://leetcode.com/problems/rotate-array/

 * My Submission Performance
 * Runtime: 2 ms, faster than 26.72% of Java online submissions for Rotate Array.
 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Rotate Array.

 * Description
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> temp = new LinkedList<>();
        k %= nums.length;

        for (int i = nums.length - k; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            temp.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp.poll();
        }
    }
}


