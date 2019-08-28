"""
35. Search Insert Position
Runtime: 32 ms, faster than 91.09% of Python3 online submissions for Search Insert Position.
Memory Usage: 13.4 MB, less than 98.55% of Python3 online submissions for Search Insert Position.

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
"""

class Solution: 
    def searchInsert(self, nums: List[int], target: int) -> int:
        length = len(nums)
        if target > nums[-1]:
            return length
        else:
            for i in range(0, length):
                if target == nums[i]:
                    return i
                elif (nums[i] > target):
                    return i