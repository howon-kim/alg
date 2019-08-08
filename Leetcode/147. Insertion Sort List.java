/**
 * 147. Insertion Sort List | Medium
 * https://leetcode.com/problems/insertion-sort-list/
 * 
 * 
 * My Submission Performance
 * Runtime: 54 ms, faster than 6.25% of Java online submissions for Insertion Sort List.
 * Memory Usage: 37.6 MB, less than 96.00% of Java online submissions for Insertion Sort List.
 *
 * 
 * Description
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ans = null;
        while (head != null) {
            if (ans == null) {
                ans = new ListNode(head.val);
            } else {
                ListNode cur = ans;
                ListNode prev = ans;
                Boolean fixed = false;
                while (cur != null) {
                    if (fixed == false) {
                        if (cur.val > head.val) {
                            if (cur == ans) {
                                ListNode temp = new ListNode(head.val);
                                temp.next = cur;
                                ans = temp;
                                fixed = true;
                            } else {
                                prev.next = new ListNode(head.val);
                                prev.next.next = cur;
                                fixed = true;
                            }
                        }
                    }
                    prev = cur;
                    cur = cur.next;


                }
                if (fixed == false) {
                    prev.next = new ListNode(head.val);
                }
            }

            head = head.next;
        }
        return ans;
        /*
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode prevprev = head;
        ListNode ptr = head;
        ListNode cur = head;
        ListNode next = head;

        while (cur != null) {
            if (prev.val < cur.val){
            prev = cur;
            }
            next = cur.next;
            while (ptr != cur) {
                if (ptr.val > cur.val) {
                    prev.next = cur.next;
                    cur.next = ptr;
                    if (prevprev != cur.next && prevprev.next != null) {
                    prevprev.next = cur;
                    }
                    if (cur.val < head.val) {
                        head = cur;
                        
                    }
                    break;
                } else {
                    prevprev = ptr;
                    ptr = ptr.next;
                }
            }
            ptr = head;
            cur = next;

                        
        }

        return head;
        
        /** Memory Limit Exceeded 
        if (head == null) {
            return null;
        }
        
        ArrayList<ListNode> temp = new ArrayList<>();
        ListNode cur = head;
        while (cur !=  null) {
            if (temp.isEmpty()) {
                temp.add(cur);
                cur = cur.next;
            } else {
                ListNode ctemp = cur.next;
                for (int i = 0; i < temp.size(); i++) {
                    if (temp.get(i).val > cur.val) { 
                        if (i != 0) {
                            temp.get(i - 1).next = cur;
                        }
                        temp.get(temp.size() - 1).next = ctemp;
                        cur.next = temp.get(i);
                        temp.add(i, cur);
                        break;
                    } 
                    if (i == temp.size() - 1) {
                        temp.add(cur);
                    }
                }
                cur = ctemp;
            }
        }
        return temp.get(0);
        **/
    }
}