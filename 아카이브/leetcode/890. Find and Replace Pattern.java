/**
890. Find and Replace Pattern | Medium
https://leetcode.com/problems/find-and-replace-pattern/


You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
 

Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20


Runtime: 1 ms, faster than 93.09% of Java online submissions for Find and Replace Pattern.
Memory Usage: 39.4 MB, less than 7.69% of Java online submissions for Find and Replace Pattern.
 */

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] pat = pattern.toCharArray(); 
        int sum = 0;
        List<String> ans = new ArrayList<>();        
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        
        for (char c: pat) {
            sum += (int) c;
            hashMap1.put(c, (int) c);
        }
        
        for (String w: words) {
            int currSum = 0; int index = 0;
            HashMap<Character, Integer> hashMap2 = new HashMap<>();

            for (char c: w.toCharArray()) {
                if (!hashMap2.containsKey(c)) {
                    hashMap2.put(c, (int) pat[index]);
                }
                
                currSum += hashMap2.get(c);
                index++;
            }
            
            if (hashMap1.size() == hashMap2.size() && sum == currSum) {
                ans.add(w);
            }
        }
        return ans;
    }
}