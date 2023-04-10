import sys
from collections import deque
sys.stdin = open("16236.txt", "r")
#2:19

def bfs():
    global shark, size, food, totalTime

    que = deque()
    visited = set()
    que.append((shark[0], shark[1], 0))
    visited.add((shark[0], shark[1]))
    while (len(que) != 0):
        temp = que.popleft()
        visited.add((temp[0], temp[1]))

        if grid[temp[0]][temp[1]] != 0 and grid[temp[0]][temp[1]] < size:
            sortt = sorted(que, key=lambda x: (x[2], x[0], x[1]))
            for sort in sortt:
                if  grid[sort[0]][sort[1]] < size and grid[sort[0]][sort[1]] != 0:
                    temp = sort
                    break
            grid[temp[0]][temp[1]] = 0
            visited = set()

            grid[shark[0]][shark[1]] = 0
            shark = (temp[0], temp[1])
            grid[shark[0]][shark[1]] = 9

            print(sortt)
            #print(temp)
            que = deque()
            que.append((temp[0], temp[1], 0))
            food += 1
            if food == size:

                size = min(6, size + 1)
                food = 0
                 
            totalTime += temp[2]
            #print(totalTime, size)
            #for i in range(n):
            #    print(*grid[i])   
        
        print(que)


        if temp[0] - 1 >= 0 and grid[temp[0] - 1][temp[1]] <= size and (temp[0]-1, temp[1]) not in visited:
            que.append((temp[0] - 1, temp[1], temp[2] + 1))
            #visited.add((temp[0]-1, temp[1]))
        if temp[1] - 1 >= 0 and grid[temp[0]][temp[1] - 1] <= size and (temp[0], temp[1]-1) not in visited:
            que.append((temp[0], temp[1] - 1, temp[2] + 1))
            #visited.add((temp[0], temp[1]-1))

        if temp[1] + 1 < n and grid[temp[0]][temp[1] + 1] <= size and (temp[0], temp[1]+1) not in visited:
            que.append((temp[0], temp[1] + 1, temp[2] + 1))
            
            #visited.add((temp[0], temp[1]+1))

        if temp[0] + 1 < n and grid[temp[0] + 1][temp[1]] <= size and (temp[0]+1, temp[1]) not in visited:
            que.append((temp[0] + 1, temp[1], temp[2] + 1))
            #visited.add((temp[0]+1, temp[1]))








dx = [0, 1, 0, -1] # 위 오른 아래 좌
dy = [1, 0, -1, 0]
n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
shark = ()
size = 2
food = 0
totalTime = 0
for row in range(n):
   for col in range(n):
        if grid[row][col] == 9:
            shark = (row, col)
bfs()

print(totalTime)
