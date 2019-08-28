/**
104. Maximum Depth of Binary Tree
https://leetcode.com/problems/maximum-depth-of-binary-tree/

* My Submission Performance
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
Memory Usage: 38.8 MB, less than 97.34% of Java online submissions for Maximum Depth of Binary Tree.

* Description
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

* Example
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

*  Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    int maxLevel = 0;
    
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxLevel;
    }
    
    public void dfs(TreeNode r, int curLevel) {
        if (r == null) {
            return;
        } else if (maxLevel < curLevel) {
          maxLevel = curLevel;  
        } 
        dfs(r.left, curLevel + 1);
        dfs(r.right, curLevel + 1);
    }
}
