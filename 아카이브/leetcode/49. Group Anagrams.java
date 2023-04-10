/**
 * 49. Group Anagrams | Medium | 30 Min
 * https://leetcode.com/problems/group-anagrams/
 
 * MY SUBMISSION PERFORMANCE
 * Runtime: 49 ms, faster than 8.62% of Java online submissions for Group Anagrams.
 * Memory Usage: 49.1 MB, less than 5.26% of Java online submissions for Group Anagrams.

 * DESCRIPTION
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashSet<Integer>, ArrayList<String>> temp = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();

        for (String str : strs) {
            HashSet<Integer> key = new HashSet<>();

            for (int i = 0; i < str.length(); i++) {
                int keyValue = (int) str.charAt(i);
                while (key.contains(keyValue)) {
                    keyValue *= 2;
                }
                key.add(keyValue);
            }

            if (!temp.containsKey(key)) {
                temp.put(key, new ArrayList<>());
            }
            ArrayList<String> group = temp.get(key);
            group.add(str);
        }
        for (ArrayList<String> value : temp.values()) {
            answer.add(value);
        }

        return answer;
    }
}
