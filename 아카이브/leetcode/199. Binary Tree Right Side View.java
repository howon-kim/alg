/**
1. Performance 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Right Side View.
Memory Usage: 38.2 MB, less than 5.88% of Java online submissions for Binary Tree Right Side View.

2. Problem Description
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

3. Approach
DFS(Depth First Search) from right branch. 
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
    List<Integer> ans;
    
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        if (root != null) {
            helper(root, 1);
        } 
        return ans;
    }
    
    public void helper(TreeNode root, int height) {
        if (root == null) {
            return;
        } else {
            if (ans.size() < height) {
                ans.add(root.val);
            }
            helper(root.right, height + 1);
            helper(root.left, height + 1);
        }
    }
}