/**
67. Add Binary
https://leetcode.com/problems/add-binary/
**/

class Solution {
    public String addBinary(String a, String b) {
        Stack<Integer> sa = new Stack<>();
        Stack<Integer> sb = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int temp = 0;
        
        for (char ca: a.toCharArray()) {
            sa.add(Character.getNumericValue(ca));
        }
        for (char cb: b.toCharArray()) {
            sb.add(Character.getNumericValue(cb));
        }
        
        while (!sa.isEmpty() || !sb.isEmpty() || temp != 0) {
            if (!sa.isEmpty()) {
                temp += sa.pop();
            } 
            if (!sb.isEmpty()) {
                temp += sb.pop();
            }
            ans.append(temp % 2);
            if (temp <= 1) {
                temp = 0;
            } else {
                temp = 1;
            }
        }
        return ans.reverse().toString();
    }
}