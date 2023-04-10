/**
108. Convert Sorted Array to Binary Search Tree
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

* My Submission Performance
Runtime: 1 ms, faster than 18.06% of Java online submissions for Convert Sorted Array to Binary Search Tree.
Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.

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

**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else {
            TreeNode temp = new TreeNode(nums[nums.length/2]);
            temp.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, (nums.length/2)));
            temp.right = sortedArrayToBST(Arrays.copyOfRange(nums, (nums.length/2) + 1, nums.length));
            return temp;
        }
    }
}
