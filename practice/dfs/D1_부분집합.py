 # T = int(input())
# n, s, e, k = map(int, input().split())
# a = list(map(int, input().split()))

import sys
sys.stdin = open("input.txt", "rt")

def DFS(k):
  if k == n+1:
    for i in range(1, n+1):
      if ch[i] == 1:
        print(i, end = ' ')
    print()
  else:
    ch[k] = 1
    DFS(k+1)
    ch[k] = 0
    DFS(k+1)
   
n = int(input())
ch = [0]*(n+1)
DFS(1)
