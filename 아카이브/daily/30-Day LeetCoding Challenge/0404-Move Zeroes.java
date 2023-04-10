/**
Move Zeroes


Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.


21 / 21 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 39.8 MB
 */

 class Solution {
    public void moveZeroes(int[] nums) {
        int numZero = 0; int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[curr++] = nums[i];
            } else {
                numZero++;
            }
        }
        
        
        while (numZero != 0) {
            nums[curr++] = 0;
            numZero--;
        }
    }
}