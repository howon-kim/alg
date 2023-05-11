class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r = len(matrix)
        c = len(matrix[0])

        for i in range(r):
            if matrix[i][0] <= target and matrix[i][c - 1] >= target:
                if target in matrix[i]:
                    return True
            
        return False
                
