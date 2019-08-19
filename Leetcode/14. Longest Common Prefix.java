/**
 * 14. Longest Common Prefix | Easy
 * https://leetcode.com/problems/longest-common-prefix/

 * My Submission Performance
 * Runtime: 2 ms, faster than 15.59% of Java online submissions for Longest Common Prefix.
 * Memory Usage: 38 MB, less than 80.70% of Java online submissions for Longest Common Prefix.

 * Description
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans; String temp; ans = temp = "";
        for (int i = 1; i <= strs[0].length(); i++) {
            temp = strs[0].substring(0, i);
            for (String str: strs) {
                if (str.length() < i || !str.substring(0, i).equals(temp)) return ans;
            }
            ans = temp;
        }
        return ans;
    }
}