/* ----------------------------------- *
92. Reverse Linked List II (Medium)
https://leetcode.com/problems/reverse-linked-list-ii/

* Description
Reverse a linked list from position m to n. Do it in one-pass.
Note: 1 ≤ m ≤ n ≤ length of list.

* Example
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

* My Submission Performance
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Reverse Linked List II.
 * ----------------------------------- */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 1;
        ListNode temp = head;
        ListNode prev = head;
        Stack<ListNode> stack = new Stack<>();
        while (index != n) {
            if (index >= m) {
                stack.add(temp);
            } else {
                prev = temp;
            }
            temp = temp.next;
            index++;
        }
        ListNode next = temp.next;
        ListNode temp2 = temp;
        for (int i = m; i < n; i++) {
            temp2.next = stack.pop();
            temp2 = temp2.next;
        }
        prev.next = temp;
        temp2.next = next;
        if (temp2 != prev) {
            return head;
        } 
        return temp;
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
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);
            
            ListNode ret = new Solution().reverseBetween(head, m, n);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
        }
    }
}