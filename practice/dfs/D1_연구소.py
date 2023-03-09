 # T = int(input())
# n, s, e, k = map(int, input().split())
# a = list(map(int, input().split()))
import sys
sys.stdin = open("input.txt", "r")
n, m = map(int, input().split())

board = [[0]*m for _ in range(n)]
arr = []
for _ in range(n):
  arr.append(list(map(int, input().split())))


result = 0
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def DFS(count):
  global result
  
  if count == 3:
    for i in range(n):
      for j in range(m):
        board[i][j] = arr[i][j]

    for i in range(n):
      for j in range(m):
        if board[i][j] == 2:
          virus(i, j)
          
    result = max(result, get_score())
    return

  for i in range(n):
    for j in range(m):
      if arr[i][j] == 0:
        arr[i][j] == 1
        count += 1
        DFS(count)
        count -=1
        arr[i][j] == 0

def virus(x, y):
  for i in range(4):
    tx = x + dx[i]
    ty = y + dy[i]
    
    if 0 <= tx < n and 0 <= ty <m and board[tx][ty] == 0:
      board[tx][ty] = 2
      virus(tx, ty)

def get_score():
  score = 0
  for i in range(n):
      for j in range(m):
        if board[i][j] == 0:
          score += 1
  return score

DFS(0)
print(result)
