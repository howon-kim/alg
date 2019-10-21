/**
 * 83. Remove Duplicates from Sorted List | Easy | 3 Min
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Performance
 * Runtime: 1 ms, faster than 25.19% of Java online submissions for Remove Duplicates from Sorted List.
 * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
 *
 * Description
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */


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
        ListNode temp = new ListNode(Integer.MIN_VALUE);
        ListNode ans = temp;
        while (head != null) {
            if (temp.val != head.val) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return ans.next;
    }
}
