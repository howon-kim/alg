/*****************************************************************
1051. Height Checker | Easy
https://leetcode.com/problems/height-checker/

* Description
Students are asked to stand in non-decreasing order of heights for an annual photo.
Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)

Example 1:

Input: [1,1,4,2,1,3]
Output: 3
Explanation: 
Students with heights 4, 3 and the last 1 are not standing in the right positions.

Note:

1 <= heights.length <= 100
1 <= heights[i] <= 100
*****************************************************************/

/* Swift Version
    Runtime: 16 ms, faster than 87.94% of Swift online submissions for Height Checker.
    Memory Usage: 20.9 MB, less than 100.00% of Swift online submissions for Height Checker. */

class Solution {
    func heightChecker(_ heights: [Int]) -> Int {
        var total = 0
        var sorted = heights
        sorted.sort()
        
        for index in (0...heights.count - 1) {
            if heights[index] != sorted[index] {
                total += 1
            }
        }
        return total;
    }
}

/* Java Version 
Runtime: 1 ms, faster than 91.65% of Java online submissions for Height Checker.
Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Height Checker.

class Solution {
    public int heightChecker(int[] heights) {
        int[] sorted = new int[heights.length];
        System.arraycopy(heights, 0, sorted, 0, heights.length);
        Arrays.sort(sorted);
        int total = 0;
        for (int i = 0 ; i < heights.length; i++){
            if (sorted[i] != heights[i]) {
                total++;
            }
        }
        return total;
    }
}
*/