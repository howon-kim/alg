/**
 * 211. Add and Search Word - Data structure design | Medium | 30 Min
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * <p>
 * MY SUBMISSION PERFORMANCE
 * Runtime: 78 ms, faster than 73.40% of Java online submissions for Add and Search Word - Data structure design.
 * Memory Usage: 52.3 MB, less than 100.00% of Java online submissions for Add and Search Word - Data structure design.
 * <p>
 * DESCRIPTION
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

class WordDictionary {
    HashMap<Integer, ArrayList<String>> words;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        words = new HashMap<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        int len = word.length();
        if (!words.containsKey(len)) {
            words.put(len, new ArrayList<>());
        }
        words.get(len).add(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        int len = word.length();
        if (!words.containsKey(len)) {
            return false;
        }

        ArrayList<String> current = words.get(len);
        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (word.charAt(i) != '.') {
                for (String c : current) {
                    if (c.charAt(i) == word.charAt(i)) {
                        temp.add(c);
                    }
                }
                current = temp;
                temp = new ArrayList<>();
                if (current.isEmpty()) return false;
            }
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
