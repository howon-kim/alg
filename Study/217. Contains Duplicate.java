/**
 * 217. Contains Duplicate | Easy | 5 Min
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Performance
 * Runtime: 9 ms, faster than 54.22% of Java online submissions for Contains Duplicate.
 * Memory Usage: 43.8 MB, less than 68.10% of Java online submissions for Contains Duplicate.
 *
 * Description
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 **/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();

        for (int num: nums) {
            if (!hash.contains(num)) {
                hash.add(num);
            } else {
                return true;
            }
        }
        return false;
    }
}