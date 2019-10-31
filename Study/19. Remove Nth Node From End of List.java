/**
19. Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

**
Submission Performance
Runtime: 1 ms, faster than 11.10% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.

**
Description
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        
        List<ListNode> node = new ArrayList<>();
        ListNode temp = head;
        
        while (temp != null) {
            node.add(temp);
            temp = temp.next;
        }
        
        int left = node.size() - n - 1;
        int right = node.size() - n + 1;
        
        if (left < 0) {
            return head = head.next;
        } else {
            node.add(null);
            node.get(left).next = node.get(right);
        }
        return head;
    }
}