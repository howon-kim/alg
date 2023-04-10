/**
74. Search a 2D Matrix
https://leetcode.com/problems/search-a-2d-matrix/

Submission Performance
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
Memory Usage: 43.5 MB, less than 6.06% of Java online submissions for Search a 2D Matrix.

Description
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
**/

class Solution {
    int index = 0;
    
    public boolean searchMatrix(int[][] matrix, int target) {    
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (binarySearch(matrix, 0, matrix.length, target)) return true;
        return binarySearch2(matrix[index], 0, matrix[index].length, target);
    }
    
    public boolean binarySearch2(int[] matrix, int left, int right, int target) {
        int mid = (right + left) / 2;
        if (mid >= matrix.length || left > right) {
            return false;
        } else if (matrix[mid] == target) {
            return true;
        } else if (matrix[mid] < target) {
            return binarySearch2(matrix, mid + 1, right, target);
        } else {
            return binarySearch2(matrix, left, mid - 1, target);
        }
    }
    
    public Boolean binarySearch(int[][] matrix, int left, int right, int target) {
        int mid = (right + left) / 2;
        if (mid >= matrix.length || left > right) {
            return false;
        } else if (matrix[mid][0] == target) {
            return true;
        } else if (matrix[mid][0] < target) {
            index = mid;
            return binarySearch(matrix, mid + 1, right, target);
        } else {
            return binarySearch(matrix, left, mid - 1, target);
        }
    }
}