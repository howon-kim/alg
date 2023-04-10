/**
Minimum Path Sum


Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.


61 / 61 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 42.3 MB
**/


class Solution {
    public int minPathSum(int[][] grid) {
    // Dynamic Programming
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
    /* Stack Overflow
    public void helper(int[][] grid, int row, int col, int sum) {
        sum += grid[row][col];
        if (sum < min) {
          if (row == grid.length - 1 && col == grid[0].length - 1) {
              if (sum < min) min = sum;
          } else if (row == grid.length - 1) {
              helper(grid, row, col + 1, sum);
          } else if (col == grid[0].length - 1) {
              helper(grid, row + 1, col, sum);
          } else {
              helper(grid, row + 1, col, sum);
              helper(grid, row, col + 1, sum);
          }
        }
    */
  }