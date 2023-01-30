import sys
sys.stdin = open("input.txt", "rt")

def DFS(L, sum):
  global min
  if L >= min:
    return
  if sum > total :
    return
  if sum == total :
    if L<min:
      min = L
      return
  
  else:
    for i in range(n):
      DFS(L+1, sum + arr[i])
   
n = int(input())
arr = list(map(int, input().split()))
total = int(input())
min = 9999
arr.sort(reverse=True)
DFS(0, 0)
print(min)
