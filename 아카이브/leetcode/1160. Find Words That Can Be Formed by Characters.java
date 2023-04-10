/**
1160. Find Words That Can Be Formed by Characters | Easy
https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/


You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.


Runtime: 5 ms, faster than 88.89% of Java online submissions for Find Words That Can Be Formed by Characters.
Memory Usage: 40 MB, less than 100.00% of Java online submissions for Find Words That Can Be Formed by Characters.

Hashmap Version: 24ms, 40.5MB
*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int [] original = new int[26]; 
        //HashMap<Character, Integer> original = new HashMap<>();
        int total = 0;
        
        for (char c: chars.toCharArray()) {
            //if (!original.containsKey(c)) original.put(c, 0);
            //original.put(c, original.get(c) + 1);
            original[(int) c - 97]++;
        }
        
        for (String w: words) {
            int [] lst = new int[26];
            //HashMap<Character, Integer> hashMap = new HashMap<>();
            int count = 0;
            Boolean flag = false;
            for (char c: w.toCharArray()) {
                lst[(int) c - 97]++;
                if (original[(int) c - 97] < lst[(int) c - 97]) {
                    flag = true;
                    break;
                }
                /**
                if (!original.containsKey(c)) {
                    flag = true;
                    break;
                } else {
                    if (!hashMap.containsKey(c)) hashMap.put(c, 0);
                    hashMap.put(c, hashMap.get(c) + 1);
                    if (hashMap.get(c) > original.get(c)) {
                        flag = true;
                        break;
                    }
                }
                **/
                count++;
            }
            if (!flag) {
                total += count;
            }
        }
        return total;
    }
}