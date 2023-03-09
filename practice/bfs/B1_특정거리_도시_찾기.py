 # T = int(input())
# n, s, e, k = map(int, input().split())
# a = list(map(int, input().split()))
import sys
from collections import deque
sys.stdin = open("input.txt", "r")

n, m, k, x = map(int, input().split())
board = [[] for _ in range(n+1)]

for _ in range(m):
  a, b = map(int, input().split())
  board[a].append(b)

dis = [0] * (n+1)
Q = deque()
Q.append(x)

while Q:
  s = Q.popleft()
  for i in board[s]:
    if dis[i] == 0:
      dis[i] = dis[s] + 1
      Q.append(i)

flag = False
for i in range(1, n+1):
  if dis[i] == k:
    print(i)
    flag = True

if flag == False:
  print(-1)
      
