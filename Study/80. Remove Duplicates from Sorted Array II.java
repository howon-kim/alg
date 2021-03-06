/**
80. Remove Duplicates from Sorted Array II | Medium
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

1. Submission Performance
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
Memory Usage: 39.7 MB, less than 5.26% of Java online submissions for Remove Duplicates from Sorted Array II.

2. Description
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

3. Algorithm Efficiency
O(n)
**/

class Solution {
    public int removeDuplicates(int[] nums) {
        int stopPoint = 0;
        boolean isTwice = false;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = (i + 1); j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if(!isTwice) {
                        nums[stopPoint++] = nums[j];
                        isTwice = true;
                    }
                } else {
                    //i = j;
                    isTwice = false;
                    nums[stopPoint++] = nums[i];
                }
                i = j;
            }
            
            if (i == nums.length - 1) {
                nums[stopPoint++] = nums[i];
            }
        }
        return stopPoint;
    }
}