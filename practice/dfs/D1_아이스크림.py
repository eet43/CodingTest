
import sys
sys.stdin = open("input.txt", "r")


n, m = map(int, input().split())
arr = [list(map(int, input())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
  for i in range(4):
    tx = x + dx[i]
    ty = y + dy[i]
    if 0 <= tx < n and 0 <= ty < n and arr[tx][ty] == 0:
      arr[tx][ty] == 1
      DFS(tx, ty)


count = 0

for i in range(n):
  for j in range(m):
    if arr[i][j] == 0:
      DFS(i,j)
      count += 1
      
print(count)

