/**
 * 350. Intersection of Two Arrays II | EASY | 25 min
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/

 * MY SUBMISSION PERFORMANCE
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Intersection of Two Arrays II.
 * Memory Usage: 37.3 MB, less than 83.87% of Java online submissions for Intersection of Two Arrays II.

 * DESCRIPTION
 * Given two arrays, write a function to compute their intersection.
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> answer = new ArrayList<>();
        int index1 = 0; int index2 = 0; int index3 = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums2[index2] == nums1[index1]) {
                nums1[index3] = nums1[index1];
                index1++; index2++; index3++;
            } else if (nums2[index2] > nums1[index1]) {
                index1++;
            } else {
                index2++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, index3);
    }
}