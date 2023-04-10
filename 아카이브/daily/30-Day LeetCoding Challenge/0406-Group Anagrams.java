/**
Group Anagrams


Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.


101 / 101 test cases passed.
Status: Accepted
Runtime: 12 ms
Memory Usage: 43.5 MB
 */

 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        
        for (String str: strs) {
            int[] hash = new int[26];
            for (char letter: str.toCharArray()) {
                hash[letter - 97]++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int h: hash) {
                sb.append(h);
            }
            
            String strHash = sb.toString();
            if (!hashMap.containsKey(strHash)) {
                hashMap.put(strHash, new ArrayList());
            } 
            hashMap.get(strHash).add(str);
        }
        return new ArrayList(hashMap.values());
    }
}