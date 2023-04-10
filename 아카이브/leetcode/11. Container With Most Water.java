/**
11. Container With Most Water | Medium
https://leetcode.com/problems/container-with-most-water/

** Description
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 
Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

** Performance
Runtime: 6 ms, faster than 28.99% of Java online submissions for Container With Most Water.
Memory Usage: 40.1 MB, less than 93.59% of Java online submissions for Container With Most Water.
**/

class Solution {
    public int maxArea(int[] height) {
        PriorityQueue <Integer> ans = new PriorityQueue<>();
        int start = 0; int end = height.length - 1;
        while (start != end) {
            if (height[start] < height[end]) {
                ans.add(-height[start++] * (end - start + 1));
            } else {
                ans.add(-height[end--] * (end - start + 1));
            }
        }
        return -ans.peek();
        
        /** Time Limit Exceed **
        PriorityQueue <Integer> ans = new PriorityQueue<>();
        for (int i = 1; i < height.length; i++) {
            for (int j = 0 ; j < height.length - i; j++) {
                ans.add(Math.min(height[j], height[j + i]) * -i);
            }
        }
        return -ans.peek();
        **/
    }
}