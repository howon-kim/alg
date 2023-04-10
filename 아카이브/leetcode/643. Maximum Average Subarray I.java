/**
643. Maximum Average Subarray I | Easy
https://leetcode.com/problems/maximum-average-subarray-i/


Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 

Note:

1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].


Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Average Subarray I.
Memory Usage: 43 MB, less than 53.85% of Java online submissions for Maximum Average Subarray I.
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = 0;
        int count = 0;
        
        for (int i = 0; i < k; i++) {
            count += nums[i];    
        }
        
        max = count;
        
        for (int i = k; i < nums.length; i++) {


            count = count - nums[i - k] + nums[i];
            if (max < count) max = count;
        }
        


        
        return (double) max / k;
    }
}