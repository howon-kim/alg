/**
Construct Binary Search Tree from Preorder Traversal


Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.


110 / 110 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 37.3 MB
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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode helper(int[] preorder, int max) {
        if (index == preorder.length || max < preorder[index]) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, max);
        return root;
    }
}