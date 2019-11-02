/**
 * 82. Remove Duplicates from Sorted List II | Medium | 30 Min
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Performance
 * Runtime: 1 ms, faster than 79.74% of Java online submissions for Remove Duplicates from Sorted List II.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
 *
 * Description
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        ListNode ptr = dummy;
        ListNode prev = dummy;

        while (head != null) {
            ptr.next = new ListNode(head.val);
            ptr = ptr.next;
            head = head.next;

            if (head == null) {
                return newHead.next;
            } else if (prev.next.val != head.val) {
                prev = prev.next;
            } else {
                while (head != null && prev.next.val == head.val) {
                    head = head.next;
                    if (head == null || prev.next.val != head.val) {
                        ptr = prev;
                    }
                }
                ptr.next = null;
            }
        }
        return newHead.next;
    }
}

