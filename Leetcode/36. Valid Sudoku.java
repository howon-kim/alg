/************************************************************
36. Valid Sudoku | Medium
https://leetcode.com/problems/valid-sudoku/

* My Submission Performance
Runtime: 4 ms, faster than 48.72% of Java online submissions for Valid Sudoku.
Memory Usage: 43.8 MB, less than 81.78% of Java online submissions for Valid Sudoku.

* Description
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

* Example
Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

*************************************************************/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> square = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> rowset = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> colset = new ArrayList<HashSet<Character>>();
        
        for (int i = 0; i < 9; i++) {
            square.add(new HashSet<>());
            rowset.add(new HashSet<>());
            colset.add(new HashSet<>());
        }
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Character temp = board[row][col];
                if (temp != '.') {
                    if (rowset.get(row).contains(temp)) {
                        return false;
                    } else {
                        rowset.get(row).add(temp);
                    }
                    
                    if (colset.get(col).contains(temp)) {
                        return false;
                    } else {
                        colset.get(col).add(temp);
                    }
                    
                    if (square.get(row / 3 + (col / 3 * 3)).contains(temp)) {
                        return false;
                    } else {
                        square.get(row / 3 + (col / 3 * 3)).add(temp);
                    }
                }
            }
        }
        return true;
    }
}