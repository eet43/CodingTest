import sys
sys.stdin = open("input.txt", "rt")

def DFS(L, sum, t):
  global max
  if t>limit:
    return
  if L == n:
    if sum>max:
      max = sum
  else:
    DFS(L+1, sum+values[L], t+times[L])
    DFS(L+1, sum, t)


n, limit = map(int, input().split())
values = []
times = []
max = -9999
for _ in range(n):
  value, time = map(int, input().split())
  values.append(value)
  times.append(time)
DFS(0,0,0)
print(max)
