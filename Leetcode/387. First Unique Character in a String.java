/**
 * 387. First Unique Character in a String | EASY | 25 min
 * https://leetcode.com/problems/first-unique-character-in-a-string/

 * MY SUBMISSION PERFORMANCE
 * Runtime: 9 ms, faster than 78.17% of Java online submissions for First Unique Character in a String.
 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for First Unique Character in a String.

 * DESCRIPTION
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 */

class Solution {
    int[] temp;
    public int firstUniqChar(String s) {
        temp = new int[26];
        for (int i = 0 ; i < s.length(); i++) {
            temp[s.charAt(i) - 97]++; //ASCII 'a' = 97
        }

        for (int i = 0 ; i < s.length(); i++) {
            if (temp[s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        return -1;
    }
}