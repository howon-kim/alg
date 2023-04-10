## FILE INPUT 
import sys
sys.stdin = open("1260.txt", "r")


from collections import deque
n, m, v = map(int, input().split())
graph = [[] for i in range(n + 1)]
for i in range(m):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

for i in range(n + 1):
    graph[i].sort()

def bfs():
    
    que = deque()
    que.append(v)

    while (len(que) != 0):
        curr = que.popleft()

        bfsvisit.append(curr)
        visited.add(curr)
        for index in (graph[curr]):
            if index not in visited and index not in que:
                que.append(index)

def dfs():
    if (len(stack) != 0):
        curr = stack.pop()
        dfsvisit.append(curr)
        visited.add(curr)

        for index in (graph[curr]):
            if (index not in visited and index not in stack):
                stack.append(index)
                dfs()
        
def main():
    global bfsvisit, dfsvisit, stack, visited

    stack = []
    stack.append(v)
    dfsvisit = []
    bfsvisit = []

    visited = set()
    bfs()
    visited = set()
    dfs()
    
    print(*dfsvisit, sep = ' ')
    print(*bfsvisit, sep = ' ')

main()