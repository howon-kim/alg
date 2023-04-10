/**
 * 349. Intersection of Two Arrays | Easy | 20 Min
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Performance
 * Runtime: 2 ms, faster than 97.78% of Java online submissions for Intersection of Two Arrays.
 * Memory Usage: 37.5 MB, less than 68.92% of Java online submissions for Intersection of Two Arrays.
 *
 * Description
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 **/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> ht = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 0 ; i < nums1.length; i++) {
            ht.add(nums1[i]);
        }
        for (int j = 0 ; j < nums2.length; j++) {
            if (ht.contains(nums2[j])) {
                ans.add(nums2[j]);
            }
        }
        Iterator<Integer> iter = ans.iterator();
        int [] arr = new int[ans.size()];
        int index = 0;

        while (iter.hasNext()) {
            arr[index++] = iter.next();
        }
        return arr;
    }
}