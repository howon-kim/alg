/**
 * 94. Binary Tree Inorder Traversal | Medium | 5 Min
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Performance
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 *
 * Description
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return ans;
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }
}