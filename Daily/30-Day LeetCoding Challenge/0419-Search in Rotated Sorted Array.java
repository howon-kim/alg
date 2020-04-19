/**
Search in Rotated Sorted Array


Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


196 / 196 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 39.4 MB
O(logN)
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) 
            return -1;
        if (nums[nums.length - 1] > nums[0]) 
            return binarySearch2(nums, 0, nums.length, nums.length / 2, target);
        
        // Find Pivot Point
        int mid = binarySearch(nums, 0, nums.length - 1, nums.length / 2);
        if (target == nums[mid]) 
            return mid;
        else if (target < nums[0])
            return binarySearch2(nums, mid, nums.length, (mid + nums.length) / 2, target);
        else 
            return binarySearch2(nums, 0, mid, mid / 2, target);   
    }
    
    public int binarySearch(int[] nums, int start, int end, int mid) {
        if (nums[start] < nums[mid] && nums[end] > nums[mid]) 
            return mid;
        else if (start == mid || end == mid) 
            return mid;
        else if (nums[end] < nums[mid]) 
            return binarySearch(nums, mid, end, (end + mid) / 2);
        else 
            return binarySearch(nums, start, mid, (mid + start) / 2);
    }
    
    public int binarySearch2(int[] nums, int start, int end, int mid, int target) {
        if (nums[mid] == target) 
            return mid;
        else if (start == mid || end == mid) 
            return -1;
        else if (nums[mid] > target) 
            return binarySearch2(nums, start, mid, (mid + start) / 2, target);
        else 
            return binarySearch2(nums, mid, end, (end + mid) / 2, target);
    }
}