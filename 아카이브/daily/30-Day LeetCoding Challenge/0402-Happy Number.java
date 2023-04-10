/**
Happy Number


Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1


401 / 401 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 36.5 MB
**/

class Solution {
    HashSet<Integer> hashSet = new HashSet<>();

    public boolean isHappy(int n) {
        int total = 0;
        int temp = n;
        while (temp != 0) {
            total = total + (temp % 10) * (temp % 10);
            temp /= 10;
        }
        
        if (total == 1) {
            return true;
        } else if (hashSet.contains(n)) {
            return false;
        } else {
            hashSet.add(n);
            return isHappy(total);
        }
    }
}