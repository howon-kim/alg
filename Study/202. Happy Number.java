/************************************************************************************
202. Happy Number
https://leetcode.com/problems/happy-number/

* My Submission Performance 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Happy Number.
Memory Usage: 33.3 MB, less than 5.18% of Java online submissions for Happy Number.

* Description
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

* Example: 
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
************************************************************************************/

class Solution {
    public boolean isHappy(int n) {
        int temp = 0; int times = 0;
        while (temp != 1) {
            temp = 0;
            if (times >= 7){
                return false;
            }
            while (n != 0) {
                temp += (int) Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = temp;
            times++;
        }
        return true;
    }
}

public class MainClass {
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            
            boolean ret = new Solution().isHappy(n);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}