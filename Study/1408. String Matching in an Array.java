/**
1408. String Matching in an Array
https://leetcode.com/problems/string-matching-in-an-array/


Given an array of string words. Return all strings in words which is substring of another word in any order. 

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

 

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.


Runtime: 9 ms, faster than 28.69% of Java online submissions for String Matching in an Array.
Memory Usage: 40 MB, less than 100.00% of Java online submissions for String Matching in an Array.
O(N)
 */

class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) {
                    if (words[i].contains(words[j])) {
                        ans.add(words[j]);
                    }
                } else if (words[i].length() < words[j].length()) {
                    if (words[j].contains(words[i])) {
                        ans.add(words[i]);
                    }
                }
            }
        }
        
        return new ArrayList<String>(ans);
    }
}