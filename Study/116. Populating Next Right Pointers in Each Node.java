/**
116. Populating Next Right Pointers in Each Node | Medium
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/


You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 

Example 1:



Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 

Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000


Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
Memory Usage: 39.6 MB, less than 6.35% of Java online submissions for Populating Next Right Pointers in Each Node.
O(n)
 */

 /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}
    
    /**
    public Node connect(Node root) {
        if (root == null) return root;
        root.next = null;
        
        if (root.left != null && root.right != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root.left);
            queue.add(root.right);
            helper(queue, queue.size() - 1);
        } 
        
        return root;
    }
    
    public void helper(Queue<Node> queue, int last) {
        if (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (last == 0) {
                temp.next = null;
                last = queue.size() + 2;
            } else {
                temp.next = queue.peek();
            }
            
            if (temp.left != null && temp.right != null) {
                queue.add(temp.left);
                queue.add(temp.right);
            }
            helper(queue, last - 1);
        }
    **/

