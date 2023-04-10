/**
938. Range Sum of BST | Easy
https://leetcode.com/problems/range-sum-of-bst/


Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 

Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.


Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
Memory Usage: 47.2 MB, less than 91.86% of Java online submissions for Range Sum of BST.
O(n)
 */

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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        else if (root.val < L) return 0 + rangeSumBST(root.right, L, R);
        else if (root.val > R) return 0 + rangeSumBST(root.left, L, R);
        else return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}