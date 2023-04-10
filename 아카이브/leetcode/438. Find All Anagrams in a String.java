/**
 * 438. Find All Anagrams in a String | Medium | 50 Min
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Performance
 * Runtime: 275 ms, faster than 15.89% of Java online submissions for Find All Anagrams in a String.
 * Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Find All Anagrams in a String.
 *
 * Description
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * Sequence Generator //
 * @Source : https://www.random.org/sequences/?min=1&max=26&col=1&format=html&rnd=new
 **/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //10:16
        List<Integer> ans = new ArrayList<>();
        int len_s = s.length();
        int len_p = p.length();
        int aa = 0;
        int bb = 0;
        int[] keys = new int[]{14,8,22,23, 3,13,12,16,17,2,7,19,24,26,4,6,20,1,21,11,10,18,25, 9, 5,15};

        for (int i = 0; i < len_p; i++) {
            char key = p.charAt(i);
            aa += keys[(key - 97)];
        }

        for (int j = 0; j <= len_s - len_p; j++) {
            bb = 0;
            for (int k = 0; k < len_p; k++) {
                char key = s.charAt(j + k);
                bb += keys[(key - 97)];
                if (bb > aa) {
                    k = len_p;
                }
            }
            if (aa == bb) {
                ans.add(j);
            }

        }
        return ans;
    }
}