import sys
sys.stdin = open("input.txt", "rt")

def DFS(L, sum):
  if L == n:
    if sum == (total - sum):
      print("YES")
      sys.exit()
  else:
    DFS(L+1, sum + arr[L])
    DFS(L+1, sum)
   
n = int(input())
arr = list(map(int, input().split()))
total = sum(arr)
DFS(0, 0)
print("NO")
