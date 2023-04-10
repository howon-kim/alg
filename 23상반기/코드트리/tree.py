## FILE INPUT 
import sys
import copy
sys.stdin = open("tree.txt", "r")


def growTree():
    for row in range(n):
        for col in range(n):
            if grid[row][col] > 0:
                if row - 1 >= 0 and grid[row - 1][col] > 0:
                    grid[row - 1][col] += 1
                if row + 1 < n and grid[row + 1][col] > 0:
                    grid[row + 1][col] += 1
                if col - 1 >= 0 and grid[row][col - 1] > 0:
                    grid[row][col - 1] += 1
                if col + 1 < n and grid[row][col + 1] > 0:
                    grid[row][col + 1] += 1
            elif grid[row][col] < -1:
                grid[row][col] += 10

def spreadTree():
    global grid
    tempGrid = copy.deepcopy(grid)
    for row in range(n):
        for col in range(n): 
            tempPoint = set()
            if grid[row][col] > 0:
                if row - 1 >= 0 and grid[row - 1][col] == 0:
                    tempPoint.add((row - 1, col))
                if row + 1 < n and grid[row + 1][col] == 0:
                    tempPoint.add((row + 1, col))
                if col - 1 >= 0 and grid[row][col - 1] == 0:
                    tempPoint.add((row, col - 1))
                if col + 1 < n and grid[row][col + 1] == 0:
                    tempPoint.add((row, col + 1))

##  제초제 확인해야함
            if len(tempPoint) != 0:
                tempTree = grid[row][col] // len(tempPoint)
                for point in tempPoint:
                    tempGrid[point[0]][point[1]] += tempTree
    grid = tempGrid

def killTree() -> int:
    global grid
    maxTree = 0
    maxPoint = ()
    for row in (range(n)):
        for col in range(n): 
            if grid[row][col] > 0:
                count = grid[row][col]

                for i in range(1, k + 1):
                    if row - i >= 0 and col - i >= 0 and grid[row-i][col-i] > 0:
                        count += grid[row-i][col-i]
                    else:
                        break
                for i in range(1, k + 1):
                    if row + i < n and col + i < n and grid[row + i][col + i] > 0:
                        count += grid[row+i][col+i]
                    else:
                        break
                for i in range(1, k + 1):
                    if row - i >= 0 and col + i < n and grid[row-i][col+i] > 0:
                        count += grid[row-i][col+i]
                    else:
                        break
                for i in range(1, k + 1):
                    if row + i < n and col - i >= 0 and grid[row+i][col-i] > 0:
                        count += grid[row+i][col-i]
                    else:
                        break
                if count > maxTree:
                    maxPoint = (row, col)
                    maxTree = count

    if len(maxPoint) != 0:  
        row = maxPoint[0]
        col = maxPoint[1]
        grid[row][col] = c
        for i in range(1, k + 1):
            if row - i >= 0 and col - i >= 0:
                if grid[row-i][col-i] > 0:
                    grid[row-i][col-i] = c
                elif grid[row-i][col-i] == 0:
                    grid[row-i][col-i] = c
                    break
                elif grid[row-i][col-i] < -1:
                    grid[row-i][col-i] = c
                    break
                else:
                    break
            else:
                break
        for i in range(1, k + 1):
            if row + i < n and col + i < n:
                if grid[row+i][col+i] > 0:
                    grid[row+i][col+i] = c
                elif grid[row+i][col+i] == 0:
                    grid[row+i][col+i] = c
                    break
                elif grid[row+i][col+i] < -1:
                    grid[row+i][col+i] = c
                    break

                else:
                    break
            else:
                break
        for i in range(1, k + 1):
            if row - i >= 0 and col + i < n:
                if grid[row-i][col+i] > 0:
                    grid[row-i][col+i] = c
                elif grid[row-i][col+i] == 0:
                    grid[row-i][col+i] = c
                    break
                elif grid[row-i][col+i] < -1:
                    grid[row-i][col+i] = c
                    break

                else:
                    break
            else:
                break
        for i in range(1, k + 1):
            if row + i < n and col - i >= 0:
                if grid[row+i][col-i] > 0:
                    grid[row+i][col-i] = c
                elif grid[row+i][col-i] == 0:
                    grid[row+i][col-i] = c
                    break
                elif grid[row+i][col-i] < -1:
                    grid[row+i][col-i] = c
                    break

                else:
                    break
            else:
                break
    return maxTree


n, m, k, c = map(int, input().split())
c *= -10
c -= 10
grid = ([list(map(int, input().split())) for _ in range(n)])
totalDeath = 0
for _ in range(m):
    growTree()
    spreadTree()
    

    totalDeath += killTree()

print(totalDeath)
