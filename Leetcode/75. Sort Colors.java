/**
 * 75. Sort Colors | Medium | 25 Minutes
 * https://leetcode.com/problems/sort-colors/

 * My Submission Performance
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
 * Memory Usage: 35.3 MB, less than 99.21% of Java online submissions for Sort Colors.

 * Description
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */

class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int first = 0; int third = nums.length - 1; int secondCount = 0; int cur = 0;
        while (cur <= third) {
            if (nums[cur] == 0) {
                nums[first++] = 0;
            } else if (nums[cur] == 1) {
                secondCount++;
            } else {
                if (nums[third] == 0) {
                    nums[third] = 2;
                    nums[first++] = 0;
                } else if (nums[third] == 1) {
                    nums[third] = 2;
                    secondCount++;
                } else {
                    cur--;
                }
                third--;
            }
            cur++;
        }
        for (int i = 0; i < secondCount; i++) {
            nums[first++] = 1;
        }
    }
}