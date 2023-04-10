/**
 * 226. Invert Binary Tree | Easy | 30 Min
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Performance
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Invert Binary Tree.
 * 
 * Description
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
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
    TreeNode inverted = new TreeNode(0);
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}