import sys
import copy
sys.stdin = open("19236.txt", "r")

def getData():
    fish = [[0 for i in range(4)] for j in range(4)]
    dir = [[0 for i in range(4)] for j in range(4)]
    lineFish = {}

    for i in range(4):
        temp = list(map(int, input().split()))
        index = 0
        for j in range(4):
            fish[i][j] = temp[index]
            dir[i][j] = temp[index + 1]
            lineFish[temp[index]] = (i, j)
            index += 2
    return fish, dir, lineFish

def printData(f, d):
    for i in range(4):
        print(*f[i])
    print("###")
    for i in range(4):
        print(*d[i])

def dfs(fish, dir, lineFish, count, x, y): #
    global answer, shark, stack
    f = copy.deepcopy(fish)
    d = copy.deepcopy(dir)
    l = copy.deepcopy(lineFish)

    def isEatable(xx, yy):
        return xx >= 0 and yy >= 0 and xx < 4 and yy < 4 and f[xx][yy] > 0

    def isAvailable(xx, yy):
        return xx >= 0 and yy >= 0 and xx < 4 and yy < 4

    #print(x, y)
    count += f[x][y]
    l.pop(f[x][y])
    answer = max(answer, count)
    f[x][y] = -1
    f, d, l = moveFish(f, d, l)
    #print(x, y, f[x][y])
    #printData(f, d)

    for i in range(1, 5):
        xx = x + (DIR[d[x][y]][0] * i)
        yy = y + (DIR[d[x][y]][1] * i)

        #print(xx, yy)
        if (isEatable(xx, yy)):
            dfs(f, d, l, count, xx, yy)






def moveFish(fish, dir, lineFish):
    global DIR

    def isAvailable(xx, yy):
        return xx >= 0 and yy >= 0 and xx < 4 and yy < 4 and fish[xx][yy] != -1


    for key in sorted(lineFish):
        x = lineFish[key][0]
        y = lineFish[key][1]
        direction = dir[x][y]

        for _ in range(8):
            xx = x + DIR[direction][0]
            yy = y + DIR[direction][1]
            if isAvailable(xx, yy):
                tempLoc = fish[xx][yy]
                tempDir = dir[xx][yy]
                # FIRST FISH MOVE
                fish[xx][yy] = key
                dir[xx][yy] = direction
                lineFish[key] = (xx, yy)
                # SECOND FISH MOVE
                fish[x][y] = tempLoc
                dir[x][y] = tempDir
                lineFish[tempLoc] = (x, y)

                break
            else:
                direction += 1
                if direction > 8:
                    direction = 1


    return fish, dir, lineFish


## DIRECTION
DIR = [(0,0), (-1, 0), (-1, -1), (0, -1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1)]

ff, dd, ll = getData()
answer = 0
shark = (0,0)
dfs((ff), (dd), (ll), answer, shark[0], shark[1])

print(answer)