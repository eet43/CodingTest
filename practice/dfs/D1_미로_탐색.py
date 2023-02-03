import sys
sys.stdin = open("input.txt", "r")
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
  global count
  if x== 6 and y == 6 :
    count += 1
  else:
    for i in range(4):
      xx=x+dx[i]
      yy=y+dy[i]
      if 0<=xx<=6 and 0<=yy<=6 and arr[xx][yy] == 0:
        arr[xx][yy] = 1
        DFS(xx,yy)
        arr[xx][yy] = 0
        
arr = [list(map(int, input().split())) for _ in range(7)]
arr[0][0] = 1
count = 0
DFS(0, 0)
print(count)
