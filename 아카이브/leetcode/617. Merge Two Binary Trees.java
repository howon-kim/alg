/**
617. Merge Two Binary Trees | Easy | 20 Min
https://leetcode.com/problems/merge-two-binary-trees/

* Submission Performance 
Runtime: 1 ms, faster than 69.94% of Java online submissions for Merge Two Binary Trees.
Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Merge Two Binary Trees.

* Description
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

Note: The merging process must start from the root nodes of both trees.
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        
        TreeNode answer = null;
        
        if (t1 != null && t2 == null) {
            answer = new TreeNode(t1.val);
            answer.left = mergeTrees(t1.left, t2);
            answer.right = mergeTrees(t1.right, t2);
        } else if (t1 == null && t2 != null) {
            answer = new TreeNode(t2.val);
            answer.left = mergeTrees(t1, t2.left);
            answer.right = mergeTrees(t1, t2.right);
        } else {
            answer = new TreeNode(t1.val + t2.val);
            answer.left = mergeTrees(t1.left, t2.left);
            answer.right = mergeTrees(t1.right, t2.right);
        }
        return answer;
    }
}