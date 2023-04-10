/**
 * 107. Binary Tree Level Order Traversal II | Easy | 15 Min
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Performance
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
 *
 * Description
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root, 0);
        List<List<Integer>> temp = new ArrayList<>();
        for(int i = ans.size() - 1; i >= 0; i--) {
            temp.add(ans.get(i));
        }
        return temp;
    }
    public void helper(TreeNode root, int level) {
        if (root == null) return;
        if (ans.size() <= level) {
            List<Integer> temp = new ArrayList();
            temp.add(root.val);
            ans.add(temp);
        } else {
            List<Integer> temp = ans.get(level);
            temp.add(root.val);
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}