import sys
sys.stdin = open("input.txt", "rt")

def DFS(L, sum):
  global max
  if L == n+1:
    if sum>max:
      max=sum
  else:
    if L+times[L] <= n+1:
      DFS(L+times[L], sum+values[L])
    DFS(L+1, sum)

n= int(input())
values = []
times = []
max = -9999
for _ in range(n):
  time, value = map(int, input().split())
  values.append(value)
  times.append(time)
values.insert(0,0)
times.insert(0,0)
DFS(1,0)
print(max)
