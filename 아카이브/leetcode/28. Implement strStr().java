/**
 * 28. Implement strStr()
 * Return the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 
    Example 1:
    
    Input: haystack = "hello", needle = "ll"
    Output: 2
    Example 2:
    
    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
    Clarification:
    
 * What should we return when needle is an empty string? 
 * This is a great question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty string. 
 * This is consistent to C's strstr() and Java's indexOf().

 * Runtime: 3 ms, faster than 33.37% of Java online submissions for Implement strStr().
 * Memory Usage: 37.1 MB, less than 99.38% of Java online submissions for Implement strStr().
 *
 */

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty() || haystack.equals(needle)) {
            return 0;
        } else {
            int hayIndex = 0;
            int needleIndex = 0;
            while (hayIndex != haystack.length()) {
                if (haystack.charAt(hayIndex) == needle.charAt(needleIndex)) {
                    needleIndex++;
                    hayIndex++;
                    if (needleIndex == needle.length()) {
                        return hayIndex - needleIndex;
                    }
                } else {
                    hayIndex = hayIndex - (needleIndex - 1);
                    needleIndex = 0;
                }
            }
        }
        return -1;
    }
}