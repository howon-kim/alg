/**
404. Sum of Left Leaves | Easy
https://leetcode.com/problems/sum-of-left-leaves/


Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
Memory Usage: 37 MB, less than 100.00% of Java online submissions for Sum of Left Leaves.
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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
    
    public int helper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }
        return helper(root.left, true) + helper(root.right, false);
    }
}