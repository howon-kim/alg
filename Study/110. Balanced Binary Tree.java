/**
 * 110. Balanced Binary Tree | EASY | 25 min
 * https://leetcode.com/problems/majority-element/

 * MY SUBMISSION PERFORMANCE
 * Runtime: 1 ms, faster than 96.16% of Java online submissions for Balanced Binary Tree.
 * Memory Usage: 37.6 MB, less than 97.22% of Java online submissions for Balanced Binary Tree.

 * DESCRIPTION
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
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
    boolean overHeight = false;
    public boolean isBalanced(TreeNode root) {
        if (root == null || ((root.left == null) && (root.right == null))) return true;
        helper(root, 0);
        return !overHeight;
    }
    public int helper(TreeNode node, int height) {
        if (node == null) return height;
        int left = helper(node.left, height + 1);
        int right = helper(node.right, height + 1);
        if (Math.abs(left - right) > 1){
            overHeight = true;
        };
        return Math.max(left, right);
    }
}