import sys
sys.stdin = open("input.txt", "rt")

def DFS(v):
  global count
  if v == n:
    count += 1
    for x in res:
      print(x, end=' ')
    print()
  else:
    for i in range(2, n+1):
      if check[i] == 0:
        if arr[v][i] == 1:
          check[i] = 1
          res.append(i)
          DFS(i)
          res.pop()
          check[i] = 0
  

n, m = map(int, input().split())
arr = [[0]*(n+1) for _ in range(n+1)]
check = [0]*(n+1)
res = [1]
count = 0

for i in range(m):
  s, e = map(int, input().split())
  arr[s][e] = 1

DFS(1)
print(count)
