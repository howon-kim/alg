/**
1030. Matrix Cells in Distance Order | Easy
https://leetcode.com/problems/matrix-cells-in-distance-order/

1. Submission Performance
Runtime: 14 ms, faster than 49.88% of Java online submissions for Matrix Cells in Distance Order.
Memory Usage: 41.7 MB, less than 18.18% of Java online submissions for Matrix Cells in Distance Order.

2. Description
We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)

 

Example 1:

Input: R = 1, C = 2, r0 = 0, c0 = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (r0, c0) to other cells are: [0,1]
Example 2:

Input: R = 2, C = 2, r0 = 0, c0 = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
Example 3:

Input: R = 2, C = 3, r0 = 1, c0 = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 

Note:

1 <= R <= 100
1 <= C <= 100
0 <= r0 < R
0 <= c0 < C

3. Approach
BFS
**/

class Solution {
    
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Queue<int []> queue = new LinkedList<>();
        boolean [][] isVisited = new boolean[R][C];
        int [][] ans = new int[R * C][2];
        
        queue.add(new int[]{r0, c0});
        int index = 0;
        
        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            if (cur[0] < 0 || cur[0] >= R || cur[1] < 0 || cur[1] >= C) {
                continue;
            }

            if (isVisited[cur[0]][cur[1]]) {
                continue;
            }
            
            isVisited[cur[0]][cur[1]] = true;
            ans[index][0] = cur[0];
            ans[index][1] = cur[1];
            index++;
            
            queue.add(new int[]{cur[0] - 1, cur[1]});
            queue.add(new int[]{cur[0] + 1, cur[1]});
            queue.add(new int[]{cur[0], cur[1] - 1});
            queue.add(new int[]{cur[0], cur[1] + 1});
        }
        
        return ans;
    }
}