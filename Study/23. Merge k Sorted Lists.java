/**
 * 23. Merge k Sorted Lists | Hard | 40 Min
 * https://leetcode.com/problems/merge-k-sorted-lists/

 * MY SUBMISSION PERFORMANCE
 * Runtime: 6 ms, faster than 55.61% of Java online submissions for Merge k Sorted Lists.
 * Memory Usage: 43.8 MB, less than 24.05% of Java online submissions for Merge k Sorted Lists.
 
 * DESCRIPTION
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        Queue<Integer> temp = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                temp.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode answer = head;
        while (!temp.isEmpty()) {
            //System.out.println(temp.peek());
            head.next = new ListNode(temp.poll());
            head = head.next;
        }

        return answer.next;

        /**
         if (lists.length == 0) return null;
         ListNode head = new ListNode(-1);
         ListNode ans = head;
         int index = 0;
         int min = Integer.MAX_VALUE;
         Boolean solved = false;

         while (!solved) {
         solved = true;
         for (int i = 0; i < lists.length; i++) {
         if (lists[i] != null && lists[i].val <= min) {
         min = lists[i].val;
         index = i;
         }
         if (lists[i] != null) {
         solved = false;
         }
         }

         if (!solved) {
         head.next = new ListNode(min);
         min = Integer.MAX_VALUE;
         head = head.next;
         lists[index] = lists[index].next;

         }

         }
         return ans.next;
         **/
    }
}