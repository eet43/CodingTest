import sys
from collections import deque
sys.stdin = open("input.txt", "r")

n, k = map(int, input().split())

board = []
vir = []

for i in range(n):
  board.append(list(map(int, input().split())))
  for j in range(n):
    if board[i][j] != 0:
      vir.append((board[i][j], 0, i, j))

s, x, y = map(int, input().split())

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

vir.sort()
Q = deque(vir)

while Q:
  v, t , tx, ty = Q.popleft()
  if t == s:
    break
  for i in range(4):
    sx = tx + dx[i]
    sy = ty + dy[i]
    if 0<= sx < n and 0<= sy < n and board[sx][sy] == 0:
      board[sx][sy] = v
      Q.append((v, t+1, sx, sy))

print(board[x-1][y-1])
