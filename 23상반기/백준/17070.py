## FILE INPUT 
import sys
sys.stdin = open("17070.txt", "r")

'''
DIRECTION
R: Right
D: Down
N: Diagonal
'''
def checkDiag(point):
    return point[1] + 1 < N  and point[0] + 1 < N  and grid[point[0] + 1][point[1]] != 1 and grid[point[0] + 1][point[1] + 1] != 1 and grid[point[0]][point[1] + 1] != 1 

def checkRight(point):
    return point[1] + 1 < N and grid[point[0]][point[1] + 1] != 1

def checkBottom(point):
    return point[0] + 1 < N and grid[point[0] + 1][point[1]] != 1

def dfs(point, dir):
    global count
    if point[0] == N - 1 and point[1] == N - 1:
        count += 1
    else:
        if dir == "R":
            if checkDiag(point):
                newPoint = (point[0] + 1, point[1] + 1)
                dfs(newPoint, 'N')
            if checkRight(point):
                newPoint = (point[0], point[1] + 1)
                dfs(newPoint, 'R')
        elif dir == 'D':
            if checkDiag(point):
                newPoint = (point[0] + 1, point[1] + 1)
                dfs(newPoint, 'N')
            if checkBottom(point):
                newPoint = (point[0] + 1, point[1])
                dfs(newPoint, 'D')
        else:
            if checkDiag(point):
                newPoint = (point[0] + 1, point[1] + 1)
                dfs(newPoint, 'N')
            if checkRight(point):
                newPoint = (point[0], point[1] + 1)
                dfs(newPoint, 'R')
            if checkBottom(point):
                newPoint = (point[0] + 1, point[1])
                dfs(newPoint, 'D')
count = 0
grid = []
N = 0
point = (0, 1)
N = int(input())
for i in range(N):
    row = list(map(int, input().split()))
    grid.append(row)

dfs(point, 'R')
print(count)

