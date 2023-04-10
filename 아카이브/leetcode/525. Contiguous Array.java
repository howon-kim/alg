/*
525. Contiguous Array | Medium
https://leetcode.com/problems/contiguous-array/


Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.


Runtime: 20 ms, faster than 78.76% of Java online submissions for Contiguous Array.
Memory Usage: 49.4 MB, less than 100.00% of Java online submissions for Contiguous Array.
O(n)
*/

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int total = 0; int max = 0;
        hashMap.put(0, 0);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) total--;
            else total++;
            
            if (!hashMap.containsKey(total)) hashMap.put(total, i + 1);
            else max = Math.max(max, (i + 1) - hashMap.get(total));
        }
        return max;
    }
}
