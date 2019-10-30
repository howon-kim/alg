/**
704. Binary Search
https://leetcode.com/problems/binary-search/

Submission Performance
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
Memory Usage: 39.3 MB, less than 94.59% of Java online submissions for Binary Search.

Description
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
**/

class Solution {
    public int search(int[] nums, int target) {
       return binarySearch(nums, 0, nums.length, target);
    }
    
    public int binarySearch(int[] nums, int left, int right, int target) {
        int mid = (right + left) / 2;
        if (mid >= nums.length || left > right) {
            return -1;
        } else if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return binarySearch(nums, left, mid - 1, target);
        }
    }
}