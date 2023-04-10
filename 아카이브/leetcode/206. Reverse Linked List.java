/**
206. Reverse Linked List | Easy
https://leetcode.com/problems/reverse-linked-list/

1. Performance
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 39.5 MB, less than 5.04% of Java online submissions for Reverse Linked List.

2. Description
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

3. Algorithm Efficiency
O(n)
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}