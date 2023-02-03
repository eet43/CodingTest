import sys
sys.stdin = open("input.txt", "r")
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x,y):
  global count
  count += 1
  home[x][y] = 0
  
  for i in range(4):
    xx = x + dx[i]
    yy = y + dy[i]
    if 0<=xx<n and 0<=yy<n and home[xx][yy] ==1:
      DFS(xx,yy)

n = int(input())
home = [list(map(int, input())) for _ in range(n)]
res = []
for i in range(n):
  for j in range(n):
    if home[i][j] == 1:
      count = 0
      DFS(i, j)
      res.append(count)
print(len(res))
