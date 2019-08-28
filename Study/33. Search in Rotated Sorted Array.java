class Solution {
    /**
     * 33. Search in Rotated Sorted Array | Medium
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     *
     * My Submission Performance
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     * Memory Usage: 40.4 MB, less than 9.44% of Java online submissions for Search in Rotated Sorted Array.
     *
     * Description
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */

    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return 0;

        int start = 0; int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            if (start + 1 >= end) return -1;
            if (nums[start + 1] > nums[start]) start++;
            if (nums[end - 1] < nums[end]) end--;
        }
        return -1;
    }
}