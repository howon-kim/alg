class Solution {
    /**
     * 125. Valid Palindrome | Easy
     * https://leetcode.com/problems/valid-palindrome/
     *
     * My Submission Performance
     * Runtime: 21 ms, faster than 18.74% of Java online submissions for Valid Palindrome.
     * Memory Usage: 39.7 MB, less than 22.32% of Java online submissions for Valid Palindrome.
     *
     * Description
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     *
     * Example 1:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     *
     * Input: "race a car"
     * Output: false
     */

    public boolean isPalindrome(String s) {
        char[] clean = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase().toCharArray();
        int start = 0; int end = clean.length - 1;
        while (start < clean.length / 2) {
            if (clean[start++] != clean[end--]) return false;
        }
        return true;
    }
}