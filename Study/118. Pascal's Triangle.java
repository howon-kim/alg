/**
 * 118. Pascal's Triangle | Easy | 10 Min
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Performance
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
 * Memory Usage: 34.1 MB, less than 7.23% of Java online submissions for Pascal's Triangle.
 *
 * Description
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 **/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == 1) {
                ArrayList<Integer> temp = new ArrayList();
                for (int j = 0; j <= i; j++) {
                    temp.add(1);
                }
                ans.add(temp);
            } else {
                List<Integer> temp = new ArrayList();
                List<Integer> prev = ans.get(i - 1);
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        temp.add(1);
                    } else {
                        temp.add(prev.get(j - 1) + prev.get(j));
                    }
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
