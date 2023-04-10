import sys
sys.stdin = open("낚시왕.txt", "r")


def getData():
    r, c, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(m)]
    return r, c, m, arr

def printGrid(r, c, m, arr):
    print("R: {}, C: {}, M: {}".format(r, c, m))
    for i in range(m):
        print(*arr[i])


# 딕셔너리 : 포인트 / 제일 큰 사이즈

def initialize(r, c, m, arr):
    global loc, size
    for i in range(m):
        row = arr[i][0]
        col = arr[i][1]
        speed = arr[i][2]
        dir = arr[i][3] # 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽
        size = arr[i][4]

        # 사이즈 비교
        if ((col, row) not in sizes):
            sizes[(col, row)] = size
            if col not in loc:
                loc[col] = {}
            loc[col][row] = arr[i]
        else:
            sizes[(col, row)] = max(sizes[(col, row)], size)
            if size == sizes[(col, row)]:
                loc[col][row] = arr[i]



def printSharks(loc, sizes):
    for col in loc:
        for row in loc[col]:
            print("({}, {})".format(row, col))
            print(loc[col][row])
            print(sizes[(col, row)])



def catchShark(loc, sizes):
    global curr, ans
    #print(sorted(loc[curr]))
    if curr in loc:
        catchCol = curr
        catchRow = sorted(loc[curr])[0]
        ans += sizes[(catchCol, catchRow)]
        sizes.pop((catchCol, catchRow))
        loc[catchCol].pop(catchRow)


def moveShark(loc, sizes):
    newLoc = {}
    newSizes = {}

    for cc in loc:
        for rr in loc[cc]:
            row = loc[cc][rr][0]
            col = loc[cc][rr][1]
            speed = loc[cc][rr][2]
            dir = loc[cc][rr][3]  # 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽
            size = loc[cc][rr][4]


            ## MOVE SEQUENCE ##
            if (dir == 1 or dir == 2):
                speed = speed % ((r - 1) * 2)
                for i in range(speed):
                    if (dir == 1):
                        row -= 1
                        if (row < 1):
                            dir = 2
                            row = row + 2
                    elif (dir == 2):
                        row += 1
                        if (row > r):
                            dir = 1
                            row = row - 2
                    #print(dir, row, col, i, speed)


            else:
                speed = speed % ((c - 1) * 2)
                for i in range(speed):
                    if (dir == 4):
                        col -= 1
                        if (col < 1):
                            dir = 3
                            col = col + 2
                    elif (dir == 3):
                        col += 1
                        if (col > c):
                            dir = 4
                            col = col - 2



            loc[cc][rr][0] = row
            loc[cc][rr][1] = col
            loc[cc][rr][3] = dir

            if (col, row) in newSizes:
                newSizes[(col, row)] = max(newSizes[(col, row)], size)
                if newSizes[(col, row)] == size:
                    newLoc[col][row] = loc[cc][rr]

            else:
                newSizes[(col, row)] = size
                if col not in newLoc:
                    newLoc[col] = {}
                newLoc[col][row] = loc[cc][rr]

    return newLoc, newSizes












r, c, m, arr = getData()
loc = {}
sizes = {}
ans = 0
#printGrid(r, c, m, arr)
initialize(r, c, m, arr)


for curr in range(1, c + 1):
    catchShark(loc, sizes)
    loc, sizes = moveShark(loc, sizes)
    #printSharks(loc, sizes)
    #print("### {}".format(ans))

print(ans)