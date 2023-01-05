import sys
sys.stdin = open("input.txt", "rt")

N = int(input())
num = [list(map(int, input().split())) for _ in range(N)]
num.insert(0, [0]*N)
num.append([0]*N)

for i in range(len(num)):
  num[i].insert(0,0)
  num[i].append(0)

dx = [-1 , 0 , 1, 0]
dy = [0, -1, 0, 1]
count = 0
for i in range(1, N+1):
  for j in range(1,N+1):
    if all(num[i][j] > num[i+dx[k]][j+dy[k]] for k in range(4)):
      count += 1

print(count)
