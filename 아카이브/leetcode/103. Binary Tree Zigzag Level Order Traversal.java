/**
 * 103. Binary Tree Zigzag Level Order Traversal | Medium | 30 Min
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Performance
 * Runtime: 1 ms, faster than 98.74% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 * Memory Usage: 36.2 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 *
 * Description
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            List<Integer> temp = new ArrayList<>();
            if (i % 2 == 0) {
                Stack<Integer> stack = helper2(root, i, new Stack<Integer>());
                if (stack.isEmpty()) break;
                while(!stack.isEmpty()){
                    temp.add(stack.pop());
                }
            } else {
                Queue<Integer> queue = helper1(root, i, new LinkedList<Integer>());
                if (queue.isEmpty()) break;
                while(!queue.isEmpty()) {
                    temp.add(queue.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public Queue<Integer> helper1(TreeNode root, int level, Queue<Integer> queue) {
        if (root == null) {
            return queue;
        }
        if (level == 1) {
            queue.add(root.val);
        } else if (level > 1) {
            helper1(root.left, level-1, queue);
            helper1(root.right, level-1, queue);
        }
        return queue;
    }
    public Stack<Integer> helper2(TreeNode root, int level, Stack<Integer> stack) {
        if (root == null) {
            return stack;
        }
        if (level == 1) {
            stack.add(root.val);
        } else if (level > 1) {
            helper2(root.left, level-1, stack);
            helper2(root.right, level-1, stack);
        }
        return stack;
    }
}