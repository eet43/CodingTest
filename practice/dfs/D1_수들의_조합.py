import sys
sys.stdin = open("input.txt", "rt")

def DFS(L, s, sum):
  global count
  if L == k:
    if sum%m == 0:
      count += 1
  else:
    for i in range(s, n):
      DFS(L+1, i+1, sum+a[i])
    
   
n, k = map(int, input().split())
a = list(map(int, input().split()))
m = int(input())
count = 0
DFS(0, 0, 0)
print(count)
