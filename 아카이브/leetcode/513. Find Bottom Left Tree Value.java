/**
513. Find Bottom Left Tree Value | Medium
https://leetcode.com/problems/find-bottom-left-tree-value/
 

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7


Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Bottom Left Tree Value.
Memory Usage: 39.1 MB, less than 78.26% of Java online submissions for Find Bottom Left Tree Value.
Efficiency: O(n)
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
    
    List<Integer> max;
    int maxHeight = -1;
    
    public int findBottomLeftValue(TreeNode root) {
        return helper(root, true, 0);
    }
    
    public int helper(TreeNode root, Boolean left, int height) {
         if (root.left == null && root.right == null) {
            if (maxHeight == -1 || maxHeight < height) {
                max = new ArrayList<>();
                max.add(root.val);
                maxHeight = height;
            } 
        } else {
            if (root.left != null) helper(root.left, true, height + 1);
            if (root.right != null) helper(root.right, false, height + 1);
        }
        
        return max.get(0);
    }
}