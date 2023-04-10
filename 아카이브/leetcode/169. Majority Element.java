/**
 * 169. Majority Element | EASY | 5 min
 * https://leetcode.com/problems/majority-element/

 * MY SUBMISSION PERFORMANCE
 * Runtime: 13 ms, faster than 29.71% of Java online submissions for Majority Element.
 * Memory Usage: 40.3 MB, less than 99.26% of Java online submissions for Majority Element.

 * DESCRIPTION
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

class Solution {
    public int majorityElement(int[] nums) {

        int times = nums.length / 2;
        HashMap <Integer, Integer> lists = new HashMap<>();

        for (int num: nums) {
            lists.put(num, lists.getOrDefault(num, 0) + 1);
            if (lists.get(num) > times) {
                return num;
            }
        }
        return 0;
    }
}