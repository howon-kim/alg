/**
Product of Array Except Self


Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)


O(n)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        int left = 0; int right = nums.length - 1;
        L[left++] = 1; R[right--] = 1;
        
        for (int i = 1 ; i < nums.length; i++) {
            L[left] = L[left - 1] * nums[left - 1];
            R[right] = R[right + 1] * nums[right + 1];
            left++;
            right--;
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = L[i] * R[i];
        }
        return nums;
    }
}