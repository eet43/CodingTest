import sys
sys.stdin = open("input.txt", "rt")

def DFS(L, c):
  if L == m:
    for i in range(m):
      print(res[i], end = ' ')
    print()
  else:
    for i in range(c, n+1):
      res[L] = i
      DFS(L+1, c+i)
   
n, m = map(int, input().split())
res = [0]*n
DFS(0, 1)
