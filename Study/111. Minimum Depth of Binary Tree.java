/**
 * 111. Minimum Depth of Binary Tree | Easy | 20 Min
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Performance
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
 * Memory Usage: 39 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
 *
 * Description
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
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
    int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            helper(root, 1);
        }
        return ans;
    }

    public void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth <= ans) {
                ans = depth;
            }
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}