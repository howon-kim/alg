/**
 * 61. Rotate List | Medium | 20 Min
 * https://leetcode.com/problems/rotate-list/
 *
 * Performance
 * Runtime: 1 ms, faster than 25.57% of Java online submissions for Rotate List.
 * Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Rotate List.
 * 
 * Description
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 **/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ArrayList<ListNode> node = new ArrayList<>();
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            node.add(temp);
            temp = temp.next;
            size++;
        }

        k = k % size;
        if (k != 0) {
            node.get(size - 1).next = node.get(0);
            head = node.get(size - k);
            node.get(size - k - 1).next = null;
        }
        return head;
    }
}