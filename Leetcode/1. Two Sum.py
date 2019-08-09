"""
1. Two Sum | Easy
https://leetcode.com/problems/two-sum/

* My Submission Performance
Runtime: 52 ms, faster than 96.28% of Python3 online submissions for Two Sum.
Memory Usage: 14.8 MB, less than 14.41% of Python3 online submissions for Two Sum.

* Description
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
"""

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        temp = nums.copy()
        nums.sort()
        
        index1 = 0
        index2 = len(nums) - 1
        
        while (index1 != index2):
            total = nums[index1] + nums[index2]
            if (total == target):
                ans1 = temp.index(nums[index1])
                temp[ans1] = -1
                ans2 = temp.index(nums[index2])
                return [ans1, ans2]
            elif (total > target):
                index2 -= 1
            else:
                index1 += 1
        return None