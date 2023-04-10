/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal | Medium | * Min
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Performance
 * Runtime: 11 ms, faster than 36.79% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 *
 * Description
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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
    int pre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        ArrayList <Integer> pre = new ArrayList<>();
        ArrayList <Integer> in = new ArrayList<>();

        for (int i = 0; i < preorder.length; i++) {
            pre.add(preorder[i]);
            in.add(inorder[i]);
        }
        return helper(pre, in);
    }

    public TreeNode helper(List<Integer> preorder, List<Integer> inorder) {
        if(inorder.isEmpty()) return null;
        int index = inorder.indexOf(preorder.remove(0));
        TreeNode root = new TreeNode(inorder.get(index));
        root.left = helper(preorder, inorder.subList(0, index));
        root.right = helper(preorder, inorder.subList(index + 1, inorder.size()));
        return root;
    }
}