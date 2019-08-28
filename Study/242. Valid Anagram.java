/******************************
242. Valid Anagram | Easy
https://leetcode.com/problems/valid-anagram/submissions/

* My Submission Performance
Runtime: 5 ms, faster than 63.55% of Java online submissions for Valid Anagram.
Memory Usage: 36.9 MB, less than 96.68% of Java online submissions for Valid Anagram.

* Description
Share
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *******************************/

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);

        /** Without Sort Algorithm 
        if (s.length() != t.length()) {
            return false;
        } 
        PriorityQueue<Character> ss = new PriorityQueue<>();
        PriorityQueue<Character> tt = new PriorityQueue<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                ss.add(s.charAt(i));
                tt.add(t.charAt(i));
            }
        }
        while (ss.size() != 0) {
            if (ss.poll() != tt.poll()) {
                return false;
            }
        }
        return true;
        **/
    }
}