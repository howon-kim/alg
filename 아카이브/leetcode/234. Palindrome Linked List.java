/** -----------------------------------
 * 234. Palindrome Linked List | Easy
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * My Submission Performance
 * Runtime: 1 ms, faster than 99.13% of Java online submissions for Palindrome Linked List.
 * Memory Usage: 39.8 MB, less than 98.78% of Java online submissions for Palindrome Linked List.
 *
 * Description
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * -----------------------------------


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode end = head.next;
        ListNode half = head;

        while (end != null && end.next != null) {
            if (end.next.next != null) {
                end = end.next.next;
            } else {
                end  = end.next;
            }
            half = half.next;
        }
        ListNode realhalf = half;
        ListNode cur = half;  ListNode next = half.next;
        while (next != null) {
            ListNode temp = next.next;
            next.next  = cur;

            cur = next;
            next = temp;
        }
        while (end != realhalf) {
            if (end.val != head.val) {
                return false;
            }
            end = end.next;
            head = head.next;
        }
        return true;
        /** Simple Solution **
         Stack<Integer> stack = new Stack<>();
         Queue<Integer> queue = new LinkedList<>();

         while (head != null) {
         stack.push(head.val);
         queue.add(head.val);
         head = head.next;
         }
         while (!stack.isEmpty()) {
         if (!stack.pop().equals(queue.poll())) {
         return false;
         }
         }
         return true;
         **/
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new Solution().isPalindrome(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}