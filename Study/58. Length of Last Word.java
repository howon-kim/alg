/** Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    Example:

    Input: "Hello World"
    Output: 5 
    */

 /** Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
     Memory Usage: 35.6 MB, less than 99.95% of Java online submissions for Length of Last Word. */

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(count != 0){
                    return count;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
