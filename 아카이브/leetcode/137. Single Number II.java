/**
 * 137. Single Number II | Medium
 * https://leetcode.com/problems/single-number-ii/

 * My Submission Performance
 * Runtime: 6 ms, faster than 11.54% of Java online submissions for Single Number II.
 * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Single Number II.

 * Description
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int num : nums) {
            if (numbers.containsKey(num)) {
                numbers.replace(num, numbers.get(num) + 1);
                if (numbers.get(num) == 3) {
                    numbers.remove(num);
                }
            } else {
                numbers.put(num, 1);
            }
        }
        return  numbers.entrySet().iterator().next().getKey();
    }
}