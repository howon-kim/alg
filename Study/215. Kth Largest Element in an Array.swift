/*
215. Kth Largest Element in an Array | Medium
https://leetcode.com/problems/kth-largest-element-in-an-array/

* My Submission Performance
Runtime: 60 ms, faster than 85.02% of Swift online submissions for Kth Largest Element in an Array.
Memory Usage: 21.4 MB, less than 100.00% of Swift online submissions for Kth Largest Element in an Array.

* Description
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {
    func findKthLargest(_ nums: [Int], _ k: Int) -> Int {
        var sorted = nums;
        sorted.sort();
        return sorted[sorted.count - k]
    }
}