"""
108. Convert Sorted Array to Binary Search Tree
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

* My Submission Performance
Runtime: 76 ms, faster than 79.69% of Python3 online submissions for Convert Sorted Array to Binary Search Tree.
Memory Usage: 16.1 MB, less than 5.71% of Python3 online submissions for Convert Sorted Array to Binary Search Tree.

* Description
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if (len(nums) == 0):
            return None
        else:
            half = len(nums) // 2
            head = TreeNode(nums[half])
            head.left = self.sortedArrayToBST(nums[:half])
            head.right = self.sortedArrayToBST(nums[half + 1 : len(nums)])
            return head
