import sys
from collections import deque
sys.stdin = open("16236.txt", "r")

def getData():
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    '''
    print(n)
    for i in range(n):
        print(*arr[i])
    '''
    return n, arr
    

def getPoint(arr, n):
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 9:
                #print(i, j)
                return (i, j)
    return ()


def solve(point, arr, n):
    global size, food

    ### HOF SUPPORT ####################
    def isAvailable(x, y, dx, dy):
        return  x + dx < n and y + dy < n and x + dx >= 0 and y + dy >= 0 and arr[x + dx][y + dy] <= size and (x + dx, y + dy) not in visited
    
    def isEatable(x, y, dx, dy, arr):
        return  arr[x + dx][y + dy] != 0 and arr[x + dx][y + dy] != 9 and arr[x + dx][y + dy] < size
    ####################################
    

    ### PROPERTY ####################
    que = deque()
    eatable = deque()
    visited = set()
    dist = 0
    #################################

    que.append((point[0], point[1], 0))

    while (len(que) != 0):
        temp = que.popleft()
        visited.add(temp)


        for x, y in ((-1, 0), (0, -1), (1, 0), (0, 1)):
            if isAvailable(temp[0], temp[1], x, y):
                que.append((temp[0] + x, temp[1] + y, temp[2] + 1))
                visited.add((temp[0] + x, temp[1] + y))


                if isEatable(temp[0], temp[1], x, y, arr):
                    eatable.append((temp[0] + x, temp[1] + y, temp[2] + 1))

        
        if len(eatable) != 0:
            finalEat = sorted(eatable, key= lambda x : (x[0], x[1]))[0]
            while (len(que) != 0):
                temp = que.popleft()
                for x, y in ((-1, 0), (0, -1), (1, 0), (0, 1)):
                    if isAvailable(temp[0], temp[1], x, y) and isEatable(temp[0], temp[1], x, y, arr):
                        if temp[2] + 1 > finalEat[2]:
                            break
                        eatable.append((temp[0] + x, temp[1] + y, temp[2] + 1))
            finalEat = sorted(eatable, key= lambda x : (x[0], x[1]))[0]
            #print(sorted(eatable, key= lambda x : (x[0], x[1])))
            dist = finalEat[2]
            #print(finalEat, dist)
            arr[point[0]][point[1]] = 0
            point = (finalEat[0], finalEat[1])
            arr[point[0]][point[1]] = 9
            return dist, point
            
    return 0, 0

def printGrid(n, arr):
    print("###################")
    for i in range(n):
        print(*arr[i])

n, arr = getData()
size = 2
food = 0
point = getPoint(arr, n)
ans = 0

for i in range(n * n):
    d, p = solve(point, arr, n)
    #printGrid(n, arr)
    if d == 0:
        break
    else:
        food += 1
        if size == food:
            food = 0
            size += 1
        point = p
        ans += d
print (ans)


    
