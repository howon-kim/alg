/**
1189. Maximum Number of Balloons | Easy
https://leetcode.com/problems/maximum-number-of-balloons/


Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only.


Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Number of Balloons.
Memory Usage: 38.7 MB, less than 100.00% of Java online submissions for Maximum Number of Balloons.
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        /** HashMap Version 
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = Integer.MAX_VALUE;
        
        for (char c: text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                if (!hashMap.containsKey(c)) hashMap.put(c, 0);
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }
        
        if (hashMap.size() != 5) return 0;
        
        for (Map.Entry<Character, Integer> entry: hashMap.entrySet()) {
            Character key = entry.getKey();
            if (key == 'b' || key == 'a' || key == 'n') {
                max = Math.min(max, entry.getValue());
            } else {
                max = Math.min(max, entry.getValue() / 2);
            }
        }
        return max;
        **/
        int []texts = new int[26];
        int min = 0;
        
        for (char c: text.toCharArray()) {
            texts[c - 'a']++;
        }
        
        min = texts['b' - 'a'];
        min = Math.min(min, texts['a' - 'a']);
        min = Math.min(min, texts['n' - 'a']);
        min = Math.min(min, texts['l' - 'a'] / 2);
        min = Math.min(min, texts['o' - 'a'] / 2);
        
        return min;
    }
}