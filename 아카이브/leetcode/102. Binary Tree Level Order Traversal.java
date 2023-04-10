/**
102. Binary Tree Level Order Traversal

Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal.

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
        
    }
    public void helper(TreeNode root, int level, List<List<Integer>> result){
        if(root == null){
        }  else {       
            List<Integer> temp = new ArrayList<>();
            if(result.size() <= level){
                result.add(temp);
            }
            result.get(level).add(root.val);
            helper(root.left, level + 1, result);
            helper(root.right, level + 1, result);
        }
    }
}