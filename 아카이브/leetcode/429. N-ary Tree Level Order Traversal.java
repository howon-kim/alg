/**
 * 429. N-ary Tree Level Order Traversal | Easy | 20 Min
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * Performance
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for N-ary Tree Level Order Traversal.
 * Memory Usage: 49.8 MB, less than 17.50% of Java online submissions for N-ary Tree Level Order Traversal.
 *
 * Description
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 *
 * We should return its level order traversal:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 **/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return ans;
        reader(root, 0);
        return ans;

    }
    public void reader(Node root, int level) {
        if (root == null) return;
        if (ans.size() <= level) {
            ans.add(new ArrayList<Integer>());
        }
        for (Node l: root.children) {
            reader(l, level + 1);
        }

        List<Integer> temp = ans.get(level);
        temp.add(root.val);
    }
}