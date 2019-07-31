"""
136. Single Number
https://leetcode.com/problems/single-number/

- Description
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

- My Submission Performance
Runtime: 96 ms, faster than 85.67% of Python3 online submissions for Single Number.
Memory Usage: 16 MB, less than 5.12% of Python3 online submissions for Single Number.
"""

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        binary = 0
        for num in nums:
            binary ^= num
        return binary
      