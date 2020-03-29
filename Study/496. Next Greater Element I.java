/**
496. Next Greater Element I | Easy
https://leetcode.com/problems/next-greater-element-i/

1. Performance
Runtime: 2 ms, faster than 99.17% of Java online submissions for Next Greater Element I.
Memory Usage: 39.7 MB, less than 7.41% of Java online submissions for Next Greater Element I.

2. Description
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:

All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
**/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int i = 0 ; i < nums2.length; i++) {
            hashMap.put(nums2[i], i);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = hashMap.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
            if (ans[i] == 0) {
                ans[i] = -1;
            }
        }
        
        
        /**
        //Mark - Slow Version
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            ans[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
            if (ans[i] == 0) {
                ans[i] = -1;
            }
        }
        
        **/
        return ans;
    }
}