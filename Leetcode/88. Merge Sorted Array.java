/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Merge Sorted Array.
**/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = nums1.clone();
        int p1 = 0; int p2 = 0; int p3 = 0;
        while (m + n != 0) {
            if (n == 0 || (m > 0 && nums3[p3] <= nums2[p2])) {
                nums1[p1++] = nums3[p3++];
                m --;
            } else {
                nums1[p1++] = nums2[p2++];
                n --;
            }
        }
    }
}