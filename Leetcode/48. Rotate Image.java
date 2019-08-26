/**
 * 48. Rotate Image | MEDIUM
 * https://leetcode.com/problems/rotate-image/

 * MY SUBMISSION PERFORMANCE
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Rotate Image.
 
 * DESCRIPTION
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * Example 1:
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */

class Solution {
    public void rotate(int[][] matrix) {
        int dim = matrix.length - 1; int pass = matrix.length - 1;
        boolean finish = false;
        int i = 0; int j = 0; int temp = 0; int temp2 = 0;
        while (!finish) {
            temp = matrix[i][dim - j];
            matrix[i][dim - j] = matrix[j][i];
            temp2 = matrix[dim - j][dim - i];
            matrix[dim - j][dim - i] = temp;
            temp = matrix[dim - i][j];
            matrix[dim - i][j] = temp2;
            matrix[j][i] = temp;
            i++;
            if (i == pass) {
                i = ++j;
                pass--;
            }
            if (j >= pass) {
                finish = true;
            }
        }
    }
}