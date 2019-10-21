/**
299. Bulls and Cows | Easy
https://leetcode.com/problems/bulls-and-cows/

Runtime: 2 ms, faster than 55.88% of Java online submissions for Bulls and Cows.
Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Bulls and Cows.
**/

class Solution {
    public String getHint(String secret, String guess) {
        int s[] = new int[10];
        int g[] = new int[10];
        int bull = 0;
        int cows = 0;
        
        for (int i = 0 ; i < secret.length() ; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                s[Character.getNumericValue(secret.charAt(i))]++;
                g[Character.getNumericValue(guess.charAt(i))]++;
            }
        }
        
        for (int i = 0 ; i < 10 ; i++) {
            cows += Math.min(s[i], g[i]);
        }
        
        return bull + "A" + cows + "B";
    }
}