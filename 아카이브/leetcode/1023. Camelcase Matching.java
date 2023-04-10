/**
1023. Camelcase Matching | Medium
https://leetcode.com/problems/camelcase-matching/


A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)

Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.

 

Example 1:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: 
"FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
Example 2:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation: 
"FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
Example 3:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation: 
"FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 

Note:

1 <= queries.length <= 100
1 <= queries[i].length <= 100
1 <= pattern.length <= 100
All strings consists only of lower and upper case English letters.


Runtime: 1 ms, faster than 26.39% of Java online submissions for Camelcase Matching.
Memory Usage: 37.4 MB, less than 14.29% of Java online submissions for Camelcase Matching.
 */

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] pat = pattern.toCharArray(); 
        List<Boolean> ans = new ArrayList<>();
        int index = 0; int curr = 0;
        for (String query: queries) {
            index = 0; curr = 0;
            char[] q = query.toCharArray();
            StringBuilder sb = new StringBuilder();
            while (index < pat.length && curr < q.length) {
                
                if (!Character.isLowerCase(q[curr])) {
                    sb.append(q[curr]);
                    index++;
                } else if (pat[index] == q[curr]) {
                    sb.append(q[curr]);
                    index++;
                }

                curr++;
            }
            
            while (curr < q.length) {
                if (!Character.isLowerCase(q[curr])) {
                    sb.append(q[curr]);
                }
                curr++;
            }
            
            if (pattern.equals(sb.toString())) ans.add(true);
            else ans.add(false);

        }
        return ans;
    }
}