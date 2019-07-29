import java.util.Hashtable;
import java.util.AbstractMap;

/**
819. Most Common Word
https://leetcode.com/problems/most-common-word/

* My Submission Performance
Runtime: 19 ms, faster than 40.69% of Java online submissions for Most Common Word.
Memory Usage: 36.1 MB, less than 94.56% of Java online submissions for Most Common Word.

* Description
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

* Example

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 

Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        Hashtable<String, Integer> result = new Hashtable<>();
        AbstractMap.SimpleEntry<String, Integer> max = 
            new AbstractMap.SimpleEntry("",-1);
        
        for (String b: banned) {
            ban.add(b);
        }
        paragraph = paragraph.replaceAll("[^a-zA-Z, ]", "").toLowerCase();
        for (String w : paragraph.split(", | |,")){
            if (!ban.contains(w)) {
                if (result.isEmpty()){
                    max = new AbstractMap.SimpleEntry(w, 1);
                    result.put(w, 1);
                } else {
                    if (result.containsKey(w)) {
                        int newValue = result.get(w) + 1;
                        result.put(w, newValue);
                        if(max.getValue() < newValue) {
                            max = new AbstractMap.SimpleEntry(w, newValue);
                        }
                    } else {
                        result.put(w, 1);
                    }
                }
            }
        }
        return max.getKey();
    }
}
